package org.example;

public interface PropertyInterface {
    // reduces the price per sqm by given integer percentage
    void makeDiscount(int percent);

    // returns total price (including city modifier) as integer
    int getTotalPrice();

    // average sqm per room
    double averageSqmPerRoom();
}
