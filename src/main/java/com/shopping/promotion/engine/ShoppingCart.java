package com.shopping.promotion.engine;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.shopping.promotion.engine.entity.Item;
import com.shopping.promotion.engine.util.Product;
import com.shopping.promotion.engine.util.Promo;

public class ShoppingCart {

	private final Predicate<Item> isBothSkuPromoApplicable = item -> (item.getSku() == Product.SKU_C
			|| item.getSku() == Product.SKU_D);
	private List<Item> items;

	public ShoppingCart(List<Item> items) {
		this.items = items;

	}

	public double getTotal() {
		double totalPrice = 0.0;
		if (isCartContainsBothSkus()) {
			totalPrice = getAmountForMultiSkus();
			items.removeIf(isBothSkuPromoApplicable);
		}

		for (Item item : items) {
			totalPrice = totalPrice > 0 ? totalPrice + applyPromo(item) : applyPromo(item);
		}

		return totalPrice;
	}

	private double applyPromo(Item item) {
		double promoTotal = 0.0;
		switch (item.getSku()) {
		case SKU_A:			
			promoTotal = calculatePromo(item, 3, Promo.TYPE_A.getPromoPrice());
			break;
		case SKU_B:
			promoTotal = calculatePromo(item, 2, Promo.TYPE_B.getPromoPrice());
			break;
		default:
			promoTotal= item.getSubTotal();
			break;
		}
		return promoTotal;
	}

	private double calculatePromo(Item item, int promoCount, double promoPrice ) {
		int promoQty = item.getQunantity() / promoCount;
		int extraQty = item.getQunantity() % promoCount;
		return promoQty * promoPrice + extraQty * item.getSku().unitPrice;
	}

	public boolean isCartContainsBothSkus() {
		List<Product> listWithBothSkus = items.stream().filter(isBothSkuPromoApplicable).map(item -> item.getSku())
				.collect(Collectors.toList());

		return listWithBothSkus.containsAll(Arrays.asList(new Product[] { Product.SKU_C, Product.SKU_D }));
	}

	public double getAmountForMultiSkus() {
		int cQuantity = items.stream().filter(item -> item.getSku().equals(Product.SKU_C)).findFirst().get()
				.getQunantity();

		int dQuantity = items.stream().filter(item -> item.getSku().equals(Product.SKU_D)).findFirst().get()
				.getQunantity();

		int qtyPromo = cQuantity >= dQuantity ? dQuantity : cQuantity;

		double extraQty = cQuantity >= dQuantity ? (cQuantity - dQuantity) * Product.SKU_C.getPrice()
				: (dQuantity - cQuantity) * Product.SKU_D.getPrice();

		return qtyPromo * Promo.TYPE_C_D.getPromoPrice() + extraQty;
	}

}
