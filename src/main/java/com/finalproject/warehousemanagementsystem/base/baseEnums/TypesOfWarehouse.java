package com.finalproject.warehousemanagementsystem.base.baseEnums;

public enum TypesOfWarehouse {
    OPEN_AIR_STORAGE(1, "Açıq hava anbarı"),
    CLOSE_AIR_STORAGE(2, "Qapalı hava anbarı"),
    COLD_STORAGE(3, "Soyuducu anbar");

    private int id;
    private String name;

    TypesOfWarehouse(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
