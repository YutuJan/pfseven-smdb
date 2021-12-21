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
@Table(name = "POSITIONS")
@SequenceGenerator(name = "idGenerator", sequenceName = "POSITIONS_SEQ", initialValue = 1, allocationSize = 1)
public class Position extends BaseModel {
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "POSITION", nullable = false)
    private FilmographyRole position;

    @ManyToOne
    @MapsId("id")
    private VideoEntertainment videoEntertainment;

    @ManyToOne
    @MapsId("id")
    private Person person;
}
