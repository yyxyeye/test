package com.imooc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    // Test /user/hello endpoint
    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/user/hello"))
               .andExpect(status().isOk())
               .andExpect(content().string("helloword"));
    }

    // Test /user/getUser endpoint
    @Test
    public void testGetUser() throws Exception {
        mockMvc.perform(get("/user/getUser"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("imooc2"))
               .andExpect(jsonPath("$.age").value(18))
               .andExpect(jsonPath("$.password").value("imooc2"))
               .andExpect(jsonPath("$.desc").value("hello imooc2~~"));
    }

    // Test /user/setUser endpoint
    @Test
    public void testSetUser() throws Exception {
        mockMvc.perform(get("/user/setUser"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("imooc2"))
               .andExpect(jsonPath("$.age").value(18))
               .andExpect(jsonPath("$.password").value("imooc2"))
               .andExpect(jsonPath("$.desc").value("hello imooc2~~"));
    }

    // Test /user/getUserJson endpoint
    @Test
    public void testGetUserJson() throws Exception {
        mockMvc.perform(get("/user/getUserJson"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.status").value(200))
               .andExpect(jsonPath("$.data.name").value("imooc"))
               .andExpect(jsonPath("$.data.age").value(18))
               .andExpect(jsonPath("$.data.password").value("imooc"))
               .andExpect(jsonPath("$.data.desc").value("hello imooc~~hello imooc~~"));
    }
}
