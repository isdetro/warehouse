package com.finalproject.warehousemanagementsystem.base.baseEnums;

public enum TypeOfWarehouses {
    OPEN_AIR_STORAGE(1L, "Açıq hava anbarı"),
    CLOSE_AIR_STORAGE(2L, "Qapalı hava anbarı"),
    COLD_STORAGE(3L, "Soyuducu anbar");

    private Long id;
    private String name;

    TypeOfWarehouses(Long id, String name) {
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
