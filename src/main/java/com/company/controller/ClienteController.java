package com.company.controller;

import com.company.dto.ClienteDto;
import com.company.dto.ErrorDto;
import com.company.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getClientes() {
        try {
            return new ResponseEntity<>(ClienteService.getClientes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/clientes/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCliente(@PathVariable("number") int id) {
        try {
            return new ResponseEntity<>(ClienteService.getClienteInfo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/clientes", consumes = MediaType.APPLICATION_XML_VALUE ,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addCliente(@RequestBody ClienteDto arg){
        try{
            ClienteService.addCliente(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(new ErrorDto(e.getMessage()),HttpStatus.CONFLICT);
        }
    }
    @PutMapping(value = "/clientes/{number}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateCliente(@PathVariable("number") int number, @RequestBody ClienteDto arg) {
        try {
            ClienteService.updateCliente(number, arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/clientes/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeCliente(@PathVariable("number") int number) {
        try {
            ClienteService.removeCliente(number);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

}
