package com.pfseven.smdb.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @NotNull(message = "Series' title cannot be null")
    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;

    @NotNull(message = "Series' info cannot be null")
    @Column(name = "INFO", length = 1000, nullable = false)
    private String info;

    @JsonManagedReference("episodes")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "series", targetEntity = Episode.class)
    private Set<Episode> episodes;


    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY", nullable = false)
    private SeriesCategory seriesCategory;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Fetch(value = FetchMode.JOIN)
    @Column(name = "GENRES", nullable = false)
    private Set<Genre> genres = new HashSet<>();
}
