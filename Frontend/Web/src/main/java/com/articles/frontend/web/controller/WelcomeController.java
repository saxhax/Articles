package com.articles.frontend.web.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.articles.frontend.web.handler.LanguageHandler;
import com.articles.frontend.web.util.Constants;
import com.articles.frontend.web.util.Template;
import com.articles.frontend.web.util.Util;

@ComponentScan
@Controller
public class WelcomeController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage(HttpServletRequest request, Principal principal) {

		ModelAndView model;
		String language = Util.getLanguage(request);
		Template template = Util.getTemplate(request);
		try {
			model = new LanguageHandler().fillModel(language);
			model.addObject("language", language);
			model.addObject("template", template);
			if (principal != null) {
				checkUserSession(request, model, principal);
			}
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

	private void checkUserSession(HttpServletRequest request, ModelAndView model, Principal principal) {
		String name = principal.getName();
		Object userSessionObject = request.getSession().getAttribute("username");
		String sessionUser = userSessionObject != null ? userSessionObject.toString() : null;
		if (sessionUser != null && !sessionUser.isEmpty()) {
			if (name != null && !name.isEmpty()) {
				if (!name.equals(sessionUser)) {
					request.getSession().setAttribute("username", null);
				} else {
					model.addObject("username", name);
				}
			} else {
				request.getSession().setAttribute("username", null);
			}
		} else {
			request.getSession().setAttribute("username", name);
			model.addObject("username", name);
		}
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