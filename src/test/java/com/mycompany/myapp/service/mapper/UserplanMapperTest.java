package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserplanMapperTest {

    private UserplanMapper userplanMapper;

    @BeforeEach
    public void setUp() {
        userplanMapper = new UserplanMapperImpl();
    }
}
