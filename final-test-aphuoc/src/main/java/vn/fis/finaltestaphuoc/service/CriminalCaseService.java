package vn.fis.finaltestaphuoc.service;

import vn.fis.finaltestaphuoc.entity.CriminalCase;

import java.util.List;

public interface CriminalCaseService {
    CriminalCase createCase(CriminalCase criminalCase);
    CriminalCase updateCase(Long id, CriminalCase criminalCase);
    CriminalCase findById(Long id);
    List<CriminalCase> findByUsername(String username);
}
