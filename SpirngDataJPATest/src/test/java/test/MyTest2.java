package test;

import java.util.Random;

import org.junit.Test;

public class MyTest2 {

	@Test
	public void test1() {
		Random random = new Random();
		for(int i = 0 ; i< 100;i++) {
			double sqrt = Math.sqrt(0.2);
			sqrt = sqrt*40;
			int a = (int) (sqrt*random.nextGaussian());
			System.out.println(a+1950);
		}
	}
	
}
