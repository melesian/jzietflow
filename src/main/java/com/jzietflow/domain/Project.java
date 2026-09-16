package com.jzietflow.domain;

import java.util.UUID;

public class Project {
    private String name;
    private final UUID id;
    private String description;

    public Project(String name){
        this(name, "");
    }

    public Project(String name, String description){
        // MAINLY FOR CREATING A NEW PROJECT
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    public Project(UUID id, String name, String description){
        // MAINLY FOR CONSTRUCTING A PROJECT FROM DB
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void updateDescription(String newDescription){
        this.description = newDescription;
    }

    public String getName(){
        return this.name;
    }

    public UUID getId(){
        return this.id;
    }

    public void rename(String newName){
        this.name = newName;
    }

    public boolean equals(Project project){
        if(project.getId().equals(this.getId())) return true;

        return false;
    }
}
