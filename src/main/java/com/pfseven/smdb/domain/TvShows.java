package com.pfseven.smdb.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class TvShows extends BaseVideoContentModel {
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    private HashSet<String> distributors = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    private Set<Person> castAndCrew = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    private Set<Episode> episodes = new HashSet<>();
}
