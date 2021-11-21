package jpabasic.atdd.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.mock.web.MockHttpServletResponse.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@AutoConfigureJson
@AutoConfigureMockMvc
@SpringBootTest
public class OrderApiIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test() throws Exception {
        //given
        long productId = 1l;
        int quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

        //when
        MockHttpServletResponse response = mockMvc.perform(post("/orders/pendingOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(SC_OK);
        PendingOrderResponse pendingOrderResponse = objectMapper.readValue(response.getContentAsString(), PendingOrderResponse.class);
        assertThat(pendingOrderResponse.getId()).isGreaterThan(0L);
    }

}
