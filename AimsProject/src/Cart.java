
public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	public void  addDigitalVideoDisc(DigitalVideoDisc disc) {
		if  (qtyOrdered >= 20) {
			System.out.println("The cart is full");
			 
			
		}
		else {
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc has been added");
			if (qtyOrdered >= 19) {
				System.out.println("The cart is almost full");
			}
		
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
		System.out.println("Removed sucessfully");
		
	}
		public float totalCost() {
			float summ = 0;
			for (int i = 0; i < qtyOrdered; i ++) {
				summ += itemOrdered[i].getCost();
			
			}
		
			return summ;
		
	}
	
			

}
