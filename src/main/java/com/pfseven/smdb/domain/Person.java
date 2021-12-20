package com.pfseven.smdb.domain;

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
@Table(name = "PEOPLE")
@SequenceGenerator(name = "idGenerator", sequenceName = "PEOPLE_SEQ", initialValue = 1, allocationSize = 1)
public class Person extends BaseModel {
    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    @NotNull
    @Column(name = "BIRTH_PLACE", nullable = false)
    private String birthPlace;

    @NotNull
    @Column(name = "BIOGRAPHY")
    private String biography;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    @Column(name = "POSITIONS")
    private Set<Position> positions = new HashSet<>();
}
