package com.wipro.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.utils.StringSplitUtils;

@RestController
public class HelloController {

		
	@GetMapping("/getCabeceras")
	public Map<String, List<String>> getHeaders4(HttpServletRequest request) {
		
		Enumeration<String> headerNames = request.getHeaderNames();
		Map<String, List<String>> mapHeader = Collections.list(headerNames).stream().collect(Collectors.toMap(
	            e -> e,
	            e -> {
	            	List<String> list = Arrays.asList(StringSplitUtils.split(request.getHeader( e)));
	            	
	            	return list;
	            }
	        ));
		return mapHeader;
	}
	 
	@PostMapping("/getCabecerasByLista")
	public Map<String, List<String>> getHeaders4(HttpServletRequest request, @RequestBody List<String> headerNames) {
		
		Enumeration<String> headerNamesReq = request.getHeaderNames();
		Map<String, List<String>> mapHeader = Collections.list(headerNamesReq).stream().collect(Collectors.toMap(
	            e -> e,
	            e -> {
	            	List<String> list = Arrays.asList(StringSplitUtils.split(request.getHeader( e)));
	            	return list;
	            }
	        ));
		
	    

		Map<String, List<String>> mapHeaderRs = null;
		 mapHeaderRs = mapHeader.entrySet().stream()
	            .filter(x ->  headerNames.contains(x.getKey()))
	            .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
	 

		return mapHeaderRs;
	}
	
}
