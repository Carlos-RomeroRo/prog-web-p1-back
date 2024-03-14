package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Sugerencia;
import desarrolloweb.jpa.models.db.repositories.SugerenciaRepository;
import desarrolloweb.jpa.models.mappers.mapper.SugerenciaMapper;
import desarrolloweb.jpa.models.mappers.dto.SugerenciaDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SugerenciaService {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    public List<SugerenciaDTO> getAll() {
        List<Sugerencia> sugerencias = sugerenciaRepository.findAll();
        return sugerencias.stream()
                .map(SugerenciaMapper::sugerenciaToDto)
                .collect(Collectors.toList());
    }

    public SugerenciaDTO get(Long id) {
        Sugerencia sugerencia = sugerenciaRepository.findById(id).orElse(null);
        if (sugerencia == null) {
            // Manejo de error o lanzar excepción
            return null;
        }
        return SugerenciaMapper.sugerenciaToDto(sugerencia);
    }

    public SugerenciaDTO create(SugerenciaDTO sugerenciaDTO) {
        Sugerencia sugerencia = SugerenciaMapper.dtoToSugerencia(sugerenciaDTO);
        sugerencia = sugerenciaRepository.save(sugerencia);
        return SugerenciaMapper.sugerenciaToDto(sugerencia);
    }

    public Boolean edit(SugerenciaDTO sugerenciaDTO) {
        try {
            Sugerencia sugerencia = SugerenciaMapper.dtoToSugerencia(sugerenciaDTO);
            sugerenciaRepository.save(sugerencia);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void delete(Long id) {
        sugerenciaRepository.deleteById(id);
    }
}
