package perriAlessandro.U5w1D4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perriAlessandro.U5w1D4.entities.Pizza;

@Repository
public interface PizzaDAO extends JpaRepository<Pizza, Long> {

    boolean existsByNome(String nome);
}
