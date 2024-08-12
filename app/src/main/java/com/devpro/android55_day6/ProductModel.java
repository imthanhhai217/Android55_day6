package com.devpro.android55_day6;

public class ProductModel {
    private String productName, productImage;
    private Double productPrice;
    private String productColor;
    private String productSize;
    private int quantity;

    public ProductModel() {
    }

    public ProductModel(String productName, String productImage, Double productPrice, String productColor, String productSize, int quantity) {
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productSize = productSize;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productPrice=" + productPrice +
                ", productColor='" + productColor + '\'' +
                ", productSize='" + productSize + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
