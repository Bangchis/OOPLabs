package hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {


	private ArrayList<Media> itemInStore = new ArrayList<Media>();
	
	public void addMedia(Media mediae) {
		if(!itemInStore.contains(mediae)) {
			itemInStore.add(mediae);
		}
		else {
			System.out.println("media object already exists in Store ");
		}
			
				
	}
	
	public void removeMedia(Media mediae) {
		if(!itemInStore.contains(mediae)) {
			itemInStore.remove(mediae);
		}
		else {
			System.out.println("media object not found in Store");
		}
	}
	
	public void showStore() {
		for(Media item: itemInStore) {
			System.out.println(item.toString());
		}
	}
		
	 public Media searchId(int id) {
			boolean found = false;
			for (int i = 0; i < itemInStore.size(); i++) {
				if (itemInStore.get(i).getId() == id) {
					System.out.println("Media found: " + itemInStore.get(i).toString());
					found = true;
					return itemInStore.get(i);
				}
			}

			if (!found) {
				System.out.println("No Media found with ID: " + id);
			}
	        return null;
		}

		public Media searchTitle(String title) {
			boolean found = false;
			for (int i = 0; i < itemInStore.size(); i++) {
				if (itemInStore.get(i).getTitle().equals(title)) {
					System.out.println("Media found: " + itemInStore.get(i).toString());
					found = true;
					return itemInStore.get(i);
				}
			}

			if (!found) {
				System.out.println("No Media found with title: " + title);
			}
	        return null;
		}
}
