package com.jzietflow.domain;

import java.util.UUID;

public class Project {
    private String name;
    private final UUID id;

    public Project(String name){
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public UUID getId(){
        return this.id;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public boolean equals(Project project){
        if(project.getId().equals(this.getId())) return true;

        return false;
    }
}
