package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;
import java.util.HashMap;
import java.util.Map;


public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();


    public Map<String, List<Product>> getProducts() {
        return products;
    }


    public void addProduct(Product product) {
        products.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
    }


    public int getTotalBasketPrice() {
        int totalPrice = 0;
        for (List<Product> oneProduct : products.values()) {
            if (!oneProduct.isEmpty()) {
                for (Product product : oneProduct) {
                    totalPrice += product.getProductPrice();
                }
            }
        }
        return totalPrice;
    }

    public void printBasket() {
        boolean isEmpty = false;
        for (Map.Entry<String, List<Product>> productTable : products.entrySet()) {
            if (productTable != null) {
                System.out.println(productTable);
                isEmpty = true;
            }
        }
        if (!isEmpty) {
            System.out.println("В корзине пусто");
            return;
        }
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
















