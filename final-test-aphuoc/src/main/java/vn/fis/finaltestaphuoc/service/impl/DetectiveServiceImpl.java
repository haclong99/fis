package vn.fis.finaltestaphuoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.finaltestaphuoc.entity.Detective;
import vn.fis.finaltestaphuoc.exception.DetectiveNotFoundException;
import vn.fis.finaltestaphuoc.repository.DetectiveRepository;
import vn.fis.finaltestaphuoc.repository.TrackEntryRepository;
import vn.fis.finaltestaphuoc.service.DetectiveService;

import java.util.List;
import java.util.Optional;

@Service
public class DetectiveServiceImpl implements DetectiveService {
    @Autowired
    DetectiveRepository detectiveRepository;

    @Autowired
    TrackEntryRepository trackEntryRepository;

    @Override
    public Detective createDetective(Detective detective) {
        return detectiveRepository.save(detective);
    }

    @Override
    public Detective updateDetective(Long id, Detective detectiveRequest) {
        Detective detective = detectiveRepository.findById(id)
                .orElseThrow(() -> new DetectiveNotFoundException("Detective", "id", id));

        detective.setBadgeNumber(detective.getBadgeNumber());
        return detectiveRepository.save(detective);
    }

    @Override
    public Detective findById(Long id) {
        Optional<Detective> result = detectiveRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new DetectiveNotFoundException("Detective", "id", id);
        }
    }

    @Override
    public List<Detective> findByUsername(String username) {
        return detectiveRepository.findByUsername(username);
    }
}
