package com.finalproject.warehousemanagementsystem.base;

import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;


@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity implements Serializable {
}