package vn.fis.finaltestaphuoc.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.finaltestaphuoc.dto.EvidenceDto;
import vn.fis.finaltestaphuoc.entity.Evidence;
import vn.fis.finaltestaphuoc.service.EvidenceService;

@RestController
@RequestMapping("/api/v1")
public class EvidenceController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EvidenceService evidenceService;

    @GetMapping("/evidence/{id}")
    public ResponseEntity<EvidenceDto> findById(@PathVariable(name = "id") Long id) {
        Evidence evidence = evidenceService.findById(id);

        EvidenceDto evidenceResponse = modelMapper.map(evidence, EvidenceDto.class);

        return ResponseEntity.ok().body(evidenceResponse);
    }

    @PostMapping("/evidence")
    public ResponseEntity<EvidenceDto> create(@RequestBody EvidenceDto evidenceDto) {

        Evidence evidenceRequest = modelMapper.map(evidenceDto, Evidence.class);
        Evidence evidence = evidenceService.createEvidence(evidenceRequest);

        EvidenceDto evidenceResponse = modelMapper.map(evidence, EvidenceDto.class);

        return new ResponseEntity<EvidenceDto>(evidenceResponse, HttpStatus.CREATED);
    }

    @PutMapping("/evidence/{id}")
    public ResponseEntity<EvidenceDto> update(@PathVariable long id, @RequestBody EvidenceDto evidenceDto) {

        Evidence evidenceRequest = modelMapper.map(evidenceDto, Evidence.class);
        Evidence evidence = evidenceService.updateEvidence(id, evidenceRequest);

        EvidenceDto evidenceResponse = modelMapper.map(evidence, EvidenceDto.class);

        return ResponseEntity.ok().body(evidenceResponse);
    }
}
