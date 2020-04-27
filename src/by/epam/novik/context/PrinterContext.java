package by.epam.novik.context;

import by.epam.novik.printer.InkjetPrinter;
import by.epam.novik.printer.LaserPrinter;
import by.epam.novik.printer.Printer;
import by.epam.novik.printer.MatrixPrinter;

public class PrinterContext {
	
	private Printer printer = null;
	
	public void setPrinter(int choice) {
		switch (choice) {
			case 1:
				printer = new InkjetPrinter();
				break;
			case 2:	
				printer = new LaserPrinter();
				break;
			case 3: 
				printer = new MatrixPrinter();
				break;
			default: 
				printer = new LaserPrinter();
				break;
		}
	}
	
	
	public Printer getPrinter() {
		return this.printer;
	}
	
	
	
	public void printOut(Printer printer, PrintSetting setting) {
		printer.print(setting);
	}


	
}
