package desarrolloweb.progwebp1back.models.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import desarrolloweb.progwebp1back.models.db.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
