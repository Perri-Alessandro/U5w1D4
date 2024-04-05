package perriAlessandro.U5w1D4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public abstract class Item {

    @Id
    @GeneratedValue
    public long id;
    public double prezzo;
    public long calorie;

    public Item(double prezzo, long calorie) {
        this.prezzo = prezzo;
        this.calorie = calorie;
    }

}
