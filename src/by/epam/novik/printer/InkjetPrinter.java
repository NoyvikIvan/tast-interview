package by.epam.novik.printer;

import by.epam.novik.context.PrintSetting;

public class InkjetPrinter implements Printer  {

	@Override
	public void print(PrintSetting setting) {
		inkjatPrint();
		
		System.out.println(setting);
		
	}
	
	private void inkjatPrint() {
		System.out.println("--- пиу - пиу - пиу ---");
		System.out.println("Выполняется печать на струйном принторе, по индивидуальной технологии.");
		System.out.println("--- пшшш... ---");

	}

}
