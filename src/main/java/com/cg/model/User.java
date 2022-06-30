package com.cg.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "UserName", nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column
    private Role role;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
//    private Customer customer;

//    @OneToOne(targetEntity = Customer.class)




}
