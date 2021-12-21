package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.domain.VideoEntertainment;

public interface VideoEntertainmentService extends BaseService<VideoEntertainment, Long> {
    VideoEntertainment get(String title);

    VideoEntertainment find(String title);

    void newOccupation(VideoEntertainment videoEntertainment, Occupation occupation);

    void removeOccupation(VideoEntertainment videoEntertainment, Occupation occupation);
}
