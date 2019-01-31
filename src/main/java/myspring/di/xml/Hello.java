package myspring.di.xml;

public class Hello {
	
	//멤버변수 name 
	private String name;
	
	//멤버변수 Printer 타입 printer
	private Printer printer;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	//String 타입의 Hello 문자열과 + 멤버변수 name 값을 리턴
	public String sayHellow() {
		return "Hello " + name;
	}
	
	//Printer 인터페이스의 print 메서드를 호출해주는 메서드
	public void print() {
		this.printer.print(sayHellow());
	}
	
}
