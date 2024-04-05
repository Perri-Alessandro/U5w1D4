package perriAlessandro.U5w1D4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import perriAlessandro.U5w1D4.entities.Pizza;

import java.util.List;

@Repository
public interface PizzaDAO extends JpaRepository<Pizza, Long> {

    boolean existsByNome(String nome);

    List<Pizza> findByNome(String nome);

    @Query("SELECT p FROM Pizza p WHERE p.prezzo >= 8")
    List<Pizza> filterByBigPrice();
}
