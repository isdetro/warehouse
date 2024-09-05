package com.finalproject.warehousemanagementsystem.base;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "status_id", nullable = false)
    Long statusId;

    @ManyToOne
    @JoinColumn(name = "status_id", updatable = false, insertable = false, nullable = false)
    Status status;

}
