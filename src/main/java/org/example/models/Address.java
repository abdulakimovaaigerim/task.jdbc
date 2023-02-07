package org.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String region;
    private String street;

    @Column(name = "home_number")
    private int homeNumber;

    @OneToOne
    private Programmer programmer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;
    public Address(String region, String street, int homeNumber) {
        this.region = region;
        this.street = street;
        this.homeNumber = homeNumber;
    }
}
