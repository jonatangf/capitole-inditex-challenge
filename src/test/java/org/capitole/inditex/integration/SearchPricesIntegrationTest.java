package org.capitole.inditex.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.capitole.inditex.adapter.in.controller.price.model.SearchPriceResponseBody;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class SearchPricesIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @CsvSource({"productId,35455", "brandId,1"})
    void shouldReturnAllPricesForAGivenProductIdOrBrandId(
            String parameterName,
            String parameterValue
    ) throws Exception {
        SearchPriceResponseBody searchPriceResponseBody = objectMapper
                .readValue(
                        mockMvc.perform(get("/api/prices")
                                                .queryParam(parameterName, parameterValue))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        SearchPriceResponseBody.class
                );

        assertThat(searchPriceResponseBody).isNotNull();
        assertThat(searchPriceResponseBody.getPrices()).isNotEmpty().hasSize(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2020-06-14T10:00:00Z",
            "2020-06-14T16:00:00Z",
            "2020-06-14T21:00:00Z",
            "2020-06-15T10:00:00Z",
            "2020-06-16T21:00:00Z"
    })
    void shouldReturnPriceForAGivenDate(String dateTime) throws Exception {
        SearchPriceResponseBody searchPriceResponseBody = objectMapper
                .readValue(
                        mockMvc.perform(get("/api/prices")
                                                .queryParam("brandId", "1")
                                                .queryParam("productId", "35455")
                                                .queryParam("effectiveDate", dateTime))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        SearchPriceResponseBody.class
                );

        assertThat(searchPriceResponseBody).isNotNull();
        assertThat(searchPriceResponseBody.getPrices()).isNotEmpty().hasSize(1);
    }
}
