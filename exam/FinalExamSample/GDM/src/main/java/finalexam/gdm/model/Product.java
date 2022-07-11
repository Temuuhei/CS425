package finalexam.gdm.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

//Product: productId:long (PK), productNumber:long, name:String, unitPrice:double, quantityInStock:int, dateSupplied:date
@Entity
@Table(name="products")
@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name="productNumber", nullable = false, unique = true)
    @NotNull(message = "Product Number cannot be null.")
    private Long productNumber;

    @Column(name="productName", nullable = false)
    @NotNull(message ="Product Name cannot be null")
    @NotBlank(message ="Product Name cannot be blank")
    private String productName;

    @Column(name="unitPrice", nullable = false)
    private double unitPrice;

    @Column(name="quantityInStock", nullable = false)
    private int quantityInStock;

    @Column(name="dateSupplied", nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateSupplied;

    @ManyToOne
    @JoinColumn(name="supplierId")
    private Supplier supplierId;


//    @Override
//    public String toString() {
//        return productNumber +"[" + productName  + "]";
//    }
}