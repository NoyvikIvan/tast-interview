package by.epam.novik.main;

import java.util.ArrayList;
import java.util.Scanner;

import by.epam.novik.context.PrintSetting;
import by.epam.novik.context.PrinterContext;
import by.epam.novik.document.Document;
import by.epam.novik.printer.Printer;
import by.epam.novik.setting.PagePrint;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Document document = new Document(15);
		PrinterContext order = new PrinterContext();

		System.out.println("На печать поступил новый документ (" + document.getTOTAL_PAGE() + " страниц) \n");
		
		Printer printer;
		PrintSetting setting;

		int choicePriner;
		int choiceQuality;
		int choiceFormat;
		int choicePagePrint;
		int choiceColor;

		int copyNumber;

		boolean color = false;

		String menuPrinter = "Выберите вид принтера:\n" + "1 - струйный принтер;\n"
				+ "2 - лазерный принтер(по умолчанию);\n" + "3 - матричный принтер.\n";
		String menuSetting = "Выберите настройки качества печати:\n" + "1 - низкое;\n" + "2 - среднее(по умолчанию);\n"
				+ "3 - высокое.\n";
		String menuFormat = "Выберите настройки формата печати:\n" + "1 - А5;\n" + "2 - А4(по умолчанию);\n"
				+ "3 - А3.\n";
		String menuPagePrint = "Выберите диапазон печати:\n" + "1 - все страницы(по умолчанию);\n"
				+ "2 - промежуток(от  -  до);\n" + "3 - выборочно.\n";
		String menuColor = "Цветная печать?:\n" + "1 - да;\n" + "2 - нет(по умолчанию);\n";

		choicePriner = choice(menuPrinter, sc);

		choiceQuality = choice(menuSetting, sc);

		choiceFormat = choice(menuFormat, sc);

		choicePagePrint = choice(menuPagePrint, sc);

		PagePrint pagePrint;

		switch (choicePagePrint) {

		case 1:
			pagePrint = new PagePrint(document);
			break;

		case 2:
			int startPage = choice("Введите с какой страницы начать печать:", sc);
			int endPage = choice("Введите по какую страницу печатать:", sc);
			boolean flag = startPage == 0 || startPage > document.getTOTAL_PAGE() || startPage>endPage;
			if (!flag) {
				pagePrint = new PagePrint(document, startPage, endPage);;
			} else {
				System.out.println("Введены некорректные параметры. Выбран режим по умолчанию");
				pagePrint = new PagePrint(document);
			}
			break;

		case 3:
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (true) {
				int pg;
				pg = choice("Выберите номер страницы(для завершения введите 0)", sc);
				if (pg == 0) {
					break;
				}
				list.add(pg-1);
			}

			Integer[] pg = list.toArray(new Integer[list.size()]);

			pagePrint = new PagePrint(document, pg);
			break;
		default:
			pagePrint = new PagePrint(document);
			break;

		}
		
		choiceColor = choice(menuColor, sc);
		if (choiceColor==1) {
			color = true;
		}


		
		copyNumber = choice("Укажите количество копий(1 по умолчанию):", sc);
		

		setting = new PrintSetting();

		setting.initialization(choiceQuality, choiceFormat, copyNumber, pagePrint, color);

		order.setPrinter(choicePriner);
		printer = order.getPrinter();

		order.printOut(printer, setting);

	}

	public static int choice(String menu, Scanner sc) {
		int choice;
		do {
			System.out.println(menu);

			while (!sc.hasNextInt()) {

				sc.nextLine();
				System.out.println("Введите корректные данные");
			}

			choice = sc.nextInt();

		} while (choice < 0);

		return choice;
	}

}
