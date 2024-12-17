package hust.soict.dsai.aims.media;

public class Disc extends Media{
	private int length;
	private String director;
	
	public Disc() {
		// TODO Auto-generated constructor stub
		this.length = 0;
		this.director = "";
	}

	
	public Disc(String title, String category, float cost, String director, int length) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
		this.director = director;
		this.length  = length;
	}


	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	@Override
	public String toString() {
		return "Disc" + "-" + this.getTitle() + "-" + this.getCategory() + "-" + this.getDirector() + "-" + String.valueOf(this.getLength()) + ": " + String.valueOf(this.getCost()) + "$";
	
	}
	
}
