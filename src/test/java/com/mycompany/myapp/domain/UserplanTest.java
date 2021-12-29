package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class UserplanTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Userplan.class);
        Userplan userplan1 = new Userplan();
        userplan1.setId(1L);
        Userplan userplan2 = new Userplan();
        userplan2.setId(userplan1.getId());
        assertThat(userplan1).isEqualTo(userplan2);
        userplan2.setId(2L);
        assertThat(userplan1).isNotEqualTo(userplan2);
        userplan1.setId(null);
        assertThat(userplan1).isNotEqualTo(userplan2);
    }
}
