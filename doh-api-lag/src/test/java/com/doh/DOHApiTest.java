package com.doh;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import com.doh.api.domain.people.PersonRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DOHApiTest {

	@Rule
	public JUnitRestDocumentation  restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Autowired
    private ObjectMapper objectMapper;

	@Before
	public void setup() {
		this.mockMvc =   MockMvcBuilders
	            .webAppContextSetup(context)
	            .apply(documentationConfiguration(this.restDocumentation))
	            .alwaysDo(print())
	            .build();
	}

	@Test
	@WithMockUser(username="admin",roles={"USER"})
	public void recordWithUser() throws Exception {

		this.mockMvc.perform(get("/records/"))
			.andExpect(status().isOk())
			.andDo(document("list-records"));
			
	}

	@Test
	@WithMockUser(username="admin",roles={"USER"})
    public void createRecord() throws Exception {

		PersonRecord newPost = new PersonRecord ("Tom", "Tester" , "test");

		this.mockMvc.perform(
                post("/records/").contentType(MediaType.APPLICATION_JSON).content(
                        this.objectMapper.writeValueAsString(newPost)
                )
        ).andExpect(status().isOk())
		.andDo(document("add-records",
					preprocessRequest(
							prettyPrint()),
							preprocessResponse(prettyPrint()),
					requestFields(
							fieldWithPath("first_name").description("The record' first_name"),
							fieldWithPath("last_name").description("The record' last_name"),
							fieldWithPath("dob").description("The record' dob"),
		                    fieldWithPath("comments").description("The record' comments"),	
		                    fieldWithPath("id").description("The record' ID"),
		                    fieldWithPath("uuid").description("The records' content"),
		                    fieldWithPath("createdDate").description("The records' creation date"),
		                    fieldWithPath("createdBy").description("The records' created by"),
		                    fieldWithPath("updatedDate").description("The records' update data"),
		                    fieldWithPath("updatedBy").description("The records' updated by"),
		                    fieldWithPath("version").description("The records' version")

						)
					));
    }

	@Test
	@WithMockUser(username="admin",roles={"USER"})
    public void deleteRecord() throws Exception {
		this.mockMvc.perform(
                delete("/records/1")
        ).andExpect(status().isOk())
		.andDo(document("delete-record"));
	}

}
