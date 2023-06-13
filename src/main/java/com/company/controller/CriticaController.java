package com.company.controller;

import com.company.dto.CriticaDto;
import com.company.dto.ErrorDto;
import com.company.service.CriticaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CriticaController {

    @GetMapping(value = "/criticas", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCriticas() {
        try {
            return new ResponseEntity<>(CriticaService.getCriticas(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/criticas/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCritica(@PathVariable("number") int id) {
        try {
            return new ResponseEntity<>(CriticaService.getCriticaInfo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/critica/create", consumes = MediaType.APPLICATION_XML_VALUE ,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addCritica(@RequestBody CriticaDto arg){
        try{
            CriticaService.addCritica(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(new ErrorDto(e.getMessage()),HttpStatus.CONFLICT);
        }
    }

}
