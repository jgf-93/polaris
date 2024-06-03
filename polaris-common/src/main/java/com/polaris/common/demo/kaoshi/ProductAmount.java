package com.polaris.common.demo.kaoshi;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductAmount {
    public static void main(String[] args) {
        Product productA = new Product(10000l, 1);
        Product productB = new Product(20000l, 2);
        Product productC = new Product(30000l, 3);
        sysFinalPrice(150000l, productA, productB, productC);
    }

    public static void sysFinalPrice(Long totalAmount, Product productA, Product productB, Product productC) {
        BigDecimal aFinalPrice = new BigDecimal(productA.getUnitPrice() * productA.getQuantity());
        BigDecimal bFinalPrice = new BigDecimal(productB.getUnitPrice() * productB.getQuantity());
        BigDecimal cFinalPrice = new BigDecimal(productC.getUnitPrice() * productC.getQuantity());
        BigDecimal finalPrice = aFinalPrice.add(bFinalPrice).add(cFinalPrice);
        BigDecimal aPercent = aFinalPrice.divide(finalPrice, 2, RoundingMode.HALF_UP);
        BigDecimal bPercent = bFinalPrice.divide(finalPrice, 2, RoundingMode.HALF_UP);
        BigDecimal cPercent = BigDecimal.valueOf(1).subtract(aPercent).subtract(bPercent);
        //产品A的分摊价格
        productA.setAmount(BigDecimal.valueOf(totalAmount).multiply(aPercent).toString());
        //产品B的分摊价格
        productB.setAmount(BigDecimal.valueOf(totalAmount).multiply(bPercent).toString());
        //产品C的分摊价格
        productC.setAmount(BigDecimal.valueOf(totalAmount).multiply(cPercent).toString());
        System.out.println("产品A分摊价格：" + productA.getAmount() + "产品B分摊价格：" + productB.getAmount() + "产品C分摊价格：" + productC.getAmount());
    }

    @Data
    public static class Product implements Serializable {
        private Long unitPrice;
        private int quantity;
        private String amount;

        public Product(Long unitPrice, int quantity) {
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }
    }

}
