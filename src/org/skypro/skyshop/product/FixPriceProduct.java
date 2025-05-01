package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int PRODUCT_PRICE = 100;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getProductPrice() {
        return PRODUCT_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.getProductName() + ": " + getProductPrice();
    }
}
