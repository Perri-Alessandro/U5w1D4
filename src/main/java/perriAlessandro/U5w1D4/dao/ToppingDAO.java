package perriAlessandro.U5w1D4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import perriAlessandro.U5w1D4.entities.Topping;

import java.util.List;

public interface ToppingDAO extends JpaRepository<Topping, Long> {

    List<Topping> findByNome(String nome);
}
