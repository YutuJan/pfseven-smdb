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
public class VideoEntertainment extends BaseModel {
    @NotNull
    private String title;

    @NotNull
    private String summary;

    @NotNull
    private Integer durationInSeconds;

    @NotNull
    private LocalDate releaseDate;

    @NotNull
    private String distributor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private VideoEntertainmentCategory videoEntertainmentCategory;

    @Min(value = 1, message = "{rating.min}")
    @Max(value = 10, message = "{rating.max}")
    private Float rating;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    private Set<Position> castAndCrew = new HashSet<>();
}
