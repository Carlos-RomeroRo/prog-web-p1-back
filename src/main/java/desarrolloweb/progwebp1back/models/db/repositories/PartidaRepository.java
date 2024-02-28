package desarrolloweb.progwebp1back.models.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import desarrolloweb.progwebp1back.models.db.entities.Partida;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
