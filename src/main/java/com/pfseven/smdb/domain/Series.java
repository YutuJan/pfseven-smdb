package com.pfseven.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "SERIES")
@SequenceGenerator(name = "idGenerator", sequenceName = "SERIES_SEQ", initialValue = 1, allocationSize = 1)
public class Series extends BaseModel {
    @NotNull
    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;

    @NotNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    private Set<Season> seasons;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY", nullable = false)
    private SeriesCategory seriesCategory;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE", nullable = false)
    private Set<Genre> genres = new HashSet<>();
}
