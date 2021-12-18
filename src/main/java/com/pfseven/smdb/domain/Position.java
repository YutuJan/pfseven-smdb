package com.pfseven.smdb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Position extends BaseModel {
    @NotNull
    @Enumerated(EnumType.STRING)
    private FilmographyRole position;
    @NotNull
    @OneToOne
    private VideoEntertainment videoEntertainment;
    @NotNull
    @OneToOne
    private Person person;
}
