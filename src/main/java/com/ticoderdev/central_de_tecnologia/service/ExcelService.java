package com.ticoderdev.central_de_tecnologia.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import com.ticoderdev.central_de_tecnologia.model.ModeloTelefone;

@Service
public class ExcelService {

    public List<ModeloTelefone> buscaModeloTelefone(String modeloBusca) {
        List<ModeloTelefone> resultados = new ArrayList<>();

        try (FileInputStream file = new FileInputStream("telefone.xlsx");
                Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0)
                    continue; // pular cabeçalho

                String modelo = row.getCell(0).getStringCellValue();
                if (modelo.equalsIgnoreCase(modeloBusca)) {
                    ModeloTelefone modeloTelefone = new ModeloTelefone();
                    modeloTelefone.setModelo(modeloBusca);
                    modeloTelefone.setMarca(row.getCell(1).getStringCellValue());
                    modeloTelefone.setTela(row.getCell(2).getStringCellValue());
                    modeloTelefone.setMemoria(row.getCell(3).getStringCellValue());
                    modeloTelefone.setCamera(row.getCell(4).getStringCellValue());
                    modeloTelefone.setBateria(row.getCell(5).getStringCellValue());
                    modeloTelefone.setPrecoTela(row.getCell(6).getStringCellValue());
                    modeloTelefone.setPrecoBateria(row.getCell(7).getStringCellValue());
                    modeloTelefone.setPrecoPlaca(row.getCell(8).getStringCellValue());

                    resultados.add(modeloTelefone);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultados;
    }

}
