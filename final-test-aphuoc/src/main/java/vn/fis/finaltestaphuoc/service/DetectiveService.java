package vn.fis.finaltestaphuoc.service;

import vn.fis.finaltestaphuoc.entity.Detective;

import java.util.List;

public interface DetectiveService {
    Detective createDetective(Detective detective);
    Detective updateDetective(Long id, Detective detective);
    Detective findById(Long id);
    List<Detective> findByUsername(String username);
}
