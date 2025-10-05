package org.example;

public class Main {
    public static void main(String[] args) {
        // Create a RealEstate example
        RealEstate re1 = new RealEstate("Budapest", 400000.0, 50, 3, Genre.FAMILYHOUSE);
        System.out.println(re1);
        System.out.println();

        // Make a discount
        re1.makeDiscount(10); // 10% discount on price per sqm
        System.out.println("After 10% discount:");
        System.out.println(re1);
        System.out.println();

        // Create a Panel apartment
        Panel p1 = new Panel("Debrecen", 200000.0, 60, 3, Genre.CONDOMINIUM, 1, true);
        System.out.println(p1);
        System.out.println();

        // Compare total price between panel and another real estate
        RealEstate re2 = new RealEstate("Debrecen", 200000.0, 60, 3, Genre.CONDOMINIUM);
        System.out.println("Panel total: " + p1.getTotalPrice());
        System.out.println("Other RE total: " + re2.getTotalPrice());
        System.out.println("Same total? " + p1.hasSameAmount(re2));
    }
}
