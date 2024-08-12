package acc.br.model;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Product extends PanacheEntity {

    public String name;
    public double price;

    // Default constructor
    public Product() {}

    // Constructor with parameters
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}