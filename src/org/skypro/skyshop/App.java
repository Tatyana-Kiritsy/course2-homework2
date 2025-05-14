package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.BestResultNotFoundException;
import org.skypro.skyshop.searchable.SearchEngine;


public class App {

    public static void main(String[] args) throws BestResultNotFoundException {

        SearchEngine searchEngine = new SearchEngine(5);

        Article articleTwo = new Article("Oils", "For porridge and " +
                "salad: oils!");
        Article articleOne = new Article("Extra oil", "To give taste " +
                "without sugar!");

        searchEngine.add(new DiscountedProduct("sugar", 98,
                5));
        searchEngine.add(new SimpleProduct("butter", 135));
        searchEngine.add(articleOne);
        searchEngine.add(articleTwo);
        searchEngine.add(new Article("Extra dressing", "How to make your " +
                "meal  extra spicy"));

        try {
            DiscountedProduct basket = new DiscountedProduct("pasta",
                    110, 100);
            SimpleProduct basketOne = new SimpleProduct("Orange", -110);
        } catch (IllegalArgumentException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        try {
            System.out.println(searchEngine.getSuitableSearchedItem("apple"));
        } catch (BestResultNotFoundException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }

        System.out.println(searchEngine.getSuitableSearchedItem("oil"));
    }
}
