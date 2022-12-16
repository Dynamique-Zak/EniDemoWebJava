package fr.eni.demo.bo;

public class Article {

	private int id;
	private String title;
	
	public Article() {
		
	}
	
	public Article(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	public Article(String title) {
		this(-1, title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
