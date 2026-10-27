
package com.practice;

public class Item {

    private int id;
    private String name;
    private String description;

    public Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name Cannot be empty!");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        if(description == null || description.isBlank()){
            throw new IllegalArgumentException("Description cannot be empty!");
        }
        this.description = description;
    }
}
