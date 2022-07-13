package finalexam.gdm.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

//Product: productId:long (PK), productNumber:long, name:String, unitPrice:double, quantityInStock:int, dateSupplied:date
@Entity
@Table(name="accounts")
@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name="accountNumber", nullable = false, unique = true)
    @NotNull(message = "ACcount Number cannot be null.")
    private String accountNumber;

    @Column(name="accountType", nullable = false)
    @NotNull(message ="Account Type cannot be null")
    @NotBlank(message ="Account Type cannot be blank")
    private String accountType;

    @Column(name="balance", nullable = false)
    private double balance;


    @Column(name="dateOpened")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOpened;

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customerId;


//    @Override
//    public String toString() {
//        return productNumber +"[" + productName  + "]";
//    }
}