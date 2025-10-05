package org.example;

public interface PanelInterface {
    // returns true if the other RealEstate has the same total price as this
    boolean hasSameAmount(RealEstate other);

    // average price of one room (no city/floor/insulation modifiers)
    int roomprice();
}

