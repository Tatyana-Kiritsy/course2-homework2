package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        List<Product> productList = products.computeIfAbsent(product.getProductName(),
                k -> new ArrayList<>());
        productList.add(product);
    }

    public int getTotalBasketPrice() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getProductPrice)
                .sum();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        products.entrySet()
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalBasketPrice());
        System.out.println("Специальных товаров: " + checkCounter());
    }

    public int checkCounter() {
        int counter = 0;
        for (List<Product> oneProduct : products.values()) {
            if (!oneProduct.isEmpty()) {
                for (Product product : oneProduct) {
                    if (product != null && product.isSpecial()) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public boolean checkProductByName(String product) {
        boolean isProduct = false;
        for (String productName : products.keySet()) {
            if (productName != null && products.containsKey(product)) {
                return !isProduct;
            }
        }
        return isProduct;
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProductByName(List<String> itemsList) {
        List<Product> removedProductsList = new ArrayList<>();
        for (String item : itemsList) {
            List<Product> removedProducts = products.remove(item);
            if (removedProducts != null) {
                removedProductsList.addAll(removedProducts);
            }
        }
        return removedProductsList;
    }
}
















