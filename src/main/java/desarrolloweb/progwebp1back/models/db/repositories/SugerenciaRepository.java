package desarrolloweb.progwebp1back.models.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import desarrolloweb.progwebp1back.models.db.entities.Sugerencia;

@RepositoryRestResource
public interface SugerenciaRepository extends JpaRepository<Sugerencia, Long> {
}
