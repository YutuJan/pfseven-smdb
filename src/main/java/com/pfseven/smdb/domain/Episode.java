package com.pfseven.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EPISODES")
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODES_SEQ", initialValue = 1, allocationSize = 1)
public class Episode extends VideoEntertainment {
    @NotNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @MapsId("id")
    private Season season;
}
