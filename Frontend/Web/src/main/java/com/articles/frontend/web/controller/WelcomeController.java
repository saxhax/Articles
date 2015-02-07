package com.articles.frontend.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.articles.frontend.web.handler.LanguageHandler;
import com.articles.frontend.web.util.Constants;
import com.articles.frontend.web.util.Template;
import com.articles.frontend.web.util.Util;

@ComponentScan
@Controller
public class WelcomeController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage(HttpServletRequest request) {

		String language = Util.getLanguage(request);
		Template template = Util.getTemplate(request);
		ModelAndView model;
		try {
			model = new LanguageHandler().fillModel(language);
			model.addObject("language", language);
			model.addObject("template", template);
			model.setViewName(Constants.INDEX);
		} catch (IOException e) {
			model = new ModelAndView();
			model.setViewName(Constants.ERROR);
		}
		return model;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Limit Login - XML");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, 
			HttpServletRequest request) {

		String language = Util.getLanguage(request);
		Template template = Util.getTemplate(request);
		ModelAndView model;
		try {
			model = new LanguageHandler().fillModel(language);
			model.addObject("language", language);
			model.addObject("template", template);
			model.setViewName(Constants.INDEX);
		} catch (IOException e) {
			model = new ModelAndView();
			model.setViewName(Constants.ERROR);
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}
		return model;
	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("pages/403");
		return model;

	}

}