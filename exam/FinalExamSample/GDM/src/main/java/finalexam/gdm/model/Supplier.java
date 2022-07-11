package finalexam.gdm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    @Column(name="supplierNumber", nullable = false, unique = true)
    @NotNull(message = "Supplier number is required")

    private String supplierNumber;

    @Column(name="name", nullable = false)
    @NotNull(message = "Supplier name can not be a null or empty")
    @NotBlank(message = "Supplier name can not be a blank")
    private String name;

    @Column(name="phone")
    private String phone;

    @OneToMany(mappedBy="supplierId")
    private List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return name + "[" + supplierNumber +"]";
    }

//    public Long getSupplierId() {
//        return supplierId;
//    }
//
//    public void setSupplierId(Long supplierId) {
//        this.supplierId = supplierId;
//    }
//
//    public String getSupplierNumber() {
//        return supplierNumber;
//    }
//
//    public void setSupplierNumber(String supplierNumber) {
//        this.supplierNumber = supplierNumber;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
//
//    public Supplier(){}
//
//    public Supplier(Long supplierId, String supplierNumber, String name, String phone) {
//        this.supplierId = supplierId;
//        this.supplierNumber = supplierNumber;
//        this.name = name;
//        this.phone = phone;
//    }
}
