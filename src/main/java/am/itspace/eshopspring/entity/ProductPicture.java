package am.itspace.eshopspring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_picture")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String picName;

    @ManyToOne
    private Product product;


}
