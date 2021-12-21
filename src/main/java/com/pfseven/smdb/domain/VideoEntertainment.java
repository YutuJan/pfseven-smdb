package com.pfseven.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ENTERTAINMENT_VIDEOS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ENTERTAINMENT_VIDEOS_SEQ", initialValue = 1, allocationSize = 1)
public class VideoEntertainment extends BaseModel {
    @NotNull
    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;

    @NotNull
    @Column(name = "SUMMARY", length = 1000)
    private String summary;

    @NotNull
    @Column(name = "DURATION_IN_SECONDS", nullable = false)
    private Integer durationInSeconds;

    @NotNull
    @Column(name = "RELEASE_DATE", nullable = false)
    private LocalDate releaseDate;

    @NotNull
    @Column(name = "DISTRIBUTOR", nullable = false)
    private String distributor;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY", nullable = false)
    private VideoEntertainmentCategory videoEntertainmentCategory;

    @Min(value = 1, message = "{rating.min}")
    @Max(value = 10, message = "{rating.max}")
    @Column(name = "RATING", nullable = false)
    private Double rating;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE", nullable = false)
    private Set<Genre> genres = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    @Column(name = "CAST_N_CREW")
    private Set<Occupation> castAndCrew = new HashSet<>();
}
