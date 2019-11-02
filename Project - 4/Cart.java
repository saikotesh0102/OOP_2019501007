import java.util.*;

public class Cart extends User{
    
    ArrayList<Product> products;
    
    public Cart() {
        products = new ArrayList<>();
    }

    void add(Product product) {
        this.products.add(product);
    }
}