package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("ConsolePrinter")
public class ConsolePrinter implements Printer {

	public void print(String message) {
		System.out.println(message);
	}

}
