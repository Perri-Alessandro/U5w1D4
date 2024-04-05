package perriAlessandro.U5w1D4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "pizza")
public class Pizza extends Item {

    @ManyToMany
    @JoinTable(
            name = "pizza_topping",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    public List<Topping> toppingList;
    public boolean isXl = false;
    private String nome;

    public Pizza() {
    }


    public Pizza(double prezzo, long calorie) {
        super(prezzo, calorie);
    }


    public Pizza(String nome, double prezzo, List<Topping> toppingList, long calorie, boolean isXl) {
        super(prezzo, calorie);
        this.nome = nome;
        this.toppingList = toppingList;
        this.isXl = isXl;
    }
}
