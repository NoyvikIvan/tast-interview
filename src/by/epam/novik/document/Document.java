package by.epam.novik.document;

public class Document {

	private final int TOTAL_PAGE;
	private Page[] page;

	public Document(int page) {
		if (page > 0) {
			TOTAL_PAGE = page;
		} else {
			TOTAL_PAGE = 1;
		}
		this.page = new Page[TOTAL_PAGE];
		for (int i = 0; i < this.page.length; i++) {
			this.page[i] = new Page(i + 1);
		}

	}

	public Page[] getPage() {
		return page;
	}

	public int getTOTAL_PAGE() {
		return TOTAL_PAGE;
	}
	

}
