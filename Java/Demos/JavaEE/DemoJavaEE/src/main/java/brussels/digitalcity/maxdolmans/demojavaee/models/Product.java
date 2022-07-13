package brussels.digitalcity.maxdolmans.demojavaee.models;

public class Product {
    private int id;
    private String name;
    private String edition;
    private String type;
    private double price;

    public Product(int id, String name, String edition, String type, double price) {
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.type = type;
        this.price = price;
    }

    public Product(String name, String edition, String type, double price) {
        this.name = name;
        this.edition = edition;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String value) {
        edition = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        type = value;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double value) {
        price = value;
    }
}
