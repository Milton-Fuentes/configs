/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.pattern;

/**
 *
 * @author droldan
 */
public class AtserFolderView {

    protected Long id;
    protected Long parentId;
    protected String name;
    protected String created;
    protected String owner;

    public AtserFolderView(Long id, Long parentId, String name, String created, String owner) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.created = created;
        this.owner = owner;
    }

    public AtserFolderView() {
        this.id = null;
        this.parentId = null;
        this.name = null;
        this.created = null;
        this.owner = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
