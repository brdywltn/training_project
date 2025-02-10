package uk.gov.companieshouse.docsapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import uk.gov.companieshouse.docsapp.model.company.Company;
import uk.gov.companieshouse.docsapp.model.company.LimitedCompany;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class DocsAppApplicationMockTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    /**
     * Calling the "/companies" endpoint with a GET request should return a list of companies
     *
     * @Params GET request, "/companies"
     * */
//    @Test
//    void companiesShouldReturnAListOfCompanies() throws Exception {
//        //TODO: Implement this
//    }

    /**
     * Calling the "/companies" endpoint with a POST request should create a new company
     *
     * @Params POST request, "/companies"
     * */
//    @Test
//    void newLimitedCompanyShouldReturnNewCompany() throws Exception {
//        Company newCompany = new LimitedCompany("New LTD Company", true);
//        String json = mapper.writeValueAsString(newCompany);
//
//        MvcResult result = this.mockMvc.perform(post("/companies")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        Company c = mapper.readValue(result.getResponse().getContentAsString(), Company.class);
//        assertThat(c.getRegistrationNumber()).isNotNull();
//
//
////        Person person = new Person("Brody", 30);
////        String json = mapper.writeValueAsString(person);
////        MvcResult result = this.mockMvc.perform(post("/newPerson")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(json))
////                .andExpect(status().isOk())
////                .andReturn();
////
////        Person p = mapper.readValue(result.getResponse().getContentAsString(), Person.class);
////        assertThat(p.getId()).isNotNull();
//
//    }



}
