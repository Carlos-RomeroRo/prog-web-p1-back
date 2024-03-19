package desarrolloweb.jpa.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrolloweb.jpa.models.db.entities.Sugerencia;
import desarrolloweb.jpa.models.db.repositories.SugerenciaRepository;
import desarrolloweb.jpa.models.mappers.mapper.SugerenciaMapper;
import lombok.extern.slf4j.Slf4j;
import desarrolloweb.jpa.models.mappers.dto.SugerenciaDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SugerenciaService {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    /**
     * Get all the suggestions from the database
     * 
     * @return List<SugerenciaDTO> the list of suggestions
     */
    public List<SugerenciaDTO> getAll() {
        List<Sugerencia> sugerencias = sugerenciaRepository.findAll();
        return sugerencias.stream()
                .map(SugerenciaMapper::sugerenciaToDto)
                .collect(Collectors.toList());
    }

    /**
     * Get a suggestion from the database
     * 
     * @param id the id of the suggestion
     * @return SugerenciaDTO the suggestion
     */
    public SugerenciaDTO get(Long id) {
        Sugerencia sugerencia;
        try {
            sugerencia = sugerenciaRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("Error on get", e.getMessage());
            return null;
        }
        return SugerenciaMapper.sugerenciaToDto(sugerencia);
    }

    /**
     * Create a new suggestion
     * 
     * @param sugerenciaDTO the suggestion
     * @return SugerenciaDTO the created suggestion
     */
    public SugerenciaDTO create(SugerenciaDTO sugerenciaDTO) {
        Sugerencia sugerencia;
        try {
            sugerenciaDTO.setCreatedAt(Timestamp.from(java.time.Instant.now()));
            sugerencia = SugerenciaMapper.dtoToSugerencia(sugerenciaDTO);
            sugerencia = sugerenciaRepository.save(sugerencia);
        } catch (Exception e) {
            log.error("Error on create", e.getMessage());
            return null;
        }
        return SugerenciaMapper.sugerenciaToDto(sugerencia);
    }

    /**
     * Edit a suggestion
     * 
     * @param sugerenciaDTO the suggestion
     * @param original the original suggestion
     * @return Boolean true if the suggestion was edited
     */
    public Boolean edit(SugerenciaDTO sugerenciaDTO, SugerenciaDTO original) {
        if (original == null) {
            return false;
        }
        try {
            sugerenciaDTO.setCreatedAt(original.getCreatedAt());
            sugerenciaDTO.setId(original.getId());
            Sugerencia sugerencia = SugerenciaMapper.dtoToSugerencia(sugerenciaDTO);
            sugerenciaRepository.save(sugerencia);
        } catch (Exception e) {
            log.error("Error on edit", e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Delete a suggestion
     * 
     * @param id the id of the suggestion
     * @return Boolean true if the suggestion was deleted
     */
    public Boolean delete(Long id) {
        try {
            sugerenciaRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error on delete", e.getMessage());
            return false;
        }
        return true;
    }
}
