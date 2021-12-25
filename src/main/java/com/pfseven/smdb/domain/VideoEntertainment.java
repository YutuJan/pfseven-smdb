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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VideoEntertainment extends BaseModel {
    @NotNull(message = "Movie's title cannot be null")
    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;

    @NotNull(message = "Movie's plot summary cannot be null")
    @Column(name = "SUMMARY", length = 1000)
    private String summary;

    @NotNull(message = "Movie's duaration cannot be null")
    @Column(name = "DURATION_IN_SECONDS", nullable = false)
    private Integer durationInSeconds;

    @NotNull(message = "Movie's release date cannot be null")
    @Column(name = "RELEASE_DATE", nullable = false)
    private LocalDate releaseDate;

    @Min(value = 1, message = "{rating.min}")
    @Max(value = 10, message = "{rating.max}")
    @Column(name = "RATING", nullable = false)
    private Double rating;

    @NotNull(message = "Movie's distributor cannot be null")
    @Column(name = "DISTRIBUTOR", nullable = false)
    private String distributor;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    @Column(name = "CAST_N_CREW")
    private Set<Occupation> castAndCrew = new HashSet<>();
}
