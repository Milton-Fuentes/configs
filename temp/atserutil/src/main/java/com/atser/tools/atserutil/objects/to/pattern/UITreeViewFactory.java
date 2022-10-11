/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.pattern;

import com.atser.tools.atserutil.objects.to.FolderTreeViewSyncTO;

/**
 *
 * @author droldan
 */
public class UITreeViewFactory implements IUIFolderFactory {

    @Override
    public AtserFolderView createView() {
        return new FolderTreeViewSyncTO();
    }
    
}
