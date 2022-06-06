package com.softtek.controlador;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softtek.dto.ConsultaDTO;
import com.softtek.dto.ConsultaListaAnaliticaDTO;
import com.softtek.dto.ConsultaResumenDTO;
import com.softtek.exception.ModeloNotFoundException;
import com.softtek.modelo.Analitica;
import com.softtek.modelo.Consulta;
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
    public ResponseEntity<List<ConsultaResumenDTO>> listarResumen() throws Exception {
    List<ConsultaResumenDTO> lista = servicio.consultasDia();

    return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    @GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE) // APPLICATION_PDF_VALUE
    public ResponseEntity<byte[]> generarReporte() {
        byte[] data = null;
        data = servicio.generarReporte();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> listar() throws Exception{
        List<ConsultaDTO> lista = servicio.listar().stream().map(p -> mapper.map(p, ConsultaDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
//   
    @GetMapping("/{id}")
    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ConsultaDTO> listarPorId(@PathVariable("id") Integer id) throws Exception{
        ConsultaDTO dtoResponse;
        Consulta obj = servicio.listarPorId(id);
        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }else {
            dtoResponse = mapper.map(obj, ConsultaDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody ConsultaListaAnaliticaDTO dtoRequest) throws Exception {

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Consulta c = mapper.map(dtoRequest, Consulta.class);
        //Consulta c = mapper.map(dtoRequest.getConsulta(), Consulta.class);
        List<Analitica> examenes = mapper.map(dtoRequest.getLstAnalitica(), new TypeToken<List<Analitica>>() {}.getType());

        Consulta obj = servicio.registrarTransaccional(c, examenes);
        ConsultaDTO dtoResponse = mapper.map(obj, ConsultaDTO.class);
        //localhost:8080/Consultas/9
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getIdConsulta()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<ConsultaDTO> modificar(@Valid @RequestBody ConsultaDTO dtoRequest) throws Exception {
        Consulta pac = servicio.listarPorId(dtoRequest.getIdConsulta());

        if(pac == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dtoRequest.getIdConsulta());   
        }       

        Consulta p = mapper.map(dtoRequest, Consulta.class);        
        Consulta obj = servicio.modificar(p);       
        ConsultaDTO dtoResponse = mapper.map(obj, ConsultaDTO.class);

        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);       
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Consulta pac = servicio.listarPorId(id);

        if(pac == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}