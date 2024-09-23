package modal;

import java.util.ArrayList;
import java.util.List;

public class CartBean {
	private List<CartBeanItem> items = new ArrayList<>();

	public List<CartBeanItem> getItems() {
		return items;
	}

	public void addProduct(Product product, int quantity) {
		for (CartBeanItem cartItem : items) {
			if (cartItem.getProduct().getId() == product.getId()) {
				cartItem.setQuantity(cartItem.getQuantity() + quantity);
				return;
			}
		}
		items.add(new CartBeanItem(product, quantity));
	}

	public void removeProduct(Product product) {
		items.removeIf(cartItem -> cartItem.getProduct().getId() == product.getId());
	}

	public void updateProduct(Product product, int quantity) {
		for (CartBeanItem cartItem : items) {
			if (cartItem.getProduct().getId() == product.getId()) {
				cartItem.setQuantity(quantity);
				return;
			}
		}
	}

	public double getTotalPrice() {
		double total = 0;
		for (CartBeanItem cartItem : items) {
			total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
		}
		return total;
	}

}
