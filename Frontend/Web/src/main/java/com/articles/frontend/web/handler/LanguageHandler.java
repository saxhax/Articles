package com.articles.frontend.web.handler;

import java.util.Map.Entry;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.servlet.ModelAndView;

import com.articles.frontend.web.util.Constants;

public class LanguageHandler {
	
	public LanguageHandler(){}
	
	public Properties getLanguage(String language) throws IOException {
		Properties properties = PropertiesLoaderUtils.loadAllProperties(Constants.LANGUGES_LOCATION + language + ".properties");
		if (properties.keySet().size() == 0) {
			return PropertiesLoaderUtils.loadAllProperties(Constants.LANGUGES_LOCATION + Constants.DEFAULT_LANGUAGE + ".properties");
		}
		return properties;
	}

	public ModelAndView fillModel(String language) throws IOException {
		Properties properties = getLanguage(language);
		ModelAndView modelAndView = new ModelAndView();
		for (Entry<Object, Object> propertie : properties.entrySet()){
			modelAndView.addObject(propertie.getKey().toString(), propertie.getValue().toString());
		}
		return modelAndView;
	}
}
