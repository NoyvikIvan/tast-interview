package by.epam.novik.document;

public class Page {
	
	private final int NUMBER;
	
	public Page(int number) {
		NUMBER = number;
	}

	@Override
	public String toString() {
		return "Страница " + NUMBER + "\n";
	}


}
