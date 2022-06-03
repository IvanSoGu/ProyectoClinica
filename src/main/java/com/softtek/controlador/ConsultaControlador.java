package com.softtek.controlador;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.dto.ConsultaDTO;
import com.softtek.servicio.IConsultaServicio;

@RestController
@RequestMapping("/consultas")
//@CrossOrigin(origins="http://localhost:4200")
public class ConsultaControlador {
    @Autowired
    private IConsultaServicio servicio;

    @Autowired
    private ModelMapper mapper;

//    @PreAuthorize("@authServiceImpl.tieneAcceso('listar')")

    @GetMapping("/listarResumen")
    public ResponseEntity<List<ConsultaDTO>> listar() throws Exception {
    List<ConsultaDTO> lista = servicio.consultasDia();

    return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    @GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE) // APPLICATION_PDF_VALUE
    public ResponseEntity<byte[]> generarReporte() {
        byte[] data = null;
        data = servicio.generarReporte();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}