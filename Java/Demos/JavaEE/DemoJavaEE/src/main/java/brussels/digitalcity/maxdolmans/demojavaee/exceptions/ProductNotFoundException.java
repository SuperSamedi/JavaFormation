package brussels.digitalcity.maxdolmans.demojavaee.exceptions;

public class ProductNotFoundException extends RuntimeException {

    private int id;

    public ProductNotFoundException(int id) {
        super("The product with id {" + id + "} could not be found.");
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
