package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class ProductBasket {
    private final Product[] products = new Product[5];

    public ProductBasket() {
    }

    public Product[] getProducts() {
        return products;
    }


    public void addProduct(Product product) {
        boolean isFull = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        if (!isFull) {
            System.out.println("Невозможно добавить продукт.");
        }
    }

    public int getTotalBasketPrice() {
        int totalPrice = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                totalPrice += products[i].getProductPrice();
            }
        }
        return totalPrice;
    }

    public void printBasket() {
        boolean isEmpty = false;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getProductName() + ": " +
                        product.getProductPrice());
                isEmpty = true;
            }
        }
        if (!isEmpty) {
            System.out.println("В корзине пусто");
            return;
        }
        System.out.println("Итого: " + getTotalBasketPrice());
    }

    public boolean checkProductByName(String productName) {
        boolean isProduct = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && Objects.equals(products[i].getProductName(), productName)) {
                return !isProduct;
            }
        }
        return isProduct;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i] = null;
            }
        }
    }

}


