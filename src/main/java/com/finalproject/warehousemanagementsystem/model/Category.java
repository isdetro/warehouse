package com.finalproject.warehousemanagementsystem.model;

import com.finalproject.warehousemanagementsystem.base.BaseEntityAudit;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Categories")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Category extends BaseEntityAudit {

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "parent_category_id")
    Long parentCategoryId;

    @ManyToOne
    @JoinColumn(name = "parent_category_id", updatable = false, insertable = false)
    Category parentCategory;

}
