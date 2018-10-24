package org.zerock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import org.zerock.domain.ReplyVO;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
})
@Log4j
public class TodoControllerTests {
	
	@Setter(onMethod_=@Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;//가짜 리퀘스트
	
	@Before //어스펙트 말고 제이유닛으로 넣기
	public void setIp() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); //가짜리퀘스트
		
	}
	@Test
	public void createTest()throws Exception {
		
		ReplyVO vo = new ReplyVO();
		vo.setBno(123);
		vo.setReply("대앳글..");
		vo.setReplyer("jiiiiing");
		
		String str = new Gson().toJson(vo);
		
		System.out.println(str);
		
		mockMvc.perform(
				post("/reply/new")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(str)
				);
	}

}
