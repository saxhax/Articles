package com.articles.frontend.web.util;

import javax.servlet.http.HttpServletRequest;

public class Util {
	
	public static String getLanguage(HttpServletRequest request) {
		String language = Constants.DEFAULT_LANGUAGE;
		try {
			language = request.getParameter("language");
			if (language != null && !language.isEmpty()) {
				for (String availableLanguage : Constants.AVALIABLE_LANGUGES) {
					if (availableLanguage.equalsIgnoreCase(language)) {
						return availableLanguage;
					}
				}
				language = Constants.DEFAULT_LANGUAGE;
			} else {
				language = request.getSession().getAttribute("language").toString();
				if (language == null || language.length() != 2) {
					language = Constants.DEFAULT_LANGUAGE;
				}
			}
		} catch(Exception e) {
			language = Constants.DEFAULT_LANGUAGE;
		} finally {
			request.getSession().setAttribute("language", language);
		}
		return language;
	}

	public static Template getTemplate(HttpServletRequest request) {
		String template = Constants.DEFAULT_TEMPALTE;
		try {
			try {
				String sessionTemplate = request.getSession().getAttribute("template").toString();
				if (sessionTemplate != null && !sessionTemplate.isEmpty()) {
					template = sessionTemplate;
				}
			} catch (Exception e) {}

			String parameterTemplate = request.getParameter("template");
			if (parameterTemplate != null && !parameterTemplate.isEmpty()) {
				template = parameterTemplate;
			}
		} catch(Exception e) {
			template = Constants.DEFAULT_TEMPALTE;
		} finally {
			request.getSession().setAttribute("template", template);
		}
		return Template.getTemplate(template);
	}
}
