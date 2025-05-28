package org.skypro.skyshop.product;


import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private String productName;


    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Введите название продукта!");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }


    public abstract int getProductPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchedTerm() {
        return getProductName().toLowerCase();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }


    @Override
    public String getName() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}

