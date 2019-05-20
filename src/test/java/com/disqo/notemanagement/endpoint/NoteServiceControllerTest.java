package com.disqo.notemanagement.endpoint;

import com.disqo.notemanagement.service.NoteInternalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-application-config.xml")
@WebAppConfiguration
public class NoteServiceControllerTest {


	@Autowired
	private NoteInternalService noteInternalService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	private static final Integer id = 1;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void testGetNoteById()
			throws Exception {
		this.mockMvc.perform(get("/notes/{id}", id).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("id", is(1)));//TODO @Davit and other fields

		verify(noteInternalService, times(1)).getNoteById(id);
	}
}
