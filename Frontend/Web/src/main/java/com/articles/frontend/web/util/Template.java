package com.articles.frontend.web.util;

import java.util.HashMap;
import java.util.Map;

public class Template {
	
	private String name;
	private String background;
	private static Map<String, Template> templates = new HashMap<String, Template>();
	
	static {
		templates.put("red1", new Template("red1", "#f77"));
		templates.put("red2", new Template("red2", "#f99"));
		templates.put("red3", new Template("red3", "#fbb"));

		templates.put("green1",  new Template("green1", "#7f7"));
		templates.put("green2",  new Template("green2", "#9f9"));
		templates.put("green3",  new Template("green3", "#bfb"));

		templates.put("blue1",  new Template("blue1", "#77f"));
		templates.put("blue2",  new Template("blue2", "#99f"));
		templates.put("blue3",  new Template("blue3", "#bbf"));

		templates.put("white1",  new Template("white1", "white"));
		templates.put("white2",  new Template("white2", "#ffa"));
		templates.put("white3",  new Template("white3", "#faf"));

		templates.put("grey1",  new Template("grey1", "grey"));
		templates.put("grey2",  new Template("grey2", "#999"));
		templates.put("grey3",  new Template("grey3", "#aaa"));
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
