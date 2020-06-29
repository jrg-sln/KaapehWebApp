package mx.unam.iimas.controller;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import mx.unam.iimas.model.LogAccess;
import mx.unam.iimas.model.User;
import mx.unam.iimas.model.Worker;
import mx.unam.iimas.service.LogAccessService;
import mx.unam.iimas.service.PermissionService;
import mx.unam.iimas.service.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@Autowired
	private WorkerService service;
	
	@Autowired
	private LogAccessService logService;
	
	@ModelAttribute("userForm")
	public User setUserForm() {
		return new User();
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin(Map<String, Object> model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String usr = (String) session.getAttribute("user");
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), usr, request.getRequestURI());
		logService.saveLogAccess(log);
		
		User user = new User();
		model.put("userForm", user);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("userForm") User userForm, BindingResult result, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String usr = (String) session.getAttribute("user");
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), usr, request.getRequestURI());
		logService.saveLogAccess(log);
		
		if (result.hasErrors()) {
			return "login";
		}
		
		try {
			userForm.setPassword(User.toHexString(User.getSHA(userForm.getPassword())));
		} catch(NoSuchAlgorithmException nsae) {
			model.addAttribute("message", "Error al procesar la contraseña.");
			return "login";
		}
		
		List<Worker> theWorkers = service.getWorkers();
		for (Worker w: theWorkers) {
			if (w.getEmail().equals(userForm.getEmail()) && w.getPwd().equals(userForm.getPassword())) {
				session.setAttribute("user", w.getEmail());
				session.setAttribute("type", w.getUsertype());
				session.setAttribute("area", w.getUserarea());
				
				return "home";
			}
		}

        model.addAttribute("message", "Usuario o contraseña incorrectos.");
        model.addAttribute("user", userForm);
        
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String usr = (String) session.getAttribute("user");
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), usr, request.getRequestURI());
		logService.saveLogAccess(log);
		
		session.invalidate();
		
		return "home";
	}
}