package com.pfseven.smdb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "OCCUPATIONS")
@SequenceGenerator(name = "idGenerator", sequenceName = "OCCUPATIONS_SEQ", initialValue = 1, allocationSize = 1)
public class Occupation extends BaseModel {
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "OCCUPATION", nullable = false)
    private FilmographyRole occupation;

    @ManyToOne
    @MapsId("id")
    private VideoEntertainment videoEntertainment;

    @ManyToOne
    @MapsId("id")
    private Person person;
}