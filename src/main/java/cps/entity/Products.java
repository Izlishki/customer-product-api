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
    private boolean isDeleted;
    private Timestamp createdAt;
    private Timestamp modifiedAt;



    public void setId(Long id) { this.id = id; }

    public void setCustomerId(Customers customer) {
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

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) { this.modifiedAt = modifiedAt; }

    public Long getId() {
        return id;
    }

    public Customers getCustomerId() {
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

    public boolean getIsDeleted(){return isDeleted;}

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id = " + id +
                ", customer_id = '" + customer + '\'' +
                ", title = '" + title + '\'' +
                ", description = '" + description + '\'' +
                ", price = '" + price + '\'' +
                ", is_deleted = '" + isDeleted + '\'' +
                ", create_at = " + createdAt +'\''+
                ",modified_at = "+modifiedAt+
                '}';
    }
}
