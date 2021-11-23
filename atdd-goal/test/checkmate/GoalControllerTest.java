package jpabasic.atdd.checkmate;

import com.fasterxml.jackson.databind.ObjectMapper;
import jpabasic.atdd.checkmate.dto.GoalRequest;
import jpabasic.atdd.checkmate.dto.GoalResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
public class GoalControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(WebApplicationContext context) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    public void save() throws Exception {
        //when
        GoalRequest request = GoalRequest.of("자바의 정석 스터디", LocalDate.of(2021,11,23),
                LocalDate.of(2021,12,31));

        //when
        MockHttpServletResponse response = mockMvc.perform(post("/goal")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.SC_OK);
        GoalResponse goalResponse = objectMapper.readValue(response.getContentAsString(), GoalResponse.class);
        assertThat(goalResponse.getId()).isGreaterThan(0L);
        assertThat(goalResponse.getTitle()).isEqualTo("자바의 정석 스터디");
    }
}
