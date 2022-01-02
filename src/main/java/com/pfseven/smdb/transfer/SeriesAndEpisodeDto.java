package com.pfseven.smdb.transfer;

import com.pfseven.smdb.domain.Episode;
import com.pfseven.smdb.domain.Series;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SeriesAndEpisodeDto {
    @NotNull
    Series series;

    @NotNull
    Episode episode;
}
