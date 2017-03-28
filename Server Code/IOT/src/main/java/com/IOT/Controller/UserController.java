package com.IOT.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pi4j.io.serial.Baud;
import com.pi4j.io.serial.DataBits;
import com.pi4j.io.serial.FlowControl;
import com.pi4j.io.serial.Parity;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialConfig;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.StopBits;

@Controller
public class UserController {
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model mod, HttpServletRequest req)
	{
		System.out.println("This is login page...");
		return "login";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home()
	{
		System.out.println("Hello Xbee home...");
		return "home";
		
	}
}
