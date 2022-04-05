package vn.fis.finaltestaphuoc.service;

import vn.fis.finaltestaphuoc.entity.Evidence;

public interface EvidenceService {
    Evidence createEvidence(Evidence evidence);
    Evidence updateEvidence(Long id, Evidence evidence);
    Evidence findById(Long id);
}
