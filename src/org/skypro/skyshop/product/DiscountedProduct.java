package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int productPrice;
    private int discountInPercent;

    public DiscountedProduct(String productName, int productPrice, int discountInPercent) {
        super(productName);
        if (productPrice <= 0 || discountInPercent < 0 || discountInPercent > 100 ) {
            throw new IllegalArgumentException();
        }
        this.productPrice = productPrice;
        this.discountInPercent = discountInPercent;
    }

    public int getDiscountInPercent() {
        return discountInPercent;
    }

    @Override
    public int getProductPrice() {
        return productPrice - productPrice * discountInPercent / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.getProductName() + ": " + getProductPrice() + " (" + discountInPercent + " %)";
    }
}
