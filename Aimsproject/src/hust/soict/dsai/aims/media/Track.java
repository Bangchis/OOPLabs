package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track  implements Playable{
	private String title;
	private int length;
	
	public Track() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}



	

	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Track)) {
		
		return false;
		
	}
		Track other = (Track) o;
		return this.getTitle() != null && this.title.equals(other.getTitle())   && this.getLength() == other.getLength();
}

	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
		else {throw new PlayerException("Error: Track length is have to be larger than 0");}
	}
	
	
	
	
}
