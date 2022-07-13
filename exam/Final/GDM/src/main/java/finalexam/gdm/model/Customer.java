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
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name="firstName", nullable = false)
    @NotNull(message = "First Name cannot be null.")
    private String firstName;

    @Column(name="lastName", nullable = false)
    @NotNull(message ="Last Name cannot be null")
    @NotBlank(message ="Last Name cannot be blank")
    private String lastName;

    @OneToMany(mappedBy="customerId")
    private List<Account> accounts = new ArrayList<>();

    @Override
    public String toString() {
        return firstName  +  "  "+ lastName;
    }
}
