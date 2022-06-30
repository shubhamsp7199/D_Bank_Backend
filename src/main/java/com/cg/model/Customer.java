package com.cg.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(nullable = false, unique = true)
    private int accountNumber;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private Long mobileNumber;

    private String address;

    private String accountType;

//    @OneToOne(mappedBy = "customerId")
//    private User userId;

//    @OneToOne(targetEntity = User.class)
//    private User user;

}
