package modal;

public class CartBeanItem {
	private Product product;
	private int quantity;

	public CartBeanItem() {

	}

	public CartBeanItem(Product product, int quantity) {
		this.setProduct(product);
		this.setQuantity(quantity);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ItemCart [product=" + product + ", quantity=" + quantity + "]";
	}

}
