package vn.fis.finaltestaphuoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.finaltestaphuoc.entity.Evidence;
import vn.fis.finaltestaphuoc.exception.EvidenceNotFoundException;
import vn.fis.finaltestaphuoc.repository.EvidenceRepository;
import vn.fis.finaltestaphuoc.repository.StorageRepository;
import vn.fis.finaltestaphuoc.repository.TrackEntryRepository;
import vn.fis.finaltestaphuoc.service.EvidenceService;

import java.util.Optional;

@Service
public class EvidenceServiceImpl implements EvidenceService {
    @Autowired
    EvidenceRepository evidenceRepository;

    @Autowired
    StorageRepository storageRepository;

    @Autowired
    TrackEntryRepository trackEntryRepository;

    @Override
    public Evidence createEvidence(Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    @Override
    public Evidence updateEvidence(Long id, Evidence evidenceRequest) {
        Evidence evidence = evidenceRepository.findById(id)
                .orElseThrow(() -> new EvidenceNotFoundException("Evidence", "id", id));

        evidence.setItemName(evidence.getItemName());
        return evidenceRepository.save(evidence);
    }

    @Override
    public Evidence findById(Long id) {
        Optional<Evidence> result = evidenceRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new EvidenceNotFoundException("Evidence", "id", id);
        }
    }
}
