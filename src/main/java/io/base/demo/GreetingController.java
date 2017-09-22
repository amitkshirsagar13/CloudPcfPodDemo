package io.base.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/******************************************************************************
 * Copyright (c) 2017 amit.kshirsagar.13@gmail.com to Present.
 * All rights reserved.
 *****************************************************************************/

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName demo
 * Creation date: Sep 22, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Value("${server.address}")
	private String serverName = null;

	@Value("${server.port}")
	private String serverPort = null;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		StringBuilder msg = new StringBuilder();
		msg.append(name);
		msg.append(" from: ");
		msg.append(serverName);
		msg.append(":");
		msg.append(serverPort);
		msg.append("!!!");
		return new Greeting(counter.incrementAndGet(), String.format(template, msg));
	}
}