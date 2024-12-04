package edu.jsp.product;


public class Product {

	private int id;
	private String pname;
	private int pquanity;
	
	public Product(int id, String pname, int pquanity) {
		this.id = id;
		this.pname = pname;
		this.pquanity = pquanity;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", pquanity=" +pquanity+"]";
	}

	
}