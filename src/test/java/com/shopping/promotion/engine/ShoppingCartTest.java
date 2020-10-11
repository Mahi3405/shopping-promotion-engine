package com.shopping.promotion.engine;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import com.shopping.promotion.engine.entity.Item;
import com.shopping.promotion.engine.util.Product;


/**
 * Unit test for shopping cart.
 */
public class ShoppingCartTest 
{
    @Test
	public void totalOfEmptyCart()
	{
    	ShoppingCart cart = buildShoppingCart();
    	assertEquals(0.0, cart.getTotal(), 0.0);
    	
	}
    @Test
	public void totalOfSingleSkuItem()
	{
    	ShoppingCart cart = buildShoppingCart(new Item( 1, Product.SKU_A));
    	assertEquals(50.0, cart.getTotal(), 0.0);
	}
    
    @Test
	public void totalOfTwoItemsFromSameSku()
	{
    	ShoppingCart cart = buildShoppingCart(new Item(2, Product.SKU_A));
    	assertEquals(100.0, cart.getTotal(), 0.0);
	}
    
    @Test
	public void totalOfTwoSkuItems()
	{
    	ShoppingCart cart =buildShoppingCart(new Item(2, Product.SKU_A), new Item(2, Product.SKU_B));
    	assertEquals(160.0, cart.getTotal(), 0.0);
	}
    
    private ShoppingCart buildShoppingCart(Item... items) {
		List<Item> itemList = new ArrayList<Item>();
		itemList.addAll(Arrays.asList(items));
		return new ShoppingCart(itemList);
	}
    
    
}
