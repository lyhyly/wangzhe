package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.inorise.MainMethod;
import com.inorise.service.FilmService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MainMethod.class)
public class MyTest {
	
	@Autowired
	private FilmService filmService;

	@Test
	public void test1() {
		filmService.addFilm();
	}
	
}
