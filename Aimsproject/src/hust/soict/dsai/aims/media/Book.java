package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		
		
		// TODO Auto-generated constructor stub
	}
	 
	public Book(List<String> author) {
		this.authors = author;
	}
	
	public Book(String title, String category, float cost) {
		super(title,category,cost);
	}
	

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String author) {
		if(!authors.contains(author)) {
			authors.add(author);
		}
		else {
			System.out.println("author already exists ");
		}
	}
	
	
	public void removeAuthor(String author) {
		
		if(!authors.contains(author)) {
			authors.remove(author);
		}
		else {
			System.out.println("Not author found");
		}
	}
		
	@Override
	public String toString() {
		return "Book" + "-" + this.getTitle() + "-" + this.getCategory() + ": " + String.valueOf(this.getCost()) + "$";
				
	}
				
			
}
		
	
	

