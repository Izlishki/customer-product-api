package cps.entity;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name="products")

public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Customers customer;
    private String title;
    private String description;
    private double price;
    private boolean is_deleted;
    private Timestamp created_at;
    private Timestamp modified_at;



    public void setId(Long id) { this.id = id; }

    public void setCustomer_id(Customers customer) {
        this.customer = customer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setModified_at(Timestamp modified_at) {
        this.modified_at = modified_at;
    }

    public Long getId() {
        return id;
    }

    public Customers getCustomer_id() {
        return customer;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIs_deleted(){return is_deleted;}

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getModified_at() {
        return modified_at;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id = " + id +
                ", customer_id = '" + customer + '\'' +
                ", title = '" + title + '\'' +
                ", description = '" + description + '\'' +
                ", price = '" + price + '\'' +
                ", is_deleted = '" + is_deleted + '\'' +
                ", create_at = " + created_at +'\''+
                ",modified_at = "+modified_at+
                '}';
    }
}
