package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.domain.VideoEntertainment;
import com.pfseven.smdb.repository.VideoEntertainmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
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
    public void newOccupation(VideoEntertainment videoEntertainment, Occupation occupation) {

    }

    @Override
    public void removeOccupation(VideoEntertainment videoEntertainment, Occupation occupation) {

    }

    @Override
    JpaRepository<VideoEntertainment, Long> getRepository() {
        return videoEntertainmentRepository;
    }
}
