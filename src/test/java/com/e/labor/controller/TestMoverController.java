/*
 * unit test TestMoverController to test MoverController
 */
package com.e.labor.controller;

import com.e.labor.model.Mover;
import com.e.labor.service.MoverService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author jasonpalmer
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMoverController {
    
    private MockMvc mockMvc;

	@MockBean
	private MoverService moverService;
        
        @Autowired
	private MoverController moverController;

	Mover mockMover;
        
        @Before
        public void init(){
            this.mockMvc = MockMvcBuilders.standaloneSetup(moverController).build();
            mockMover = new Mover();
            mockMover.setFirstName("Jason");
            mockMover.setLastName("Palmer");
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTimeInMillis(1506415243885L);
            mockMover.setMemberSince(cal.getTime());
            mockMover.setMonths(1);
            List<String>roles = new ArrayList<>();
            roles.add("ROLE_MOVER");
            roles.add("ROLE_DRIVER");
            roles.add("ROLE_ADMIN");
            mockMover.setRoles(roles);
            mockMover.setUsername("jpalmer");
            mockMover.setYears(1);
        }

	private final static String EXAMPLE_MOVER_JSON = "{\"firstName\":\"Jason\",\"lastName\":\"Palmer\",\"username\":\"jpalmer\",\"roles\":[\"ROLE_MOVER\",\"ROLE_DRIVER\",\"ROLE_ADMIN\"],\"months\":1,\"years\":1,\"memberSince\":1506415243885}";

	@Test
	public void testLogin() throws Exception {

		Mockito.when(
				moverService.login(Mockito.anyString(),
						Mockito.anyString())).thenReturn(mockMover);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/login?username=jpalmer&password=Password1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		JSONAssert.assertEquals(EXAMPLE_MOVER_JSON, result.getResponse()
				.getContentAsString(), false);
	}
    
}
