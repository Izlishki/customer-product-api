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
    private boolean is_deleted;
    private Timestamp created_at;
    private Timestamp modified_at;

    public void setId(Long id){this.id = id;}

    public void setTitle(String title) {this.title = title;}

    public void setIs_deleted(boolean is_deleted) {this.is_deleted = is_deleted;}

    public void setCreated_at(Timestamp created_at) {this.created_at = created_at;}

    public void setModified_at(Timestamp modified_at) {this.modified_at = modified_at;}

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public boolean getIs_deleted() {return is_deleted;}

    public Timestamp getCreated_at() {return created_at;}

    public Timestamp getModified_at() {return modified_at;}

    @Override
    public String toString() {
        return "Customers{" +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", is_deleted = '" + is_deleted + '\'' +
                ", create_at = " + created_at +'\''+
                ",modified_at = "+modified_at+
                '}';
    }
}
