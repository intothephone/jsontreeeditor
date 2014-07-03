package com.github.json.core.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

public class NodeElement implements INodeElement{

	private JsonNode node;
	
	private INodeElement parent;
	
	private Map<String, INodeElement> childNodes;
	

	public NodeElement(JsonNode node, INodeElement parent) {
		super();
		this.node = node;
		this.parent = parent;
		if(parent != null){
			parent.addChildNode(this);
		}
		childNodes = new HashMap<String, INodeElement>();
	}

	@Override
	public INodeElement getParentNode() {
		return parent;
	}

	@Override
	public Collection<INodeElement> getChildNodes() {
		return childNodes.values();
	}

	@Override
	public JsonNode getNode() {
		return node;
	}

	@Override
	public NodeType getType() {
		JsonNodeType type = node.getNodeType();
		switch(type){
		case ARRAY:
			return NodeType.ARRAY;
		case BOOLEAN:
			return NodeType.BOOLEAN;
		case NULL:
			return NodeType.NULL;
		case NUMBER:
			return NodeType.NUMBER;
		case OBJECT:
			return NodeType.OBJECT;
		case STRING:
			return NodeType.STRING;
		default:
		}
		return NodeType.UNKNOWN;
	}

	@Override
	public String getKey() {
		if(parent != null){
			for(Iterator<Entry<String, JsonNode>> it = parent.getNode().fields(); it.hasNext();){
				Entry<String, JsonNode> e = it.next();
				if(getNode().equals(e.getValue())){
					return e.getKey();
				}
			}
		}
		return null;
	}

	@Override
	public String getValue() {
		return getNode().asText();
	}

	@Override
	public void addChildNode(INodeElement child) {
		childNodes.put(child.getKey(), child);
	}

	@Override
	public void removeChildNode(String key) {
		childNodes.remove(key);
	}
	
}
