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

    @GetMapping(value = "/clientesmaisvelhos/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getNClientesMaisVelhos(@PathVariable("number") int num) {
        try {
            return new ResponseEntity<>(EstatisticaService.getNClientesMaisVelhos(num), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/clientesmaisnovos/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getNClientesMaisNovos(@PathVariable("number") int num) {
        try {
            return new ResponseEntity<>(EstatisticaService.getNClientesMaisNovos(num), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/funcionariosmaisvelhos/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getNFuncionariosMaisVelhos(@PathVariable("number") int num) {
        try {
            return new ResponseEntity<>(EstatisticaService.getNFuncionariosMaisVelhos(num), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/funcionariosmaisnovos/{number}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getNFuncionariosMaisNovos(@PathVariable("number") int num) {
        try {
            return new ResponseEntity<>(EstatisticaService.getNFuncionariosMaisNovos(num), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/clientemaisservicos/", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getClienteMaisServicos() {
        try {
            return new ResponseEntity<>(EstatisticaService.getClienteMaisServicos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/anomaiscriticas/", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAnoMaisCriticas() {
        try {
            return new ResponseEntity<>(EstatisticaService.getAnoMaisCriticas(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/mediaavaliacoes/", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getMediaAvaliacoes() {
        try {
            return new ResponseEntity<>(EstatisticaService.getMediaAvaliacoes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.CONFLICT);
        }
    }
}
