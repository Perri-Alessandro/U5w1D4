package perriAlessandro.U5w1D4.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perriAlessandro.U5w1D4.entities.Pizza;

@Service
@Slf4j
public class PizzaService {

    @Autowired
    public PizzaDAO pizzaDAO;

    public void savePizza(Pizza neww) {

        if (pizzaDAO.existsByNome(neww.getNome())) {
            throw new RuntimeException("Nome " + neww.getNome() + " ESISTE GIà. SCEGLIERNE UN'ALTRO.");
        }
        pizzaDAO.save(neww);
        log.info("Pizza salvata correttamente");
    }
}
