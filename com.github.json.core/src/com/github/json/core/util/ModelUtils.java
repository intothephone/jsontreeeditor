package com.github.json.core.util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
		for(Iterator<Entry<String, JsonNode>> it = parentNode.fields(); it.hasNext();){
			Entry<String, JsonNode> e = it.next();
			String key = e.getKey();
			JsonNode node = e.getValue();
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
}
