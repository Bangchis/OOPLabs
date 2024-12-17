package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	
	public StoreScreen( Store store) {
		this.store = store;
		Container cp =  getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("STORE");
		setSize(1024,768);
		
	}
	
	
	
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
	    // Tạo menu chính "Options"
	    JMenu menu = new JMenu("Options");

	    // Tạo menu con "Update Store" và thêm các mục vào nó
	    JMenu smUpdateStore = new JMenu("Update Store");
	    smUpdateStore.add(new JMenuItem("Add Book"));
	    smUpdateStore.add(new JMenuItem("Add CD"));
	    smUpdateStore.add(new JMenuItem("Add DVD"));

	    // Thêm menu con vào menu chính
	    menu.add(smUpdateStore);

	    // Thêm các mục khác vào menu chính
	    menu.add(new JMenuItem("View store"));
	    menu.add(new JMenuItem("View cart"));

	    // Tạo thanh menu và thêm menu chính vào
	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);

	    // Trả về thanh menu đã hoàn chỉnh
	    return menuBar;
	}
	JPanel createHeader() {
	    // Tạo một JPanel làm header
	    JPanel header = new JPanel();
	    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS)); // Layout theo trục X

	    // Tạo JLabel "AIMS" và thiết lập font, màu sắc
	    JLabel title = new JLabel("AIMS");
	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	    title.setForeground(Color.CYAN);

	    // Tạo nút "View cart" và thiết lập kích thước
	    JButton cart = new JButton("View cart");
	    cart.setPreferredSize(new Dimension(100, 50));
	    cart.setMaximumSize(new Dimension(100, 50));

	    // Thêm các thành phần vào header với khoảng cách và căn chỉnh
	    header.add(Box.createRigidArea(new Dimension(10, 10))); // Khoảng cách bên trái
	    header.add(title); // Thêm tiêu đề
	    header.add(Box.createHorizontalGlue()); // Khoảng trống linh hoạt
	    header.add(cart); // Thêm nút "View cart"
	    header.add(Box.createRigidArea(new Dimension(10, 10))); // Khoảng cách bên phải

	    return header; // Trả về JPanel header đã hoàn thành
	}
	
	JPanel createCenter() {
	    // Tạo JPanel với layout lưới
	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(3, 3, 2, 2)); // Lưới 3x3 với khoảng cách 2 pixel

	    // Lấy danh sách các Media từ cửa hàng
	    ArrayList<Media> mediaInStore = store.getItemsInStore();

	    // Thêm các phần tử Media vào lưới
	    for (int i = 0; i < 9; i++) {
	        MediaStore cell = new MediaStore(mediaInStore.get(i));
	        center.add(cell);
	    }

	    return center; // Trả về JPanel
	}
	
	
	public class MediaStore extends JPanel {
	    private Media media; 

	    public MediaStore(Media media) {
	        this.media = media;

	        
	        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	        
	        JLabel title = new JLabel(media.getTitle());
	        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
	        title.setAlignmentX(CENTER_ALIGNMENT);

	      
	        JLabel cost = new JLabel("" + media.getCost() + " $");
	        cost.setAlignmentX(CENTER_ALIGNMENT);

	        JButton btnPlay = new JButton("Play");
	        JButton btnAddToCart = new JButton("Add to cart");
	        		
	        JPanel container = new JPanel();
	        container.setLayout(new FlowLayout(FlowLayout.CENTER));
	        container.add(btnAddToCart); // Nút Add to cart


	        if (media instanceof Playable) {
	            container.add(btnPlay);
	        }
	        
	        
	     // Add to cart action
	        btnAddToCart.addActionListener(e -> 
	        	showAddToCartDialog()
	           );

	        // Play button action - open JDialog
	        btnPlay.addActionListener(e -> showPlayDialog());
	     
	        this.add(Box.createVerticalGlue());
	        this.add(title);
	        this.add(cost);
	        this.add(Box.createVerticalGlue()); 
	        this.add(container);
	        this.add(Box.createVerticalGlue()); 
	       
	        
	        
	        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        
	        
	    }
	    
	    
	    
	 // Method to show JDialog for Play button
	    private void showPlayDialog() {
	        JDialog dialog = new JDialog((JFrame) null, "Playing Media", true);
	        dialog.setSize(300, 150);
	        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

	        JLabel message = new JLabel("Playing: " +"Media " +"id = " + media.getId() + "title = " +  media.getTitle() + " category = " + media.getCategory() + " cost = " + media.getCost() );
	        message.setAlignmentX(CENTER_ALIGNMENT);

	        JButton closeButton = new JButton("Close");
	        closeButton.setAlignmentX(CENTER_ALIGNMENT);
	        closeButton.addActionListener(e -> dialog.dispose());

	        dialog.add(Box.createVerticalGlue());
	        dialog.add(message);
	        dialog.add(Box.createVerticalGlue());
	        dialog.add(closeButton);
	        dialog.add(Box.createVerticalGlue());

	        dialog.setLocationRelativeTo(null);
	        dialog.setVisible(true);
	    }
	    
	    
	    
	    
		// Method to show JDialog for Play button
	    private void showAddToCartDialog() {
	        JDialog dialog = new JDialog((JFrame) null, "AddToCart", true);
	        dialog.setSize(300, 150);
	        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
	        
	        JLabel message;
	        if ( Cart.addMedia(media)) {
	        	 message = new JLabel("Add to cart " + media.getTitle() + "sucessfully");
	        }
	        else {
	        	message = new JLabel("Failed to add media" +  media.getTitle());
	        }
	        	
	       
	        message.setAlignmentX(CENTER_ALIGNMENT);

	        JButton closeButton = new JButton("Close");
	        closeButton.setAlignmentX(CENTER_ALIGNMENT);
	        closeButton.addActionListener(e -> dialog.dispose());

	        dialog.add(Box.createVerticalGlue());
	        dialog.add(message);
	        dialog.add(Box.createVerticalGlue());
	        dialog.add(closeButton);
	        dialog.add(Box.createVerticalGlue());

	        dialog.setLocationRelativeTo(null);
	        dialog.setVisible(true);
	   
	    
	  
	    
	    
	    }
	}
	
	

}



