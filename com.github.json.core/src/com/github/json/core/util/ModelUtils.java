package com.github.json.core.util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.github.json.core.model.INodeElement;
import com.github.json.core.model.NodeFactory;

public class ModelUtils {
	public static INodeElement constructModel(InputStream is) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(is);
		INodeElement nodeRoot = NodeFactory.createNode(root, null);
		populateNodes(nodeRoot, root);
		return nodeRoot;
	}
	
	private static void populateNodes(INodeElement parent, JsonNode parentNode){
		if(parentNode.getNodeType() == JsonNodeType.ARRAY){
			int size = ((ArrayNode)parentNode).size();
			for(int i = 0; i < size; i++){
				String key = String.valueOf(i);
				JsonNode node = ((ArrayNode)parentNode).path(i);
				createSubNodes(parent, node);
			}
		} else {
			for(Iterator<Entry<String, JsonNode>> it = parentNode.fields(); it.hasNext();){
				Entry<String, JsonNode> e = it.next();
				String key = e.getKey();
				JsonNode node = e.getValue();
				createSubNodes(parent, node);
			}
		}
	}
	
	private static void createSubNodes(INodeElement parent, JsonNode node){
		INodeElement newParent = NodeFactory.createNode(node, parent);
		switch(node.getNodeType()){
		case ARRAY:
		case OBJECT:
			populateNodes(newParent, node);
			break;
			default:
		}
	}
}
