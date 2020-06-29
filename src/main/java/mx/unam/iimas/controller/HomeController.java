package mx.unam.iimas.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.unam.iimas.model.LogAccess;
import mx.unam.iimas.service.LogAccessService;

@Controller
public class HomeController {

	@Autowired
	private LogAccessService service;
	
	@RequestMapping("/home")
    public String home(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		LogAccess log = new LogAccess(request.getRemoteAddr(), LocalDateTime.now().toString(), user, request.getRequestURI());
		service.saveLogAccess(log);
		
        return "home";
    }
}
