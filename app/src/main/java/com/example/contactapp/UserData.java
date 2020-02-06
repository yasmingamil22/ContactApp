package com.example.contactapp;

public class UserData {
    private String name;
    private String number;
    private String kind;

    public UserData(String name, String number, String kind) {
        this.name = name;
        this.number = number;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
