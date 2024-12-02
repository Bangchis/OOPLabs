package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	


	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,cost,director,length);
		
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,cost,director,0);

	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost,"",0);
		
	}
	public DigitalVideoDisc(String title) {
		super(title,"",0.0f,"",0);
	
	}

	public boolean isMatch(String title) {
		return this.getTitle().equals(title);
	}
	

	@Override
	public void play() { 

		System.out.println("Playing DVD: " + this.getTitle()); 

		System.out.println("DVD length: " + this.getLength()); 

		} 
	
	@Override
	public String toString() {
		return "DVD" + "-" + this.getTitle() + "-" + this.getCategory() + "-" + this.getDirector() + "-" + String.valueOf(this.getLength()) + ": " + String.valueOf(this.getCost()) + "$";
	}
				
	
	

	    // Handle compare for DVD with different ordering rule
	    @Override
	    public int compareTo(Media other) {
	        if (!(other instanceof DigitalVideoDisc)) {
	            return super.compareTo(other);
	        }

	        DigitalVideoDisc otherDVD = (DigitalVideoDisc) other;
	        int titleComparison = this.getTitle().compareTo(otherDVD.getTitle());
	        if (titleComparison != 0) {
	            return titleComparison;
	        }

	        int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
	        if (lengthComparison != 0) {
	            return lengthComparison;
	        }

	        return Double.compare(this.getCost(), otherDVD.getCost());
	    }
	}



