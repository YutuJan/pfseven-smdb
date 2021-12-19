package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Position;
import com.pfseven.smdb.domain.VideoEntertainment;

public interface VideoEntertainmentService extends BaseService<VideoEntertainment, Long> {
    VideoEntertainment get(String title);

    VideoEntertainment find(String title);

    void newPosition(VideoEntertainment videoEntertainment, Position position);

    void removePosition(VideoEntertainment videoEntertainment, Position position);
}
