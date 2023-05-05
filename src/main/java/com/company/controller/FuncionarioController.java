package com.company.controller;

import com.company.dto.ErrorDto;
import com.company.dto.FuncionarioDTO;
import com.company.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FuncionarioController {
    @GetMapping(value = "/funcionarios", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getFuncionarios() {
        try {
            return new ResponseEntity<>(FuncionarioService.getFuncionarios(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/funcionarios/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getFuncionarioInfo(@PathVariable("number") int id) {
        try {
            return new ResponseEntity<>(FuncionarioService.getFuncionarioInfo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/funcionarios/create", consumes = MediaType.APPLICATION_XML_VALUE ,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addFuncionario(@RequestBody FuncionarioDTO arg){
        try{
            FuncionarioService.addFuncionario(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(new ErrorDto(e.getMessage()),HttpStatus.CONFLICT);
        }
    }
    @PutMapping(value = "/funcionarios/{number}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateFuncionarios(@PathVariable("number") int number, @RequestBody FuncionarioDTO arg) {
        try {
            FuncionarioService.updateFuncionario(number,arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/funcionarios/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeFuncionario(@PathVariable("number") int number) {
        try {
            FuncionarioService.removeFuncionario(number);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

}