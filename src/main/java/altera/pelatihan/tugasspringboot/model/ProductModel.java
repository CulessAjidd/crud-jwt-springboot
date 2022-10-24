package altera.pelatihan.tugasspringboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 64)
    private String name;
    @Column(name = "harga")
    private Integer harga;

    public ProductModel() {
    }

    public ProductModel(String name, Integer harga) {
        this.name = name;
        this.harga = harga;
    }
}
