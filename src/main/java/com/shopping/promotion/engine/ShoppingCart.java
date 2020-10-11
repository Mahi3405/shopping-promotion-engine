package com.shopping.promotion.engine;

import java.util.List;

import com.shopping.promotion.engine.entity.Item;

public class ShoppingCart {
	private List<Item> items;

	public ShoppingCart(List<Item> items) {
		this.items = items;

	}

	public double getTotal() {
		return items.stream().mapToDouble(item -> item.getSubTotal(item)).sum();
	}
	
}
