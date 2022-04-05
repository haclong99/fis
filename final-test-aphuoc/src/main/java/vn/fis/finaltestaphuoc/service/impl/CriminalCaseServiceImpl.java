package vn.fis.finaltestaphuoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.finaltestaphuoc.entity.CriminalCase;
import vn.fis.finaltestaphuoc.exception.CriminalCaseNotFoundException;
import vn.fis.finaltestaphuoc.repository.CriminalCaseRepository;
import vn.fis.finaltestaphuoc.repository.DetectiveRepository;
import vn.fis.finaltestaphuoc.repository.EvidenceRepository;
import vn.fis.finaltestaphuoc.service.CriminalCaseService;

import java.util.List;
import java.util.Optional;

@Service
public class CriminalCaseServiceImpl implements CriminalCaseService {
    @Autowired
    CriminalCaseRepository criminalCaseRepository;

    @Autowired
    DetectiveRepository detectiveRepository;

    @Autowired
    EvidenceRepository evidenceRepository;

    @Override
    public CriminalCase createCase(CriminalCase criminalCase) {
        return criminalCaseRepository.save(criminalCase);
    }

    @Override
    public CriminalCase updateCase(Long id, CriminalCase criminalCaseRequest) {
        CriminalCase criminalCase = criminalCaseRepository.findById(id)
                .orElseThrow(() -> new CriminalCaseNotFoundException("CriminalCase", "id", id));

        criminalCase.setNumber(criminalCase.getNumber());
        return criminalCaseRepository.save(criminalCase);
    }

    @Override
    public CriminalCase findById(Long id) {
        Optional<CriminalCase> result = criminalCaseRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new CriminalCaseNotFoundException("CriminalCase", "id", id);
        }
    }

    @Override
    public List<CriminalCase> findByUsername(String username) {
        return criminalCaseRepository.findByUsername(username);
    }
}
