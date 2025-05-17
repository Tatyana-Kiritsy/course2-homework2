package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.BestResultNotFoundException;
import org.skypro.skyshop.searchable.SearchEngine;

import java.util.ArrayList;
import java.util.List;


public class App {

    public static void main(String[] args) throws BestResultNotFoundException {

        SearchEngine searchEngine = new SearchEngine();
        ProductBasket basketOne = new ProductBasket();
        basketOne.addProduct(new DiscountedProduct("orange",
                100, 10));
        basketOne.addProduct(new FixPriceProduct("biscuits"));
        basketOne.addProduct(new SimpleProduct("fish",
                180));
        basketOne.addProduct(new DiscountedProduct("honey", 248, 10));
        basketOne.addProduct(new SimpleProduct("oil", 135));
        basketOne.addProduct(new DiscountedProduct("sugar", 98, 5));
        basketOne.addProduct(new SimpleProduct("pepper", 18));
        basketOne.addProduct(new FixPriceProduct("garlic"));


        Article articleTwo = new Article("Oils", "For porridge and " +
                "salad: oils!");
        Article articleOne = new Article("Extra oil", "To give taste " +
                "without sugar!");

        searchEngine.add(new DiscountedProduct("sugar", 98,
                5));
        searchEngine.add(new SimpleProduct("butter", 135));
        searchEngine.add(articleOne);
        searchEngine.add(articleTwo);
        searchEngine.add(new Article("Extra dressing oil oil oil", "How to make your " +
                "meal  extra spicy"));

        try {
            DiscountedProduct basket = new DiscountedProduct("pasta",
                    110, 100);
            SimpleProduct basketTwo = new SimpleProduct("Orange", -110);
        } catch (IllegalArgumentException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        try {
            System.out.println(searchEngine.getSuitableSearchedItem("apple"));
        } catch (BestResultNotFoundException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        System.out.println(searchEngine.getSuitableSearchedItem("oil"));
        System.out.println();
        basketOne.printBasket();
        System.out.println();
        basketOne.addProduct(new SimpleProduct("tomato", 575));
        basketOne.printBasket();
        System.out.println();
        System.out.println("Общая стоимость корзины: " + basketOne.getTotalBasketPrice());
        System.out.println();
        System.out.println(basketOne.checkProductByName("orange"));
        System.out.println();
        System.out.println(basketOne.checkProductByName("tomato"));
        System.out.println();
        basketOne.removeProductByName(List.of("sugar", "orange","vinegar"));
        basketOne.removeProductByName(List.of("plum","vinegar"));
        basketOne.printBasket();
        System.out.println();
        System.out.println("Общая стоимость корзины: " + basketOne.getTotalBasketPrice());
        System.out.println();
        System.out.println(basketOne.checkProductByName("peach"));
        System.out.println();
        basketOne.clearBasket();
        basketOne.printBasket();
    }
}
