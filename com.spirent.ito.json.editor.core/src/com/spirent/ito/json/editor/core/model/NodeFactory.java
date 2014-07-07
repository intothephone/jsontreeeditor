package com.spirent.ito.json.editor.core.model;

import com.fasterxml.jackson.databind.JsonNode;

public class NodeFactory {
	public static INodeElement createNode(String key, JsonNode node, INodeElement parent){
		return new NodeElement(key, node, parent);
	}
}
