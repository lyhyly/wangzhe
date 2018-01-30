package com.inorise.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inorise.daoDemo.MainMethod;
import com.inorise.daoDemo.com.inorise.daoDemo.controller.FilmController;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import com.inorise.daoDemo.com.inorise.daoDemo.service.FilmServcie;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainMethod.class)
@WebAppConfiguration
public class MyTest {

	@Autowired
	private FilmServcie filmService;

	@Autowired
	private FilmController filmController;

	private MockMvc mvc;

	@Before
	public void setUp() {
		/*
		 * 初始化mvc 模拟调用controller的接口发起请求
		 */
		mvc = MockMvcBuilders.standaloneSetup(filmController).build();
	}

	/**
	 * 可以通过import指令导入某各类的某个静态方法，据目前来看是导入后成为了本类的成员方法。 这个test方法会报空指针异常，原因未知
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/film/findOne/1").accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk() );
	}

}
