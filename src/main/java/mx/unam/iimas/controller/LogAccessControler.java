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

@Controller
public class LogAccessControler {
	
	@Autowired
	private LogAccessService service;

	@RequestMapping("/log")
	public String listWorker(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), user, request.getRequestURI());
		service.saveLogAccess(log);
		
		List<LogAccess> listAccess = service.getAllLogAccess();
		model.addAttribute("accessLog", listAccess);
		
		return "list_access";
	}
}
