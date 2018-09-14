import java.util.Arrays;
import java.util.Scanner;
class Item {
	private String productname;
	private int quantity;
	private double unitprice;
	public Item() {
	}
	public Item(String itemname, int numberofitems, double price) {
		productname = itemname;
		quantity = numberofitems;
		unitprice = price;
	}
	public Item(String itemname, int numberofitems) {
		productname = itemname;
		quantity = numberofitems;
	}
	public String getproductname() {
		return productname;
	}
	public int getquantity() {
		return quantity;
	}
	public void setquantity(int q) {
		quantity = quantity - q;
	}
	public double getunitprice() {
		return unitprice;
	}
	public String toString() {
		return (productname + " " + quantity + " " + unitprice);
	}
	public String getcart() {
		return (productname + " " + quantity);
	}
}
class ShoppingCart {
	private int itemsize;
	private int cartsize;
	private Item[] items;
	private Item[] cart;
	private double coupondiscount;
	public ShoppingCart() {
		final int x = 10;
		coupondiscount = 0;
		items = new Item[x];
		cart = new Item[x];
		itemsize = 0;
		cartsize = 0;
	}
	/**
	 * {Method to resize}.
	 */
	private void resize() {
		items = Arrays.copyOf(items, 2 * itemsize);
		cart = Arrays.copyOf(cart, 2 * cartsize);
	}
	public void addToCatalog(Item item) {
		if (itemsize >= items.length) {
			resize();
		}
		items[itemsize++] = item;
	}
	public void addToCart(Item item) {
		for (int i = 0; i < itemsize; i++) {
			if (items[i].getproductname().equals(item.getproductname()) && items[i].getquantity() >= item.getquantity()) {
				if (cartsize >= cart.length) {
					resize();
				}
				cart[cartsize++] = item;
				items[i].setquantity(item.getquantity());
			}
		}
	}
	public void removeFromCart(Item item) {
		for (int i = 0; i < cartsize; i++) {
			if (cart[i].getproductname().equals(item.getproductname()) && cart[i].getquantity() >= item.getquantity()) {
				cart[i].setquantity(item.getquantity());
				if (cart[i].getquantity() == 0) {
					for (int k = i; k < cartsize - 1; k++) {
						cart[k] = cart[k + 1];
					}
					cartsize--;
				}
				for (int j = 0; j < itemsize; j++) {
					if (items[j].getproductname().equals(item.getproductname())) {
						items[i].setquantity(-item.getquantity());
					}
				}
			}
		}
	}
	public void showCart() {
		for (int i = 0; i < cartsize; i++) {
			System.out.println(cart[i].getcart());
		}
	}
	public void showCatalog() {
		for (int i = 0; i < itemsize; i++) {
			System.out.println(items[i]);
		}
	}
	public double getTotalAmount() {
		double totalAmount = 0;
		for (int i = 0; i < cartsize; i++) {
			for (int j = 0; j < itemsize; j++) {
				if (cart[i].getproductname().equals(items[j].getproductname())) {
					totalAmount += items[j].getunitprice() * cart[i].getquantity();
				}
			}
		}
		return totalAmount;
	}
	public double getPayableAmount() {
		double total = getTotalAmount();
		System.out.println((total * 15) / 100);
		double temp = (total - ((total * coupondiscount) / 100));
		return ((temp*15)/100);
	}
	public void applyCoupon(String coupon) {
		switch (coupon) {
		case "IND10":
			coupondiscount = 10;
			break;
		case "IND20":
			coupondiscount = 20;
			break;
		case "IND30":
			coupondiscount = 30;
			break;
		case "IND50":
			coupondiscount = 50;
			break;
		default:
		System.out.println("Invalid coupon");
			break;
		}
	}
	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cartsize; i++) {
			for (int j = 0; j < itemsize; j++) {
				if (cart[i].getproductname().equals(items[j].getproductname())) {
					System.out.println(cart[i].getproductname() + " " + cart[i].getquantity() + " " + items[j].getunitprice());
				}
			}
		}
		System.out.println("Total:" + Double.toString(getTotalAmount()));
		System.out.println("Disc%:" + Double.toString((getTotalAmount()*coupondiscount)/100));
		System.out.println("Tax:" + Double.toString((getTotalAmount() * 15) / 100));
		System.out.printf("Payable amount: %.1f\n", getPayableAmount());
	}
}
/**
 * Class for solution.
 */
public final class Solution {

	/**
	 * Constructs the object.
	 */
	private Solution() {
		//Empty.
	}

	/**
	 * {Main method}.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		ShoppingCart sc = new ShoppingCart();
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testCases; i++) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "Item":
				String[] details = tokens[1].split(",");
				sc.addToCatalog(new Item(details[0], Integer.parseInt(details[1]), Double.parseDouble(details[2])));
				break;
			case "add":
				String[] details1 = tokens[1].split(",");
				sc.addToCart(new Item(details1[0], Integer.parseInt(details1[1])));
				break;
			case "remove":
				String[] details2 = tokens[1].split(",");
				sc.removeFromCart(new Item(details2[0], Integer.parseInt(details2[1])));
				break;
			case "catalog":
				sc.showCatalog();
				break;
			case "show":
				sc.showCart();
				break;
			case "totalAmount":
				System.out.println("totalAmount: " + Double.toString(sc.getTotalAmount()));
				break;
			case "payableAmount":
				System.out.printf("Payable amount: %.1f\n", sc.getPayableAmount());
				break;
			case "coupon":
				sc.applyCoupon(tokens[1]);
				break;
			case "print":
				sc.printInvoice();
				break;
			default:
				break;
			}
		}
	}
}