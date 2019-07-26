package com.adamyan.java.train.Controller;

import com.adamyan.java.train.config.EmbeddedPostgresConfiguration;
import com.adamyan.java.train.dto.GroupDTO;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {EmbeddedPostgresConfiguration.class, MockMvcAutoConfiguration.class})
@TestPropertySource("/application-test.properties")
@Transactional
public class GroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Test
    public void createGroupTest() throws Exception {
        GroupDTO groupDTO = new GroupDTO(null, "test");
        String groupDTOJSON = gson.toJson(groupDTO);
        this.mockMvc.perform(post("/rest/group/create")
                .contentType(contentType)
                .content(groupDTOJSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void getById() throws Exception {
        this.mockMvc.perform(get("/rest/group/getbyid/1")).andExpect()
    }

    @Test
    public void getAllGroups() {

    }
}