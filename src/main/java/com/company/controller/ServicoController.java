package com.company.controller;

import com.company.dto.ErrorDto;
import com.company.dto.ServicoDTO;
import com.company.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ServicoController {
    @GetMapping(value = "/servicos", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getServicos() {
        try {
            return new ResponseEntity<>(ServicoService.getServicos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/servicos/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getServicoInfo(@PathVariable("number") int id) {
        try {
            return new ResponseEntity<>(ServicoService.getServicoInfo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/servicos/create", consumes = MediaType.APPLICATION_XML_VALUE ,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addServico(@RequestBody ServicoDTO arg){
        try{
            ServicoService.addServico(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(new ErrorDto(e.getMessage()),HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/servicos/{number}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateServico(@PathVariable("number") int number, @RequestBody ServicoDTO arg) {
        try {
            ServicoService.updateServico(number, arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/servicos/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeServico(@PathVariable("number") int number) {
        try {
            ServicoService.removeServico(number);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

}
