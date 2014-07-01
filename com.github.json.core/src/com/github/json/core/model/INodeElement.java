package com.github.json.core.model;

import com.fasterxml.jackson.databind.JsonNode;

public interface INodeElement {
	
	public INodeElement getParentNode();
	
	public INodeElement[] getChildNodes();
	
	public JsonNode getNode();
	
	public NodeType getType();
	
	public String getKey();
	
	public String getValue();
	
}
