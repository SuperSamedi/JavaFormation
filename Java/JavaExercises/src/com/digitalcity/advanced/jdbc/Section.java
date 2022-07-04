package com.digitalcity.advanced.jdbc;

public class Section {
    private int id;
    private String name;
    private Integer delegateID;

    public Section(int id, String name, Integer delegateID) {
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

    public Integer getDelegateID() {
        return delegateID;
    }

    public void setDelegateID(Integer value) {
        delegateID = value;
    }

    @Override
    public String toString() {
        return "Section{ " + id + " | " + name + " | " + delegateID + " }";
    }
}
