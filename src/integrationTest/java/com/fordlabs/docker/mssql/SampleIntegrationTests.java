package com.fordlabs.docker.mssql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fordlabs.docker.mssql.models.SampleDatabaseModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SampleIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sampleWorkflowIntegrationTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        SampleDatabaseModel modelToCreate = SampleDatabaseModel.builder().value("hi").build();
        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.post("/sample", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(modelToCreate))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        SampleDatabaseModel modelFromDatabase = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                SampleDatabaseModel.class
        );
        assertThat(modelFromDatabase.getId()).isNotNull();
        assertThat(modelFromDatabase.getValue()).isEqualTo(modelToCreate.getValue());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/sample", 1)
                        .queryParam("id", String.valueOf(modelFromDatabase.getId()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(modelFromDatabase)));
    }

}
