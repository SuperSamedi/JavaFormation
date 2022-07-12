package brussels.digitalcity.maxdolmans.demojavaee.services;

import brussels.digitalcity.maxdolmans.demojavaee.exceptions.ProductNotFoundException;
import brussels.digitalcity.maxdolmans.demojavaee.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static ProductService instance;

    public static ProductService getInstance(){
        if (instance == null)
            instance = new ProductService();

        return instance;

//        return instance == null ? instance = new ProductService() : instance;
    }

    private final List<Product> list = new ArrayList<>();

    private ProductService() {
        list.add(new Product(1, "Mountain", "Alpha", "Basic Land", 40.));
        list.add(new Product(2, "Forest", "Alpha", "Basic Land", 36.27));
        list.add(new Product(3, "Island", "Alpha", "Basic Land", 75.25));
        list.add(new Product(4, "Plains", "Alpha", "Basic Land", 26.99));
        list.add(new Product(5, "Swamp", "Alpha", "Basic Land", 43.12));
    }

    public List<Product> getAll() {
        return new ArrayList<>(list);
    }

    public Product getOne(int id) {
        return list.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
