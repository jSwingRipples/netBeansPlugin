/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jswingripples.jsrplugin;

import java.awt.Component; 
import java.awt.event.ActionEvent; 
import javax.swing.AbstractAction; 
import org.openide.awt.ActionID; 
import org.openide.awt.ActionReference; 
import org.openide.awt.ActionRegistration; 
import org.openide.util.actions.Presenter;


@ActionID(
        category = "File",
        id = "org.jswingripples.jsrplugin.GoogleActionListener"
)
@ActionRegistration(
        lazy = false,
        
        displayName = "NOT-USED"
)
@ActionReference(path = "Toolbars/File", position = 0)

public final class GoogleActionListener extends AbstractAction implements Presenter.Toolbar  {
    
    public Component getToolbarPresenter() { 
        return new NewJPanel(); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
