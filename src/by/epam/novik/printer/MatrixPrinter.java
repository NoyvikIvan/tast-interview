package by.epam.novik.printer;

import by.epam.novik.context.PrintSetting;

public class MatrixPrinter implements Printer {

	@Override
	public void print(PrintSetting setting) {
		matrixPrint();
		
		System.out.println(setting);
		
	}
	
	private void matrixPrint() {
		System.out.println("--- тык - тык - тык ---");
		System.out.println("Выполняется печать на матричном принторе, по индивидуальной технологии.");
		System.out.println("--- чик - чик ---");

	}
	
	

}
