package org.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Status;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "programmers")
public class Programmer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private Status status;
    private String location;


    @ManyToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER, mappedBy = "programmers")
    private List<Project> projects;
    @OneToOne(mappedBy = "programmer")
    private Address address;

    public Programmer(String fullName, String email, LocalDate dateOfBirth, Status status, String location) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.location = location;
    }
}
