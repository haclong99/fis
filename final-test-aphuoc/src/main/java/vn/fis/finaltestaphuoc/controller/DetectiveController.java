package vn.fis.finaltestaphuoc.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.finaltestaphuoc.dto.DetectiveDto;
import vn.fis.finaltestaphuoc.entity.Detective;
import vn.fis.finaltestaphuoc.service.DetectiveService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DetectiveController {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DetectiveService detectiveService;

    @GetMapping("detective/{id}")
    public ResponseEntity<DetectiveDto> findById(@PathVariable(name = "id") Long id) {
        Detective detective = detectiveService.findById(id);

        DetectiveDto detectiveResponse = modelMapper.map(detective, DetectiveDto.class);

        return ResponseEntity.ok().body(detectiveResponse);
    }

    @PostMapping("/detective")
    public ResponseEntity<DetectiveDto> create(@RequestBody DetectiveDto detectiveDto) {

        Detective detectiveRequest = modelMapper.map(detectiveDto, Detective.class);
        Detective detective = detectiveService.createDetective(detectiveRequest);

        DetectiveDto detectiveResponse = modelMapper.map(detective, DetectiveDto.class);

        return new ResponseEntity<DetectiveDto>(detectiveResponse, HttpStatus.CREATED);
    }

    @PutMapping("detective/{id}")
    public ResponseEntity<DetectiveDto> update(@PathVariable long id, @RequestBody DetectiveDto detectiveDto) {

        Detective detectiveRequest = modelMapper.map(detectiveDto, Detective.class);
        Detective detective = detectiveService.updateDetective(id, detectiveRequest);

        DetectiveDto detectiveResponse = modelMapper.map(detective, DetectiveDto.class);

        return ResponseEntity.ok().body(detectiveResponse);
    }

    @GetMapping("detective/{username}")
    public ResponseEntity<DetectiveDto> findByUsername(@PathVariable(name = "username") String username) {
        List<Detective> detective = detectiveService.findByUsername(username);

        DetectiveDto detectiveResponse = modelMapper.map(detective, DetectiveDto.class);

        return ResponseEntity.ok().body(detectiveResponse);
    }
}
