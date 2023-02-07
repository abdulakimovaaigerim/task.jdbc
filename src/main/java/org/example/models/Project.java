package org.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "projects")
@Setter
@Getter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "project_name")
    private String projectName;
    private String description;

    @Column (name = "date_of_start")
    private LocalDate dateOfStart;

    @Column (name = "date_of_finish")
    private LocalDate dateOfFinish;
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "projects_programmers",
            joinColumns = @JoinColumn(name = "programmers_id"),
            inverseJoinColumns = @JoinColumn(name = "projects_id"))
    private List<Programmer> programmers;

    public Project(String projectName, String description, LocalDate dateOfStart, LocalDate dateOfFinish, BigDecimal price) {
        this.projectName = projectName;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.price = price;
    }
}
