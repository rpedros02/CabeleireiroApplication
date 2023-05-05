package com.company.controller;

import com.company.dto.ClienteDTO;
import com.company.dto.ErrorDto;
import com.company.service.ClienteService;
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
            return new ResponseEntity<>(ClienteService.getClientes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/funcionarios/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getFuncionario(@PathVariable("number") int id) {
        try {
            return new ResponseEntity<>(ClienteService.getClienteInfo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/funcionarios/create", consumes = MediaType.APPLICATION_XML_VALUE ,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addCliente(@RequestBody ClienteDTO arg){
        try{
            ClienteService.addCliente(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(new ErrorDto(e.getMessage()),HttpStatus.CONFLICT);
        }
    }
    @PutMapping(value = "/funcionarios/{number}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateCliente(@PathVariable("number") int number, @RequestBody ClienteDTO arg) {
        try {
            ClienteService.updateCliente(number, arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/funcionarios/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeCliente(@PathVariable("number") int number) {
        try {
            ClienteService.removeCliente(number);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

}