package ua.gnatyshyn.demo.Entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String years;

    public Human(String name, String surname, String years) {
        this.name = name;
        this.surname = surname;
        this.years = years;
    }
}

