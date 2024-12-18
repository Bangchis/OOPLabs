package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks;
	
	public CompactDisc() {
		super("","",0,"",0);
		this.artist = "";
		
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String artist) {
		super("","",0,"",0);
		this.artist = artist;
		
		// TODO Auto-generated constructor stub
	}
	
	
	
//	c Disc(String title, String category, float cost, String directory, int length)
	
	public CompactDisc( String artist,String title, String category,String director,float cost) {
		super(title,category,cost,director,0);
		this.artist = artist;
		
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
		}
		else {
			System.out.println("CD already exists ");
		}
			
				
	}
	
	public void removeTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.remove(track);
		}
		else {
			System.out.println("CD not found");
		}
	}


	@Override
	public void play() throws PlayerException{
		System.out.println("CompactDisc Artist: " + this.getArtist());
		System.out.println("Total length: " + this.getLength());

		if (this.getLength() > 0) {
			System.out.println("Compactdisc: " + this.getTitle());
			System.out.println("CompactDisc Artist: " + this.getArtist());
			System.out.println("Total length: " + this.getLength());
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				}
				catch(PlayerException e ) {
					throw e;
				}
			}
		}
		else {
			throw new PlayerException("Error: CD length is non-positive!");
		}

		System.out.println("-----------------Play All Tracks-----------------");
		for (Track track: tracks) {
			track.play();
		}
	}
	@Override
	public int getLength() {
		int sumLength = 0;
		for (Track track : tracks) {
			sumLength += track.getLength();
		}
		return sumLength;
	}
	
	@Override
	public String toString() {
		return "Compact Disc" + "-" + this.getArtist() + "-" + this.getCategory() + "-" + this.getDirector() + "-" + String.valueOf(this.getLength()) + ": " + String.valueOf(this.getCost()) + "$";
				
	}
	
	
	
	
	
	
}
