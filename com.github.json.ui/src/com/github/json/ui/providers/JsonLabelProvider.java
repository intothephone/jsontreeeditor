package com.github.json.ui.providers;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.json.core.model.INodeElement;

public class JsonLabelProvider extends BaseLabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof INodeElement){
			INodeElement node = (INodeElement)element;
			return columnIndex == 0 ? node.getKey() : node.getValue();
		}
		return "";
	}

}
