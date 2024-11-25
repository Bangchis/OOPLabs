package hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	public void  addDigitalVideoDisc(DigitalVideoDisc disc) {
		if  (qtyOrdered >=  MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
			 
			
		}
		else {
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc has been added");
			if (qtyOrdered >=  MAX_NUMBERS_ORDERED - 1) {
				System.out.println("The cart is almost full");
			}
		
		}	
		
	}
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		if  (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.print("The cart is full");
		}
		else if (qtyOrdered + dvdList.length >= MAX_NUMBERS_ORDERED) {
			System.out.print("the quantity of your adding is too large");
			
		}
		else {
			for ( int j = 0; j < dvdList.length  ; j++ ) {
				itemOrdered[j + qtyOrdered] = dvdList[j];
			qtyOrdered += dvdList.length;
			}
			System.out.print("Add List of dvds sucessfully");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if (dvd1.getTitle() == dvd2.getTitle()) {
			System.out.print("Cannot add the same dvd together");
		}
		else if  (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.print("The cart is full");
		}
		else if (qtyOrdered + 2 >=  MAX_NUMBERS_ORDERED ) {
			System.out.print("the quantity of your adding is too large");
		}
		else {
			itemOrdered[0 + qtyOrdered] =  dvd1;
			itemOrdered[1 + qtyOrdered] = dvd2;
			qtyOrdered += 2;
			System.out.print("Add 2 of dvds sucessfully");
		}
		
	}
	
	
	
	public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
		int index = 0; 
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemOrdered[i].equals(disc)) {
				index = i;
				break;
			}
		}
		for ( int j = index; j <  qtyOrdered - 1; j++ ) {
			itemOrdered[j] = itemOrdered[j + 1];
			
		}
		itemOrdered[qtyOrdered - 1] = null;
		qtyOrdered = qtyOrdered - 1;
		System.out.print("Removed sucessfully");
		
	}
		public float totalCost() {
			float summ = 0;
			for (int i = 0; i < qtyOrdered; i ++) {
				summ += itemOrdered[i].getCost();
			
			}
		
			return summ;
		
	}
		
		public void ShowCart () {
			System.out.println("******************CART***********************");
			System.out.println("Ordered items");
			for (int i = 0; i < qtyOrdered; i ++ ) {
				System.out.println((i + 1) +". DVD - " + itemOrdered[i].getTitle()+ " - "
			+ itemOrdered[i].getCategory() + " - " + itemOrdered[i].getDirector() + " - " +
						itemOrdered[i].getLength() + ": " + itemOrdered[i].getCost() + "$");
			}
			
			System.out.println("Total cost " + totalCost() + "$");
			System.out.println("***********************CART***********************");
			
		}
	
			

}
