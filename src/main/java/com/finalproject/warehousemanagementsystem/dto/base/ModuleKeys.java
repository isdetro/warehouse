package com.finalproject.warehousemanagementsystem.dto.base;

public enum ModuleKeys {
    STATUS(1, "status"),
    TYPE_OF_WAREHOUSE(2, "typeOfWarehouse"),
    CATEGORY(3, "category"),
    LOCATION(4, "location"),
    PRODUCT(5, "product"),
    WAREHOUSE(6, "warehouse");

    private final int val;
    private final String name;

    ModuleKeys(int val, String name) {
        this.val = val;
        this.name = name;
    }

    public int getVal() {
        return val;
    }

    public String getName() {
        return name;
    }
}
