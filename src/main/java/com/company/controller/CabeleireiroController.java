package com.company.controller;

import com.company.dto.CabeleireiroDto;
import com.company.dto.ErrorDto;
import com.company.service.CabeleireiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CabeleireiroController {
    @RequestMapping(value = "/cabeleireiro",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCabeleireiroInfo() {
        try {
            CabeleireiroDto result = CabeleireiroService.getCabeleireiroInfo();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}
