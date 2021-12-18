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
public class Person extends BaseModel {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private String birthPlace;

    @NotNull
    private String biography;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    private Set<Position> positions = new HashSet<>();
}
