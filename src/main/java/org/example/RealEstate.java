package org.example;

public class RealEstate implements PropertyInterface {
    private String city;
    private double price;         // price per sqm
    private int sqm;
    private double numberOfRooms;
    private Genre genre;

    public RealEstate() { }

    public RealEstate(String city, double price, int sqm, double numberOfRooms, Genre genre) {
        this.city = city;
        this.price = price;
        this.sqm = sqm;
        this.numberOfRooms = numberOfRooms;
        this.genre = genre;
    }

    // getters / setters (only a few shown; add more if needed)
    public String getCity() { return city; }
    public double getPrice() { return price; }
    public int getSqm() { return sqm; }
    public double getNumberOfRooms() { return numberOfRooms; }
    public Genre getGenre() { return genre; }

    public void setCity(String city) { this.city = city; }
    public void setPrice(double price) { this.price = price; }
    public void setSqm(int sqm) { this.sqm = sqm; }
    public void setNumberOfRooms(double numberOfRooms) { this.numberOfRooms = numberOfRooms; }
    public void setGenre(Genre genre) { this.genre = genre; }

    @Override
    public void makeDiscount(int percent) {
        if (percent <= 0) return;
        // reduce price per sqm by percent
        price = price * (1.0 - percent / 100.0);
    }

    @Override
    public int getTotalPrice() {
        double base = price * sqm;           // base total
        double modifier = 0.0;

        if (city != null) {
            String c = city.trim().toLowerCase();
            if (c.equals("budapest")) modifier = 0.30;        // +30%
            else if (c.equals("debrecen")) modifier = 0.20;   // +20%
            else if (c.equals("nyíregyháza") || c.equals("nyiregyhaza")) modifier = 0.15; // +15%
        }

        double total = base * (1.0 + modifier);
        return (int) Math.round(total);
    }

    @Override
    public double averageSqmPerRoom() {
        if (numberOfRooms <= 0) return 0.0;
        return (double) sqm / numberOfRooms;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RealEstate [city=").append(city)
                .append(", genre=").append(genre)
                .append(", pricePerSqm=").append(String.format("%.2f", price))
                .append(", sqm=").append(sqm)
                .append(", rooms=").append(numberOfRooms)
                .append("]\nTotal price (with city modifier): ").append(getTotalPrice())
                .append("\nAverage sqm per room: ").append(String.format("%.2f", averageSqmPerRoom()));
        return sb.toString();
    }
}
