package myspring.di.xml.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class HelloBeanJunitSpringTest {

	@Autowired
	private ApplicationContext context;

	@Test
	public void test1() {
		// 2. getBean() 호출
		Hello hello = (Hello) context.getBean("hello");

		// 3. Hello 의 sayHello()호출.
		/* Assert.assertEquals("Hello Spring Study",hello.sayHellow()); */
		assertEquals("Hello Spring Study", hello.sayHellow());
		// 4. Hello 의 print() 호출
		hello.print();

		// 5. SpringPrinter getBean() 호출
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring Study", printer.toString());
		
		
	}

	@Test
	public void test2() {

		Hello hello = (Hello) context.getBean("hello");

		Hello hello1 = (Hello) context.getBean("hello");

		assertSame(hello, hello1);
	}
	
	@Test
	public void test3() {
		Hello hello = context.getBean("hello3",Hello.class);
		
		//list 사이즈 가 3개 인지 비교
		assertEquals(3,hello.getNames().size());
		
		//bean주입한 값이 출력되는지 테스트
		List<String> list = hello.getNames();
		for (String value: list) {
			System.out.println(value);
		}

	}
}
