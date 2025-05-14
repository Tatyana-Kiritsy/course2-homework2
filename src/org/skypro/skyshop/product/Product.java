package org.skypro.skyshop.product;


import org.skypro.skyshop.searchable.Searchable;

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
        return getProductName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

}

