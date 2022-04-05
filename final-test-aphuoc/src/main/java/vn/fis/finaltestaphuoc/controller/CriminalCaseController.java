package vn.fis.finaltestaphuoc.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.finaltestaphuoc.dto.CriminalCaseDto;
import vn.fis.finaltestaphuoc.entity.CriminalCase;
import vn.fis.finaltestaphuoc.service.CriminalCaseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CriminalCaseController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    CriminalCaseService criminalCaseService;

    @GetMapping("/case/{id}")
    public ResponseEntity<CriminalCaseDto> findById(@PathVariable(name = "id") Long id) {
        CriminalCase criminalCase = criminalCaseService.findById(id);

        CriminalCaseDto criminalCaseResponse = modelMapper.map(criminalCase, CriminalCaseDto.class);

        return ResponseEntity.ok().body(criminalCaseResponse);
    }

    @PostMapping("/case")
    public ResponseEntity<CriminalCaseDto> create(@RequestBody CriminalCaseDto criminalCaseDto) {

        CriminalCase criminalCaseRequest = modelMapper.map(criminalCaseDto, CriminalCase.class);
        CriminalCase criminalCase = criminalCaseService.createCase(criminalCaseRequest);

        CriminalCaseDto criminalCaseResponse = modelMapper.map(criminalCase, CriminalCaseDto.class);

        return new ResponseEntity<CriminalCaseDto>(criminalCaseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/case/{id}")
    public ResponseEntity<CriminalCaseDto> update(@PathVariable long id, @RequestBody CriminalCaseDto criminalCaseDto) {

        CriminalCase criminalCaseRequest = modelMapper.map(criminalCaseDto, CriminalCase.class);
        CriminalCase criminalCase = criminalCaseService.updateCase(id, criminalCaseRequest);

        CriminalCaseDto criminalCaseResponse = modelMapper.map(criminalCase, CriminalCaseDto.class);

        return ResponseEntity.ok().body(criminalCaseResponse);
    }

    @GetMapping("/case/{username}")
    public ResponseEntity<CriminalCaseDto> findByUsername(@PathVariable(name = "username") String username) {
        List<CriminalCase> criminalCase = criminalCaseService.findByUsername(username);

        CriminalCaseDto criminalCaseResponse = modelMapper.map(criminalCase, CriminalCaseDto.class);

        return ResponseEntity.ok().body(criminalCaseResponse);
    }
}
