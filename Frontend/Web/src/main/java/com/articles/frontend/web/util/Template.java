package com.articles.frontend.web.util;

import java.util.HashMap;
import java.util.Map;

public class Template {
	
	private String name;
	private String background;
	private static Map<String, Template> templates = new HashMap<String, Template>();
	
	static {
		templates.put("red", new Template("red", "#f77"));
		templates.put("green",  new Template("green", "#7f7"));
		templates.put("blue",  new Template("blue", "#77f"));
		templates.put("white",  new Template("white", "white"));
		templates.put("grey",  new Template("grey", "grey"));
	}
	
	public Template(String name, String background) {
		this.name = name;
		this.background = background;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBackground() {
		return background;
	}
	
	public void setBackground(String background) {
		this.background = background;
	}

	public static Template getTemplate(String name) {
		if (name != null && templates.containsKey(name.toLowerCase().trim())) {
			return templates.get(name);
		} else {
			return templates.get(Constants.DEFAULT_TEMPALTE);
		}
	}
}