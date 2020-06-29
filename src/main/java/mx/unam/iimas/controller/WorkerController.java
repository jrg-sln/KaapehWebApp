package mx.unam.iimas.controller;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.unam.iimas.model.Worker;
import mx.unam.iimas.service.LogAccessService;
import mx.unam.iimas.service.WorkerService;
import mx.unam.iimas.model.LogAccess;
import mx.unam.iimas.model.User;

@Controller
//@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	private WorkerService service;
	
	@Autowired
	private LogAccessService logService;
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	
	@RequestMapping("/listWorkers")
	public String listWorker(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), user, request.getRequestURI());
		logService.saveLogAccess(log);
		
		Integer type = (Integer) session.getAttribute("type");
		Integer area = (Integer) session.getAttribute("area");
		if (type == 1) {
			List<Worker> theWorkers = service.getWorkers();
			model.addAttribute("workers", theWorkers);
		} else {
			List<Worker> theWorkers = service.getWorkersByArea(area);
			model.addAttribute("workers", theWorkers);
		}
		
		return "list_workers";
	}
	
	@RequestMapping("/addWorker")
	public String createNewWorker(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), user, request.getRequestURI());
		logService.saveLogAccess(log);
		
		model.addAttribute("worker", new Worker());
		
		return "add_worker";
	}
	
	@RequestMapping("/saveWorker")
	public String saveWorker(@Valid @ModelAttribute("worker") Worker worker, BindingResult result, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), user, request.getRequestURI());
		logService.saveLogAccess(log);
		
		if (result.hasErrors()) {
            return "add_worker";
        }
		
		List<Worker> theWorkers = service.getWorkers();
		for (Worker w : theWorkers) {
			if (w.getEmail().equals(worker.getEmail())) {
				model.addAttribute("message", "El correo ya fue registrado, favor de verificar.");
				return "add_worker";
			}
		}
		try {
			worker.setPwd(User.toHexString(User.getSHA(worker.getPwd())));
		} catch(NoSuchAlgorithmException nsae) {
			model.addAttribute("message", "Error al procesar la contraseña.");
			return "add_worker";
		}
		worker.setCreated(LocalDateTime.now());
    	service.saveWorker(worker);
    	model.addAttribute("message", "Usuario agregado correctamente");
        return "redirect:/listWorkers";
	}
	
	@RequestMapping("/updateWorker")
	public String updateWorker(@RequestParam("workerId") long id, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), user, request.getRequestURI());
		logService.saveLogAccess(log);
		
		Worker worker = service.getWorker(id);	
		model.addAttribute("worker", worker);
		return "update_worker";
	}
	
	@RequestMapping("/saveUpdateWorker")
	public String saveUpdateWorker(@Valid @ModelAttribute("worker") Worker worker, BindingResult result, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), user, request.getRequestURI());
		logService.saveLogAccess(log);
		
		if (result.hasErrors()) {
            return "update_worker";
        }
		
		List<Worker> theWorkers = service.getWorkers();
		for (Worker w : theWorkers) {
			if (w.getEmail().equals(worker.getEmail()) && w.getId() != worker.getId()) {
				model.addAttribute("message", "El correo ya fue registrado, favor de verificar.");
				return "update_worker";
			}
			if (w.getId() == worker.getId()) {
				if (!w.getPwd().equals(worker.getPwd())) {
					try {
						worker.setPwd(User.toHexString(User.getSHA(worker.getPwd())));
					} catch(NoSuchAlgorithmException nsae) {
						model.addAttribute("message", "Error al procesar la contraseña.");
						return "update_worker";
					}
				}
			}
		}
		
    	service.saveWorker(worker);
    	model.addAttribute("message", "Cambios realizados correctamente");
        return "redirect:/listWorkers";
	}
	
	@RequestMapping("/deleteWorker")
	public String deleteCustomer(@RequestParam("workerId") long id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), user, request.getRequestURI());
		logService.saveLogAccess(log);
		
		service.deleteWorker(id);
		return "redirect:/listWorkers";
	}
	
	// List catalogs to set up a new worker
	@ModelAttribute("areasList")
    public Map<Integer, String> getUserAreas() {
		Map<Integer, String > userAreas = new HashMap<Integer, String>();
		userAreas.put(1, "DIRECCION");
		userAreas.put(2, "SISTEMAS");
		userAreas.put(3, "CONTABILIDAD");
		
		return userAreas;
	}
	
	@ModelAttribute("typesList")
    public Map<Integer, String> getUserTypes() {
		Map<Integer, String > userTypes = new HashMap<Integer, String>();
		userTypes.put(1, "ADMINISTRADOR");
		userTypes.put(2, "SUPERVISOR");
		userTypes.put(3, "TRABAJADOR");
		
		return userTypes;
	}
}
