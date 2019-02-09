package myspring.di.xml.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import static org.junit.Assert.*;

public class HelloBeanJunitTest {

	private ApplicationContext context;
	
	@Before
	public void init() {
		//IoC 컨테이너 생성
		//1.ApplicationContext 객체 생성
		context = new GenericXmlApplicationContext("config/beans.xml");
	}
	
	@Test
	public void test1(){
		
		//2. getBean() 호출
		Hello hello = (Hello) context.getBean("hello");
	
		//3. Hello 의 sayHello()호출.
		/*Assert.assertEquals("Hello Spring Study",hello.sayHellow());*/
		assertEquals("Hello Spring Study",hello.sayHellow());
		System.out.println(hello.sayHellow());
		//4. Hello 의 print() 호출
		hello.print();
		
		//5. SpringPrinter getBean() 호출
		Printer printer = context.getBean("printer",Printer.class);
		assertEquals("Hello Spring Study",printer.toString());
		System.out.println(printer.toString());
	}
	
	@Test
	public void test2(){
		
		Hello hello = (Hello) context.getBean("hello");
		
		Hello hello2 = (Hello) context.getBean("hello");
		
		assertSame(hello, hello2);
	}
}
