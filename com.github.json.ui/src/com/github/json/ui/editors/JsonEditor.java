package com.github.json.ui.editors;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.EditorPart;

import com.github.json.core.model.INodeElement;
import com.github.json.core.util.ModelUtils;
import com.github.json.ui.control.JsonTreeViewer;
import com.github.json.ui.providers.JsonContentProvider;
import com.github.json.ui.providers.JsonLabelProvider;

public class JsonEditor extends EditorPart {

    private JsonTreeViewer editor;

    private INodeElement root;

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
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        setSite(site);
        setInput(input);
        if (input instanceof IFileEditorInput) {
            InputStream is = null;
            try {
                IFile file = ((IFileEditorInput) input).getFile();
                setPartName(file.getName());
                is = file.getContents();
                root = ModelUtils.constructModel(is);
            } catch (Exception e) {
                MessageDialog.openError(site.getWorkbenchWindow().getShell(), "Parse Json", e.getMessage());
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
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
        editor = new JsonTreeViewer(parent, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.LINE_DASH, new PatternFilter(), true);
        editor.setInitialText("type the xpath");
        TreeViewer viewer = editor.getViewer();
        viewer.setContentProvider(new JsonContentProvider());
        viewer.setLabelProvider(new JsonLabelProvider());
        viewer.getTree().setHeaderVisible(true);
        viewer.getTree().setLinesVisible(true);
        editor.addColumns();
        if (root != null) {
            viewer.setInput(root);
        }
    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub

    }

}
