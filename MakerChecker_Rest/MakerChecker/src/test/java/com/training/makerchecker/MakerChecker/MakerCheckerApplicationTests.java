package com.training.makerchecker.MakerChecker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.training.makerchecker.exception.MakerCheckerException;
import com.training.makerchecker.exception.MakerCheckerResponse;
import com.training.makerchecker.model.Maker;
import com.training.makerchecker.repository.MakerRepository;
import com.training.makerchecker.service.MakerService;
import com.training.makerchecker.service.MakerServiceImpl;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MakerCheckerApplicationTests {
    private MockMvc mockMvc;
	@Autowired
    private WebApplicationContext wac;
	@Mock
	private MakerRepository makerRepo;
	@InjectMocks
	private MakerServiceImpl makerService;
	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	// controller layer
	@Test
	public void verifyAllToDoList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/findAll").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.statusCodes").value(200))
		.andExpect(jsonPath("$.message").value("Record Fetched for Customer Id"))
		.andDo(print());
	}	
	//service layer
	@Test
	public void saveToDo() throws MakerCheckerException{
		Maker maker = new Maker();
		maker.setActive("Y");
		maker.setCreatedDate(new Date());
		maker.setCreatedBy("test");
		maker.setCustomerId(0L);
		when(makerRepo.save(maker)).thenReturn(maker);
		MakerCheckerResponse result = makerService.save(maker);
		assertEquals(200, result.getStatusCodes());
		assertEquals("Record saved successfully", result.getMessage());
		assertEquals(maker, result.getData());
	}
}
