package com.finalproject.warehousemanagementsystem.dto.status;

import com.finalproject.warehousemanagementsystem.dto.base.BaseViewDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatusViewDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Long id;
    String name;

}
