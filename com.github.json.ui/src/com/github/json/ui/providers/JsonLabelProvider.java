package com.github.json.ui.providers;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.github.json.core.model.INodeElement;

public class JsonLabelProvider extends BaseLabelProvider implements ITableLabelProvider, ILabelProvider {

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

	@Override
	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(Object element) {
		return getColumnText(element, 0) + " " + getColumnText(element, 1);
	}

}
