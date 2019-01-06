package by.vasili.khalko.datamodel;


import javax.persistence.*;

@Entity
@Table(name = "Parts", schema = "test")
public class Part extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Boolean need;

    @Column
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public boolean isNeed() {
        return need;
    }

    public void setNeed(Boolean need) {
        this.need = need;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
