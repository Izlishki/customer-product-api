package cps.entity;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customers {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private boolean isDeleted;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public void setId(Long id){this.id = id;}

    public void setTitle(String title) {this.title = title;}

    public void setIsDeleted(boolean is_deleted) {this.isDeleted = is_deleted;}

    public void setCreatedAt(Timestamp createdAt) {this.createdAt = createdAt;}

    public void setModifiedAt(Timestamp modifiedAt) {this.modifiedAt = modifiedAt;}

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public boolean getIsDeleted() {return isDeleted;}

    public Timestamp getCreatedAt() {return createdAt;}

    public Timestamp getModifiedAt() {return modifiedAt;}

    @Override
    public String toString() {
        return "Customers{" +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", is_deleted = '" + isDeleted + '\'' +
                ", create_at = " + createdAt +'\''+
                ",modified_at = "+modifiedAt+
                '}';
    }
}
