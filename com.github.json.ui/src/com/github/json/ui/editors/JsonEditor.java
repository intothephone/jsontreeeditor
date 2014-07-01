package com.github.json.ui.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class JsonEditor extends TextEditor {

	private ColorManager colorManager;

	public JsonEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
