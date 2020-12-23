package com.walmart.challenge.integrationTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.walmart.challenge.WalmartChallengeProductsMsApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = WalmartChallengeProductsMsApplication.class
)
public class TestIntegration {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
	@Test
	public void testHealthEndpointIsOK() throws Exception {
        this.mockMvc.perform(get("/health"))
            .andExpect(status().isOk())
            .andExpect(content().string("ok"));
	}
	
	
	@Test
	public void testSearchEndpointIsOK() throws Exception {
        this.mockMvc.perform(get("/search?q=adsda&page=0"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.currentPage", is(0)))
            .andExpect(jsonPath("$.totalPages", is(2)))
            .andExpect(jsonPath("$.totalItems", is(11)))
            .andExpect(jsonPath("$.products", hasSize(8)));
	}
}
