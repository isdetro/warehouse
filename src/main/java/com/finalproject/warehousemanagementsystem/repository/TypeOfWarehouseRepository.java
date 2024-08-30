package com.finalproject.warehousemanagementsystem.repository;

import com.finalproject.warehousemanagementsystem.base.TypeofWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TypeOfWarehouseRepository extends JpaRepository<TypeofWarehouse, Long> {

    @Transactional
    @Modifying
    @Query(value = """
             update TypeofWarehouse tow
             set tow.statusId = :statusId
             where tow.id = :id
            """)
     void changeStatus(Long id, Long statusId);
}
