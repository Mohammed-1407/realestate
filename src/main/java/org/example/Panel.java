package org.example;

public class Panel extends RealEstate implements PanelInterface {
    private int floor;           // which floor the apartment is on
    private boolean isInsulated; // external insulation

    public Panel() { super(); }

    public Panel(String city, double price, int sqm, double numberOfRooms, Genre genre,
                 int floor, boolean isInsulated) {
        super(city, price, sqm, numberOfRooms, genre);
        this.floor = floor;
        this.isInsulated = isInsulated;
    }

    public int getFloor() { return floor; }
    public boolean isInsulated() { return isInsulated; }

    public void setFloor(int floor) { this.floor = floor; }
    public void setInsulated(boolean insulated) { isInsulated = insulated; }

    @Override
    public int getTotalPrice() {
        // start with RealEstate base total (which includes city modifier)
        double total = super.getTotalPrice();

        // apply floor modifiers:
        // floors 0-2 => +5% ; floor 10 => -5%; otherwise no floor modifier
        if (floor >= 0 && floor <= 2) {
            total = total * 1.05;
        } else if (floor == 10) {
            total = total * 0.95;
        }

        // insulated => +5%
        if (isInsulated) total = total * 1.05;

        return (int) Math.round(total);
    }

    @Override
    public boolean hasSameAmount(RealEstate other) {
        if (other == null) return false;
        return this.getTotalPrice() == other.getTotalPrice();
    }

    @Override
    public int roomprice() {
        // average room price WITHOUT any settlement/floor/insulation modifiers:
        // base total = price per sqm * sqm
        double baseTotal = super.getPrice() * super.getSqm();
        double rooms = super.getNumberOfRooms();
        if (rooms <= 0) return 0;
        double avg = baseTotal / rooms;
        return (int) Math.round(avg);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Panel Apartment [city=").append(getCity())
                .append(", genre=").append(getGenre())
                .append(", pricePerSqm=").append(String.format("%.2f", getPrice()))
                .append(", sqm=").append(getSqm())
                .append(", rooms=").append(getNumberOfRooms())
                .append(", floor=").append(floor)
                .append(", insulated=").append(isInsulated())
                .append("]\nTotal price (with modifiers): ").append(getTotalPrice())
                .append("\nAverage sqm per room: ").append(String.format("%.2f", averageSqmPerRoom()))
                .append("\nAverage room price (base, no modifiers): ").append(roomprice());
        return sb.toString();
    }
}

