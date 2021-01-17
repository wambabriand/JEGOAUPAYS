package com.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
/*
@Component
public class MyFilter implements Filter{

	public MyFilter() {
		System.out.println("le filtre prend place");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse myresponse = (HttpServletResponse) response;
		myresponse.setHeader("Access-Control-Allow-Origin", "*");
		myresponse.setHeader("Access-Control-Allow-Credentials", "true");
		myresponse.setHeader("Access-Control-Allow-Methods", "GET, POST , OPTIONS ,DELETE");
		myresponse.setHeader("Access-Control-Allow-Max-Age", "5000");
		
		System.out.println("je suis l");
		System.out.println(request.toString());
		chain.doFilter(request, response);
		
	}
}
*/