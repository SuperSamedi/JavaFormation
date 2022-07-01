package com.digitalcity.advanced.jdbc;

public class Section {
    private int id;
    private String name;
    private int delegateID;

    public Section(int id, String name, int delegateID) {
        this.id = id;
        this.name = name;
        this.delegateID = delegateID;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public int getDelegateID() {
        return delegateID;
    }

    public void setDelegateID(int value) {
        delegateID = value;
    }

    @Override
    public String toString() {
        return "\nSection{ " + "id : " + id + ", name : " + name + ", delegateID : " + delegateID + "}";
    }
}
