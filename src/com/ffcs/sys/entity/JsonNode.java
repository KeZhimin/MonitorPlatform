package com.ffcs.sys.entity;

import java.util.List;

public class JsonNode {
  
	 private String text;
	 private List<JsonNode> nodes;
	 private Integer href;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<JsonNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<JsonNode> nodes) {
		this.nodes = nodes;
	}

	public Integer getHref() {
		return href;
	}
	public void setHref(Integer href) {
		this.href = href;
	}
	
	@Override
	public String toString() {
		return "JsonNode [text=" + text + ", nodes=" + nodes + ", href=" + href+
				 "]";
	}
	
}
