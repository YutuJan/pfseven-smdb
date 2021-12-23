package com.pfseven.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "SEASONS")
@SequenceGenerator(name = "idGenerator", sequenceName = "SEASONS_SEQ", initialValue = 1, allocationSize = 1)
public class Season extends BaseModel {
    @NotNull
    @Column(name = "TITLE", nullable = false)
    private Integer number;

    @NotNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    private Set<Episode> episodes;

    @NotNull
    @ToString.Exclude
    @ManyToOne
    @MapsId("id")
    private Series series;
}
