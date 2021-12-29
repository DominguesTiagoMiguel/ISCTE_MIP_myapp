package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UserplanDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserplanDTO.class);
        UserplanDTO userplanDTO1 = new UserplanDTO();
        userplanDTO1.setId(1L);
        UserplanDTO userplanDTO2 = new UserplanDTO();
        assertThat(userplanDTO1).isNotEqualTo(userplanDTO2);
        userplanDTO2.setId(userplanDTO1.getId());
        assertThat(userplanDTO1).isEqualTo(userplanDTO2);
        userplanDTO2.setId(2L);
        assertThat(userplanDTO1).isNotEqualTo(userplanDTO2);
        userplanDTO1.setId(null);
        assertThat(userplanDTO1).isNotEqualTo(userplanDTO2);
    }
}
