package com.ticoderdev.central_de_tecnologia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticoderdev.central_de_tecnologia.model.ModeloTelefone;
import com.ticoderdev.central_de_tecnologia.service.ExcelService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class ConsultaCotroller {
    
    @Autowired
    private ExcelService excelService;

    @GetMapping("/buscar")
    public List<ModeloTelefone> buscarModelo(@RequestParam String modelo){
        return excelService.buscaModeloTelefone(modelo);
    } 

}
