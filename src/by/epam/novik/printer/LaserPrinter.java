package by.epam.novik.printer;

import by.epam.novik.context.PrintSetting;

public class LaserPrinter implements Printer {

	@Override
	public void print(PrintSetting setting) {
		laserPrint();
		
		System.out.println(setting);
		
	}
	
	private void laserPrint() {
		System.out.println("--- жу - жу - жу ---");
		System.out.println("Выполняется печать на лазерном принторе, по индивидуальной технологии.");
		System.out.println("--- пщщщщ ---");
	}
	

}
