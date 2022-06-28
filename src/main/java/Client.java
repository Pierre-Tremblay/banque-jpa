import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "dateNaissance")
    private Date dateNaissance;

    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banque banque;


    @ManyToMany
    @JoinTable(name = "compte_client",
            joinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "ID")
    )
    private Set<Compte> comptes;


    @Embedded
    private Adresse adresse;

    public Client() {
    }

    public Client(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", banque=").append(banque);
        sb.append(", comptes=").append(comptes);
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }
}
