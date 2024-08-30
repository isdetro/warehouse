package com.finalproject.warehousemanagementsystem.base.baseEnums;

public enum Statuses {
    ACTIVE(1L, "Aktiv"),
    DEACTIVE(2L, "Deaktiv");

    private Long id;
    private String name;

    Statuses(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
