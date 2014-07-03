package com.github.json.ui.control;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

public class JsonTreeViewer extends TreeViewer {

	private static final String[] clms = new String[]{"Key", "Value"};
	
	public JsonTreeViewer(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
	}

	public JsonTreeViewer(Composite parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	public JsonTreeViewer(Tree tree) {
		super(tree);
		// TODO Auto-generated constructor stub
	}
	
	public void addColumns(){
		Tree tree = getTree();
		for(String c : clms){
			TreeColumn tc = new TreeColumn(tree, SWT.None);
			tc.setText(c);
			tc.setWidth(200);
		}
		setColumnProperties(clms);
	}

}
