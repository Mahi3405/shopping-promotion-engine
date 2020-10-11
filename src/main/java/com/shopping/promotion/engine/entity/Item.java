package com.shopping.promotion.engine.entity;

import com.shopping.promotion.engine.util.Product;

public class Item {
	private Product sku;
	private int qunantity;

	public Item(int quantity, Product sku) {
		this.qunantity = quantity;
		this.sku = sku;
	}

	public int getQunantity() {
		return qunantity;
	}

	public Product getSku() {
		return sku;
	}

	public double getSubTotal() {
		return sku.getPrice() * (double) qunantity;
	}

}
