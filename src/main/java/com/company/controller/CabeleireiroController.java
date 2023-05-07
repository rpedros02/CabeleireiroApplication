package com.company.controller;

import com.company.dto.CabeleireiroDTO;
import com.company.dto.ErrorDto;
import com.company.service.CabeleireiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CabeleireiroController {
    @RequestMapping(value = "/cabeleireiro", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCabeleireiroInfo() {
        try {
            return new ResponseEntity<>(CabeleireiroService.getCabeleireiroInfo(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/cabeleireiro", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateCabeleireiro(@RequestBody CabeleireiroDTO arg) {
        try {
            CabeleireiroService.updateCabeleireiro(arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}
