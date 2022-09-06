package Essences;

public class Product {
    private String name;
    private String genre;
    private int price;

    public Product(String name, String genre, int price){
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Game: " +
                "name - " + name + " " +
                ", price - " + price + ".";
    }
}
