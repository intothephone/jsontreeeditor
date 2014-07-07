package com.spirent.ito.json.editor.ui.control;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

public class JsonTreeViewer extends FilteredTree {

	private static final String[] clms = new String[]{"Key", "Value"};
	
	public JsonTreeViewer(Composite parent, boolean useNewLook) {
		super(parent, useNewLook);
		// TODO Auto-generated constructor stub
	}

	public JsonTreeViewer(Composite parent, int treeStyle,
			PatternFilter filter, boolean useNewLook) {
		super(parent, treeStyle, filter, useNewLook);
		// TODO Auto-generated constructor stub
	}

	public void addColumns(){
		Tree tree = getViewer().getTree();
		for(String c : clms){
			TreeColumn tc = new TreeColumn(tree, SWT.None);
			tc.setText(c);
			tc.setWidth(200);
		}
		getViewer().setColumnProperties(clms);
	}

}
