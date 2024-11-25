package hust.soict.dsai.test.cart.CartTest;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart cart = new Cart();

        // Tạo các đối tượng đĩa DVD và thêm vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3); 


        // In thông tin các đĩa DVD trong giỏ hàng
        cart.ShowCart();

  
    }
}

