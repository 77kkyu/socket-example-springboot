package com.example.socketexamplespring.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class socketController {

	@RequestMapping("/chat")
	public String chat(Model model) {
		log.info("chat api start");
		return "main";
	}

}
