package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.basket.ProductBasket;


public class App {
    public static void main(String[] args) {
        ProductBasket basketOne = new ProductBasket();

        basketOne.addProduct(new DiscountedProduct("honey", 248, 10));
        basketOne.addProduct(new SimpleProduct("oil", 135));
        basketOne.addProduct(new DiscountedProduct("sugar", 98, 5));
        basketOne.addProduct(new SimpleProduct("pepper", 18));
        basketOne.addProduct(new FixPriceProduct("garlic"));

        basketOne.printBasket();
        System.out.println();
        basketOne.addProduct(new SimpleProduct("tomato", 575));
        basketOne.printBasket();
        System.out.println();
        System.out.println("Общая стоимость корзины: " + basketOne.getTotalBasketPrice());
        System.out.println();
        System.out.println(basketOne.checkProductByName("orange"));
        System.out.println();
        System.out.println(basketOne.checkProductByName("pepper"));
        System.out.println();
        basketOne.clearBasket();
        basketOne.printBasket();
        System.out.println();
        System.out.println("Общая стоимость корзины: " + basketOne.getTotalBasketPrice());
        System.out.println();
        System.out.println(basketOne.checkProductByName("peach"));

    }
}