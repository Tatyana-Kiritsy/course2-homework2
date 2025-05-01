package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;


public class App {
    public static void main(String[] args) {
        ProductBasket basketOne = new ProductBasket();

        basketOne.addProduct(new Product("honey", 248));
        basketOne.addProduct(new Product("oil", 135));
        basketOne.addProduct(new Product("sugar", 98));
        basketOne.addProduct(new Product("pepper", 18));
        basketOne.addProduct(new Product("garlic", 395));

        basketOne.printBasket();
        System.out.println();
        basketOne.addProduct(new Product("tomato", 575));
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