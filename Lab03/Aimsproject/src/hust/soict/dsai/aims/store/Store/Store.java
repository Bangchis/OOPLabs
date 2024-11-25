package hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {

	public static final int StoreCapacity = 10000;
	private DigitalVideoDisc itemInStore[] = new DigitalVideoDisc[StoreCapacity];
	
	private int qtyOrdered = 0;
	
	public void  addDVD(DigitalVideoDisc disc) {
		if  (qtyOrdered >=  StoreCapacity) {
			System.out.println("The Store is full");	
		}
		else {
			itemInStore[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc has been added");
			if (qtyOrdered >=  StoreCapacity - 1) {
				System.out.println("The Store is almost full");
			}
		
		}	
		
	}
	public void removeDVD (DigitalVideoDisc disc) {
		int index = 0; 
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemInStore[i].equals(disc)) {
				index = i;
				break;
			}
		}
		for ( int j = index; j <  qtyOrdered - 1; j++ ) {
			itemInStore[j] = itemInStore[j + 1];
			
		}
		itemInStore[qtyOrdered - 1] = null;
		qtyOrdered = qtyOrdered - 1;
		System.out.println("Removed sucessfully");
		
	}
		
		
		
	
}
