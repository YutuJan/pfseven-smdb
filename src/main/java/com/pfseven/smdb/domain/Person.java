package com.pfseven.smdb.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "PEOPLE",
        uniqueConstraints = @UniqueConstraint(name = "UniqueFirstnameAndLastname", columnNames = {"FIRST_NAME", "LAST_NAME"}))
@SequenceGenerator(name = "idGenerator", sequenceName = "PEOPLE_SEQ", initialValue = 1, allocationSize = 1)
public class Person extends BaseModel {
    @NotNull(message = "Person's firstname cannot be null")
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotNull(message = "Person's lastname cannot be null")
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotNull(message = "Person's birthdate cannot be null")
    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    @Column(name = "BIRTH_PLACE", nullable = false)
    private String birthPlace;

    @Column(name = "BIOGRAPHY", length = 10000)
    private String biography;

    @JsonManagedReference("person")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "OCCUPATIONS")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Occupation> occupations = new HashSet<>();

    public void addOccupation(Occupation occupation) {
        occupations.add(occupation);
    }

    public void removeOccupation(Occupation occupation) {
        occupations.remove(occupation);
    }
}
