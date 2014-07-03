package com.github.json.core.model;

import com.fasterxml.jackson.databind.JsonNode;

public class NodeFactory {
	public static INodeElement createNode(JsonNode node, INodeElement parent){
		return new NodeElement(node, parent);
	}
}
