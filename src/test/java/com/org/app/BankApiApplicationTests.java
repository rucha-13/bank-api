package com.org.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class BankApiApplicationTests {

	@Value("${http.auth.tokenName}")
    private String authHeaderName; 
	
	 @Autowired
	    private MockMvc mockMvc;
	
	@Test
	public void getAccountById() throws Exception {
		 mockMvc.perform(MockMvcRequestBuilders.get("/accounts/1").header(authHeaderName, "45kh2345jh245hhk"))
	        .andDo(print())
         .andExpect(status().isFound());
	}
	
	 @Test
	    public void forbiddenRequest() throws Exception {	 
	        mockMvc.perform(get("/accounts/1"))
	                .andDo(print())
	                .andExpect(status().isForbidden());
	    }
	
	@Test
	void contextLoads() {
	}

}
