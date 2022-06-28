import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte {

    @Column(name = "dateFin")
    private LocalDate dateFin;
    @Column(name = "taux")
    private double taux;

    public AssuranceVie() {
    }


    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AssuranceVie{");
        sb.append("dateFin=").append(dateFin);
        sb.append(", taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
