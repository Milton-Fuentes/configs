/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to;

import com.atser.tools.atserutil.objects.to.pattern.AtserFolderView;

/**
 *
 * @author droldan
 */
public class FolderTreeViewSyncTO extends AtserFolderView {

    private Boolean hasChild;
    private Boolean expanded;
    private String sprite;

    public FolderTreeViewSyncTO() {
        super();
        this.hasChild = null;
        this.expanded = null;
        this.sprite = null;
    }

    public FolderTreeViewSyncTO(Long id, Long parentId, String name, String created, String owner, Boolean hasChild, Boolean expanded, String sprite) {
        super(id, parentId, name, created, owner);
        this.hasChild = hasChild;
        this.expanded = expanded;
        this.sprite = sprite;
    }

    public Boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }      
    
}
