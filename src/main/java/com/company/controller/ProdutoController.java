package com.company.controller;

import com.company.dto.ErrorDto;
import com.company.dto.FuncionarioDTO;
import com.company.dto.ProdutoDTO;
import com.company.dto.ProdutoListDTO;
import com.company.service.FuncionarioService;
import com.company.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProdutoController {
    @GetMapping(value = "/produtos", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getProdutos() {
        try {
            return new ResponseEntity<>(ProdutoService.getProdutos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/produto/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getProdutoInfo(@PathVariable("number") int id) {
        try {
            return new ResponseEntity<>(ProdutoService.getProdutoInfo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/produto/create", consumes = MediaType.APPLICATION_XML_VALUE ,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addProduto(@RequestBody ProdutoDTO arg){
        try{
            ProdutoService.addProduto(arg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(new ErrorDto(e.getMessage()),HttpStatus.CONFLICT);
        }
    }
    @PutMapping(value = "/produto/{number}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateProduto(@PathVariable("number") int number, @RequestBody ProdutoDTO arg) {
        try {
            ProdutoService.updateProduto(number,arg);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/produto/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeProduto(@PathVariable("number") int number) {
        try {
            ProdutoService.removeProduto(number);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

}