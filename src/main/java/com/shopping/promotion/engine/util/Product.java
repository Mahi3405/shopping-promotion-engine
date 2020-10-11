package com.shopping.promotion.engine.util;

public enum Product {
	
	SKU_A("A", 50),SKU_B("B", 30),SKU_C("C", 20),SKU_D("D", 15);
	
	Product(String sku, double unitPrice) {
		this.sku = sku;
		this.unitPrice = unitPrice;
	}

	public final String sku;
	
	public final double unitPrice;

	public double getPrice() {
		return unitPrice;
	}

}
