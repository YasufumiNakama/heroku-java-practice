package heroku_java_practice;

import static org.junit.Assert.*;
import org.junit.Test;

import com.heroku_java_practice.*;

public class RamenTest {
	
	/*
	@Test
	public void test() {
		try {
			ramen status = new ramen();
			System.out.println(status.get_ramen());
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	*/
	
	@Test
	public void test() {
		try {
			main status = new main();
			System.out.println(status.return_ramen());
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
}