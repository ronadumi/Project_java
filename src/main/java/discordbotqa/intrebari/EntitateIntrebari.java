package discordbotqa.intrebari;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class EntitateIntrebari {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean raspuns;
    private String intrebare;

    @Override
    public String toString() {
        return "Intrebare{" +
                "id=" + id +
                ", raspuns='" + raspuns + '\'' +
                ", intrebare='" + intrebare + '\'' +
                '}';
    }

    public Boolean iaRaspuns() {
        return this.raspuns;
    }
}
