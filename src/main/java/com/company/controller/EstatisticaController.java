package com.company.controller;

import com.company.dto.ErrorDto;
import com.company.dto.ServicoDTO;
import com.company.service.EstatisticaService;
import com.company.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EstatisticaController {
    @GetMapping(value = "/servicosporfuncionario/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getServicosPorFuncionario(@PathVariable("number") int id) {
        try {
            return new ResponseEntity<>(EstatisticaService.getServicosPorFuncionario(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/funcionariomaisservicos/", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getFuncionarioMaisServicos() {
        try {
            return new ResponseEntity<>(EstatisticaService.getFuncionarioMaisServicos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}
