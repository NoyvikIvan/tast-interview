package by.epam.novik.setting;

import java.util.List;

import by.epam.novik.document.Document;
import by.epam.novik.document.Page;

import java.util.ArrayList;

public class PagePrint {

	public List<Page> list = new ArrayList<Page>();

	public PagePrint(Document doc) {

		for (int i = 0; i < doc.getPage().length; i++) {
			list.add(doc.getPage()[i]);
		}

	}

	public PagePrint(Document doc, int pageStart, int pageFinish) {

		for (int i = pageStart - 1; i < pageFinish; i++) {
			list.add(doc.getPage()[i]);
		}

	}

	public PagePrint(Document doc, Integer[] page) {

		for (int number : page) {
			list.add(doc.getPage()[number]);
		}
	}

	@Override
	public String toString() {
		String string = "";
		for (Page pg : list) {
			string += pg.toString();
		}
		return string;
	}
	
	

}
