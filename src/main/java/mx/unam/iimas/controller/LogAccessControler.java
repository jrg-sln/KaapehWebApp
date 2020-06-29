package mx.unam.iimas.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.unam.iimas.model.LogAccess;
import mx.unam.iimas.service.LogAccessService;
import mx.unam.iimas.service.PermissionService;

@Controller
public class LogAccessControler {
	
	@Autowired
	private LogAccessService logService;
	
	@Autowired
	private PermissionService permissionService;

	@RequestMapping("/log")
	public String listWorker(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String usr = (String) session.getAttribute("user");
		Integer type = (Integer) session.getAttribute("type");
		
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), usr, request.getRequestURI());
		logService.saveLogAccess(log);
		
		if (usr != null && !permissionService.hasAccessTo(type, request.getRequestURI())) {
			return "redirect:/home";
		}
		
		List<LogAccess> listAccess = logService.getAllLogAccess();
		model.addAttribute("accessLog", listAccess);
		
		return "list_access";
	}
}
