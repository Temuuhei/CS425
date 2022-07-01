package shoppingcart;
import java.util.ArrayList;


import java.util.Iterator;
import shoppingcart.CartLine;
import products.Product;

public class ShoppingCart {
	ArrayList<CartLine> cartLineList = new ArrayList<CartLine>();

	public void action(Product product, String action) {
		if (action.equals("add")){
		for (CartLine cline : cartLineList) {
			if (cline.getProduct().getProductnumber().equals(product.getProductnumber())) {
				cline.setQuantity(cline.getQuantity()+1);
				return;
			}
		}
		CartLine cline = new CartLine();
		cline.setProduct(product);
		cline.setQuantity(1);
		cartLineList.add(cline);
		}
		else{
			if (action.equals("remove")){
			Iterator<CartLine> iterate = cartLineList.iterator();
			while (iterate.hasNext()){
				CartLine cline = iterate.next();
				if (cline.getProduct().getProductnumber().equals(product.getProductnumber())){
					if (cline.getQuantity()>1){
						cline.setQuantity(cline.getQuantity()-1);
					}
					else{
						iterate.remove();
					}
				}
			}
			}
			else{ //action is print
				System.out.println("Content of the shoppingcart:");
				for (CartLine cline : cartLineList) {
					System.out.println(cline.getQuantity() + " "
							+ cline.getProduct().getProductnumber() + " "
							+ cline.getProduct().getDescription() + " "
							+ cline.getProduct().getPrice());
				}
				System.out.println("Total price ="+getT());
			}
		}
	}

	
	// get total price
	public double getT(){
		double totalPrice = 0.0;
		for (CartLine cartLine : cartLineList) {
			totalPrice += (cartLine.getProduct().getPrice() * cartLine.getQuantity());
		}
		return totalPrice;
	}
}
