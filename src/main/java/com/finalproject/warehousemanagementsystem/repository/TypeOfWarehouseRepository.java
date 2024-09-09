package com.finalproject.warehousemanagementsystem.repository;

import com.beyt.jdq.repository.JpaDynamicQueryRepository;
import com.finalproject.warehousemanagementsystem.base.TypeofWarehouse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TypeOfWarehouseRepository extends JpaDynamicQueryRepository<TypeofWarehouse, Long> {

    @Transactional
    @Modifying
    @Query(value = """
             update TypeofWarehouse tow
             set tow.statusId = :statusId
             where tow.id = :id
            """)
     void changeStatus(Long id, Long statusId);
}
