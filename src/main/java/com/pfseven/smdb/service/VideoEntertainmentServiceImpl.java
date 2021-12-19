package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Position;
import com.pfseven.smdb.domain.VideoEntertainment;
import com.pfseven.smdb.repository.BaseRepository;
import com.pfseven.smdb.repository.VideoEntertainmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoEntertainmentServiceImpl extends BaseServiceImpl<VideoEntertainment>
        implements VideoEntertainmentService {
    private final VideoEntertainmentRepository videoEntertainmentRepository;

    @Override
    public VideoEntertainment get(String title) {
        return null;
    }

    @Override
    public VideoEntertainment find(String title) {
        return null;
    }

    @Override
    public void newPosition(VideoEntertainment videoEntertainment, Position position) {

    }

    @Override
    public void removePosition(VideoEntertainment videoEntertainment, Position position) {

    }

    @Override
    BaseRepository<VideoEntertainment, Long> getRepository() {
        return videoEntertainmentRepository;
    }
}
