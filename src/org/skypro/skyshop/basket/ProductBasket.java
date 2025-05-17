package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.util.Spliterators.iterator;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();
    String productName;


    public List<Product> getProducts() {
        return products;
    }


    public void addProduct(Product product) {
        products.add(product);
    }


    public int getTotalBasketPrice() {
        int totalPrice = 0;
        for (Product oneProduct : products) {
            if (oneProduct != null) {
                totalPrice += oneProduct.getProductPrice();
            }
        }
        return totalPrice;
    }

    public void printBasket() {
        boolean isEmpty = false;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
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
        for (Product product : products) {
            if (product != null && product.isSpecial()) {
                counter++;
            }
        }
        return counter;
    }


    public boolean checkProductByName(String productName) {
        boolean isProduct = false;
        for (Product product : products) {
            if (product != null && Objects.equals(product.getProductName(), productName)) {
                return !isProduct;
            }
        }
        return isProduct;
    }

    public void clearBasket() {
        products.clear();
    }


    public List<Product> removeProductByName(List<String> productsName) {
        List<Product> productsList = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && productsName.contains(product.getProductName())) {
                productsList.add(product);
                iterator.remove();
            }
        }
        if (productsList.isEmpty()) {
            System.out.println("Список пуст");
        } else {
        System.out.println("Список удаленных продуктов: " + productsList);
        }
        return productsList;
    }
}









