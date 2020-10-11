package com.shopping.promotion.engine.util;

public enum Promo {
	
	TYPE_A(130),TYPE_B(45),TYPE_C_D(30);
	
	Promo(double promoPrice) {
		this.promoPrice = promoPrice;
	}

	public final double promoPrice;

	public double getPromoPrice() {
		return promoPrice;
	}

}
