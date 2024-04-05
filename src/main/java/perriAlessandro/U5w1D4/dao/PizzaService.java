package perriAlessandro.U5w1D4.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perriAlessandro.U5w1D4.entities.Pizza;
import perriAlessandro.U5w1D4.entities.Topping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PizzaService {

    @Autowired
    public PizzaDAO pizzaDAO;

    @Autowired
    private ToppingDAO toppingDAO;

    public void savePizza(Pizza neww) {
        List<Topping> salvataggioT = neww.getToppingList().stream().map(topping -> {
            List<Topping> existingToppings = toppingDAO.findByNome(topping.getNome());
            if (existingToppings.isEmpty()) {
                return toppingDAO.save(topping);
            } else {
                return existingToppings.get(0);
            }
        }).collect(Collectors.toList());


        neww.setToppingList(salvataggioT);

        if (pizzaDAO.existsByNome(neww.getNome())) {
            throw new RuntimeException("Nome " + neww.getNome() + " ESISTE GIà. SCEGLIERNE UN'ALTRO.");
        }
        pizzaDAO.save(neww);
        log.info("Pizza salvata correttamente");
    }
}
