package com.github.json.ui.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.github.json.ui.control.JsonTreeViewer;
import com.github.json.ui.providers.JsonContentProvider;
import com.github.json.ui.providers.JsonLabelProvider;

public class JsonEditor extends EditorPart {
	
	private JsonTreeViewer viewer;

	public JsonEditor() {
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new JsonTreeViewer(parent);
		viewer.setContentProvider(new JsonContentProvider());
		viewer.setLabelProvider(new JsonLabelProvider());
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
