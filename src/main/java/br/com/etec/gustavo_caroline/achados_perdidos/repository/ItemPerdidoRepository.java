package br.com.etec.achadosperdidos.repository;
import br.com.etec.achadosperdidos.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ItemPerdidoRepository extends JpaRepository<ItemPerdido,Long> {
 List<ItemPerdido> findByStatus(StatusItem status);
}
