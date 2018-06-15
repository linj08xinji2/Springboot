package second.mytest.lover;

import javax.transaction.Transactional;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@Transactional
public class AppJunitTest {
	@Autowired
	PersonRepostiory personRepostiory;

	MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	String expectedJson;

	@Before
	public void setUp() throws Exception {
		Person p1 = new Person(1L, "AAA");
		Person p2 = new Person(2L, "BBB");
//		personRepostiory.save(p1);
//		personRepostiory.save(p2);

//		expectedJson = wrapper(personRepostiory.findAll());
		expectedJson="hello,error!";
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	private String wrapper(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws Exception {
		String url = "/person";
		MvcResult result = mvc.perform(
				MockMvcRequestBuilders.get(url).accept(
						MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		String context = result.getResponse().getContentAsString();
		Assert.assertEquals("ok", 200, status);
		Assert.assertEquals("error", expectedJson, context);
	}

}
