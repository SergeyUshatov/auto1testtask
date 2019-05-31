package model;

public class CarSearchResult {
    private int price;
    private int year;
    private String title;

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public CarSearchResult setPrice(int price) {
        this.price = price;
        return this;
    }

    public CarSearchResult setYear(int year) {
        this.year = year;
        return this;
    }

    public CarSearchResult setTitle(String title) {
        this.title = title;
        return this;
    }
}
