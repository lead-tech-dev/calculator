package com.leszko.calculator;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CalculatorController {
	
	@Autowired
	private Calculator calculator;
	
	@RequestMapping("/sum")
	public String sum(@RequestParam("a") int a, @RequestParam("b") int b) {
		return String.valueOf(calculator.sum(a, b));
	}
	
	
}
