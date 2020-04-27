package by.epam.novik.context;

import by.epam.novik.setting.Format;
import by.epam.novik.setting.PagePrint;
import by.epam.novik.setting.Quality;

public class PrintSetting {

	// private Document document;

	private Quality quality;
	private Format format;
	private int copyNumber;
	private PagePrint pagePrint;
	private boolean color;

	public void initialization(int quality, int format, int copyNumber, PagePrint pagePrint, boolean color) {

		switch (quality) {
		case 1:
			this.quality = Quality.LOW;
			break;
		case 2:
			this.quality = Quality.NORMAL;
			break;
		case 3:
			this.quality = Quality.HIGH;
			break;
		default:
			this.quality = Quality.NORMAL;
			break;

		}

		switch (format) {
		case 1:
			this.format = Format.A5;
			break;
		case 2:
			this.format = Format.A4;
			break;
		case 3:
			this.format = Format.A3;
			break;
		default:
			this.format = Format.A4;
			break;

		}
		 
		if (!(copyNumber==0)) {
			this.copyNumber = copyNumber;
		} else {
			this.copyNumber = 1;
		}
		
		
		this.pagePrint = pagePrint;
		this.color = color;

	}

	@Override
	public String toString() {
		String quality = null;
		String format = null;
		String color = this.color ? " цветных" : " черно-белых";
		switch (this.quality) {
		case LOW:
			quality = "нзкого качества ";
			break;
		case NORMAL:
			quality = "среднего качества ";
			break;
		case HIGH:
			quality = "высокого качества ";
			break;
		}
		switch (this.format) {
		case A5:
			format = "формата А5";
			break;
		case A4:
			format = "формата А4";
			break;
		case A3:
			format = "формата А3";
			break;

		}
		String totolPrint = "";
		for (int i = 1; i <= copyNumber; i++ ) {
			totolPrint += pagePrint.toString();
		}
		
		
return "Напечатано " + pagePrint.list.size() + color + " страниц " + quality + format  + ".\n"
		+ "Экземпляров печати: " + copyNumber + ".\n"
				+ "---\n"
		+ totolPrint;
	}
}
