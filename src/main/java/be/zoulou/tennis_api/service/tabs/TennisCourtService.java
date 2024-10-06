package be.zoulou.tennis_api.service.tabs;


import be.zoulou.tennis_api.model.tabs.TennisCourt;
import be.zoulou.tennis_api.repository.tabs.TennisCourtRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TennisCourtService {

    private final TennisCourtRepository courtTennisRepository;

    public TennisCourtService(TennisCourtRepository courtTennisRepository) {
        this.courtTennisRepository = courtTennisRepository;
    }

    public List<TennisCourt> getTennisCourts() {
        return StreamSupport.stream(courtTennisRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public TennisCourt getTennisCourtById(Long id) {
        return courtTennisRepository.findById(id).orElse(null);
    }
}
