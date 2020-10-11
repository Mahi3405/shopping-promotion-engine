package com.shopping.promotion.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    	assertEquals(145.0, cart.getTotal(), 0.0);
	}
   
    @Test
	public void test_isCartContainsBothCDSkus() {
		ShoppingCart cart = buildShoppingCart(new Item(3, Product.SKU_A), new Item(5, Product.SKU_B),
				new Item(1, Product.SKU_C), new Item(1, Product.SKU_D));
		assertTrue(cart.isCartContainsBothSkus());
	}
    
    @Test
   	public void test_isCartContainsBothCDSkus_False() {
   		ShoppingCart cart = buildShoppingCart(new Item(3, Product.SKU_A), new Item(5, Product.SKU_B),
   				new Item(1, Product.SKU_C));
   		assertFalse(cart.isCartContainsBothSkus());
   	}
    
    @Test
	public void test_getTotalOfMultiSkuPromotion() {
		ShoppingCart cart = buildShoppingCart(new Item(3, Product.SKU_A), new Item(5, Product.SKU_B),
				new Item(1, Product.SKU_C), new Item(2, Product.SKU_D));
		assertEquals(295.0, cart.getTotal(), 0.0);
	}
    
    @Test
	public void totalOfThreeItemsFromSkuA()
	{
    	ShoppingCart cart = buildShoppingCart(new Item(3, Product.SKU_A));
    	assertEquals(130.0, cart.getTotal(), 0.0);
	}
    
    @Test
	public void test_TotalCartValue_For_Scenario_A() {
		ShoppingCart cart = buildShoppingCart(new Item(1, Product.SKU_A), new Item(1, Product.SKU_B),
				new Item(1, Product.SKU_C));
		assertEquals(100.0, cart.getTotal(), 0.0);
	}
    
    @Test
	public void test_TotalCartValue_For_Scenario_B() {
		ShoppingCart cart = buildShoppingCart(new Item(5, Product.SKU_A), new Item(5, Product.SKU_B),
				new Item(1, Product.SKU_C));
		assertEquals(370.0, cart.getTotal(), 0.0);
	}

	@Test
	public void test_TotalCartValue_For_Scenario_C() {

		ShoppingCart cart = buildShoppingCart(new Item(3, Product.SKU_A), new Item(5, Product.SKU_B),
				new Item(1, Product.SKU_C), new Item(1, Product.SKU_D));
		assertEquals(280.0, cart.getTotal(), 0.0);
	}

	@Test
	public void test_TotalCartValue_For_Scenario_D() {
		ShoppingCart cart = buildShoppingCart(new Item(5, Product.SKU_A), new Item(5, Product.SKU_B),
				new Item(3, Product.SKU_C), new Item(2, Product.SKU_D));
		assertEquals(430.0, cart.getTotal(), 0.0);
	}

	@Test
	public void test_TotalCartValue_For_Scenario_E() {
		ShoppingCart cart = buildShoppingCart(new Item(1, Product.SKU_A), new Item(3, Product.SKU_B),
				new Item(1, Product.SKU_C), new Item(2, Product.SKU_D));
		assertEquals(170.0, cart.getTotal(), 0.0);
	}

	@Test
	public void test_TotalCartValue_For_Scenario_G() {
		ShoppingCart cart = buildShoppingCart(new Item(2, Product.SKU_C), new Item(1, Product.SKU_D));
		assertEquals(50.0, cart.getTotal(), 0.0);
	}
	
    private ShoppingCart buildShoppingCart(Item... items) {
		List<Item> itemList = new ArrayList<Item>();
		itemList.addAll(Arrays.asList(items));
		return new ShoppingCart(itemList);
	}
    
    
}
