package com.github.json.core.model;

import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;

public interface INodeElement {
	
	public INodeElement getParentNode();
	
	public Collection<INodeElement> getChildNodes();
	
	public void addChildNode(INodeElement child);
	
	public void removeChildNode(String key);
	
	public JsonNode getNode();
	
	public NodeType getType();
	
	public String getKey();
	
	public String getValue();
	
}
