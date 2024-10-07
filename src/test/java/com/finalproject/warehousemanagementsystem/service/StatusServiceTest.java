package com.finalproject.warehousemanagementsystem.service;

import com.finalproject.warehousemanagementsystem.base.Status;
import com.finalproject.warehousemanagementsystem.repository.StatusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StatusServiceTest {

    @InjectMocks
    private StatusService statusService;

    @Mock
    private StatusRepository statusRepository;

    private Status status;

    @BeforeEach
    void setUp() {
        status = new Status(1L, "status");
    }

    @Test
    void getById() {

        //Arrange
        when(statusRepository.findById(anyLong())).thenReturn(Optional.of(status));

        //Act
        var result = statusService.getByIdStandart(anyLong());

        //Assert

        assertThat(result).isEqualTo(status);
//        assertThatThrownBy(() -> )
//                .isInstanceOf(IllegalArgumentException.class)    // Check for specific exception type
//                .hasMessage("Invalid argument!");


    }

    @Test
    void getAll() {
    }
}