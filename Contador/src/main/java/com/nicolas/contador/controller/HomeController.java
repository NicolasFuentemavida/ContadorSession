package com.nicolas.contador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	private int contador = 0;
	private int login;
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
	
	private int session(HttpSession session, int tipo) {
		session.setAttribute("count", 0);
		Integer count = (Integer) session.getAttribute("count");
		if(tipo == 1) {
			contador++;
		}else if(tipo == 2) {
			contador += 2; 
		}
		return this.contador;
	}

	@RequestMapping("/")	
	public String index(HttpSession x) {
		session(x, 1);
		return "index.jsp";
	} 
	
	@RequestMapping("/counter")	
	public String mostrarContador(Model dato) {
		dato.addAttribute("contador", getContador());
		return "contador.jsp";
	}
	@RequestMapping("/counterdoble")	
	public String mostrarContadordoble(HttpSession x) {
		session(x, 2);
		return "incrementodoble.jsp";
	}
	
	@RequestMapping("/reestablecer")	
	public String mostrarContadordoble() {
		setContador(0);
		return "restablecer.jsp";
	}

}