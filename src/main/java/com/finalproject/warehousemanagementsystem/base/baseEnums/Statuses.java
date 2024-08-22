package com.finalproject.warehousemanagementsystem.base.baseEnums;

public enum Statuses {
    ACTIVE(1, "Aktiv"),
    DEACTIVE(2, "Deaktiv");

    private int id;
    private String name;

    Statuses(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
