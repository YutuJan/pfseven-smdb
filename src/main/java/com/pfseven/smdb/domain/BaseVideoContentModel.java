package com.pfseven.smdb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseVideoContentModel extends BaseModel {
    @NotNull
    private String title;

    @NotNull
    private Integer durationInSeconds;

    @NotNull
    private LocalDate releaseDate;

    @Min(value = 1, message = "{rating.min}")
    @Max(value = 10, message = "{rating.max}")
    private Float rating;
}
