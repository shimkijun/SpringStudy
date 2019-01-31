package myspring.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanTest {
	public static void main(String[] args) {
		
		//1. IoC 컨테이너 생성
		ApplicationContext context = 
				new GenericXmlApplicationContext("config/beans.xml");
		
		//2. Hello Bean 가져오기
		Hello hello = (Hello) context.getBean("hello");
		System.out.println("hello bean = "+ hello.sayHellow());
		hello.print();
		//3. SpringPrinter Bean 가져오기
		Printer printer = (Printer) context.getBean("printer");
		System.out.println("printer bean = "+ printer.toString());
		
		//IoC 컨테이너가 SingleTon 형태로 관리하는지 Test (true)
		Hello hello2 = context.getBean("hello",Hello.class);
		System.out.println(hello == hello2);
	}
	
}
