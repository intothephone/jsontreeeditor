package com.spirent.ito.json.editor.ui.providers;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.spirent.ito.json.editor.core.model.INodeElement;

public class JsonContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof INodeElement){
			INodeElement parent = (INodeElement)parentElement;
			return parent.getChildNodes().toArray(new INodeElement[0]);
		} else {
			return new Object[0];
		}
	}

	@Override
	public Object getParent(Object element) {
		if(element instanceof INodeElement){
			INodeElement ele = (INodeElement)element;
			return ele.getParentNode();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

}
