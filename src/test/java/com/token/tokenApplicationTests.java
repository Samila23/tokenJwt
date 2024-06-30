package com.token;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class tokenApplicationTests {

	 @Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void testGetAll2WithValidToken() throws Exception {
	        String validToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJSb2xlIjoiQURtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.ynOR-RVlXgsU1k3hi8QELkSg3sYcC6RlhrZdk0sOAZE";

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/token")
	                .header("Authorization", validToken))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andReturn();

	        assertThat(result.getResponse().getContentAsString()).isEqualTo("true");

	    }

	    @Test
	    public void testValidToken() throws Exception {
	        String invalidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJSb2xlIjoiQURtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyIsImFhIjoiYWEifQ.Q7yWeiItceeM4G1HM9ijYQuooXFPTaWTSkVeBsstYjk";

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/token")
	                .header("Authorization", invalidToken))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        assertThat(result.getResponse().getContentAsString()).isEqualTo("false");
	    }
	    
	    @Test
	    public void testInvalidClaims() throws Exception {
	        String invalidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJSb2xlIjoiQURtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyIsImFhIjoiYWEifQ.Q7yWeiItceeM4G1HM9ijYQuooXFPTaWTSkVeBsstYjk";

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/token")
	                .header("Authorization", invalidToken))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        assertThat(result.getResponse().getContentAsString()).isEqualTo("false");
	    }
	    @Test
	    public void testInvalidName() throws Exception {
	        String invalidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJSb2xlIjoiQURtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUNW9uaW5obyBBcmF1am8ifQ.EpGMmu58i44V0wJKYbwdZ_LFjGF_561Yr_7hb4F3rbA";

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/token")
	                .header("Authorization", invalidToken))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        assertThat(result.getResponse().getContentAsString()).isEqualTo("false");
	    }
	    @Test
	    public void testInvalidNameSize() throws Exception {
	        String invalidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJSb2xlIjoiYWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKU2IyeGxJam9pUVVKRFJDSXNJbE5sWldRaU9pSTNPRFF4SWl3aVRtRnRaU0k2SWxRMWIyNXBibWh2SUVGeVlYVnFieUo5LnJ5Ni1KTWUxbjFjTzNDeTJ4X3Zrc25pMmRVNk1fUTV1SVFVbU52cjM0aGNleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKU2IyeGxJam9pUVVKRFJDSXNJbE5sWldRaU9pSTNPRFF4SWl3aVRtRnRaU0k2SWxReElpd2lUbUZ0WlNJNklsYSJ9.Gqp8pwNhu2Hn8YehLjEf02WtXsGoxLuR_KK60b4UfJU";

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/token")
	                .header("Authorization", invalidToken))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        assertThat(result.getResponse().getContentAsString()).isEqualTo("false");
	    }
	    @Test
	    public void testInvalidRole() throws Exception {
	        String invalidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJSb2xlIjoiQUJDRCIsIlNlZWQiOiI3ODQxIiwiTmFtZSI6IlQ1b25pbmhvIEFyYXVqbyJ9.ry6-JMe1n1cO3Cy2x_vksni2dU6M_Q5uIQUmNvr34hc";

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/token")
	                .header("Authorization", invalidToken))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        assertThat(result.getResponse().getContentAsString()).isEqualTo("false");
	    }
	    @Test
	    public void testInvalidSeed() throws Exception {
	        String invalidToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJSb2xlIjoiYWRtaW4iLCJTZWVkIjoiNzg0MCIsIk5hbWUiOiJNYXJpYSJ9.z_m5uen74tXlHgnXOfig7AGGtNUnxBIlBbtp1tqquWo";

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/token")
	                .header("Authorization", invalidToken))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        assertThat(result.getResponse().getContentAsString()).isEqualTo("false");
	    }
}
