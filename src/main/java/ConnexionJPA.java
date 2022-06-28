import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class ConnexionJPA {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-connect");
        EntityManager em = entityManagerFactory.createEntityManager();

        // First Client
        Client client1 = new Client();
        client1.setNom("Charles");
        client1.setPrenom("Appolon");
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1995, 06, 15);
        client1.setDateNaissance(dateOfBirth.getTime());
        // Second Client
        Client client2 = new Client();
        client2.setNom("Manufa");
        client2.setPrenom("Akture");
        dateOfBirth.set(2001, 06, 15);
        client2.setDateNaissance(dateOfBirth.getTime());


//        First Banque
        Banque banque1 = new Banque();
        banque1.setNom("OrangeBank");
//      Association client1 + banque1
        client1.setBanque(banque1);

//      Second Banque
        Banque banque2 = new Banque();
        banque2.setNom("Crédit Mutuel");
//       Association client2 + banque2
        client2.setBanque(banque2);


        // Creation Adresse1
        Adresse adresse1 = new Adresse();
        adresse1.setNumero(25);
        adresse1.setRue("rue de la vigne");
        adresse1.setCodePostal(44150);
        adresse1.setVille("Nantes");
        //       Association client1 + adresse1
        client2.setAdresse(adresse1);

        // Creation Adresse2
        Adresse adresse2 = new Adresse();
        adresse2.setNumero(25);
        adresse2.setRue("rue de la vigne");
        adresse2.setCodePostal(44150);
        adresse2.setVille("Nantes");
        client1.setAdresse(adresse1);
        //       Association client2 + adresse2
        client2.setAdresse(adresse2);

        // Creation Compte
        Compte compte1 = new Compte();
        compte1.setNumero("36425992455");
        compte1.setSolde(1206.61);


        Compte compte2 = new Compte();
        compte2.setNumero("36425992455");
        compte2.setSolde(1206.61);

        // Création ComptesClients1
        Set<Compte> comptesClients1 = new HashSet<>();
        comptesClients1.add(compte1);

        // Création CompteClient2
        Set<Compte> comptesClients2 = new HashSet<>();
        comptesClients2.add(compte2);

//      Création assuranceVie1
        AssuranceVie assuranceVie1 = new AssuranceVie();
        assuranceVie1.setSolde(321.25);
        assuranceVie1.setNumero("123698562");
        assuranceVie1.setTaux(5d);
        assuranceVie1.setDateFin(LocalDate.now().plusDays(5));
        comptesClients1.add(assuranceVie1);

        // Creation LivretA1
        LivretA livretA1 = new LivretA();
        livretA1.setNumero("25365");
        livretA1.setTaux(2);
        livretA1.setSolde(1206.61);
        comptesClients1.add(livretA1);

//        Association des comptes au client correspondants
        client1.setComptes(comptesClients1);
        client2.setComptes(comptesClients2);


//        Création operation1
        Operation operation1 = new Operation();
        operation1.setDate(LocalDate.now());
        operation1.setMotif("rente");
        operation1.setMontant(12000);
        operation1.setCompte(compte1);

        //        Création operation2
        Operation operation2 = new Operation();
        operation2.setDate(LocalDate.now());
        operation2.setMotif("Distribution de moula");
        operation2.setMontant(500);
        operation2.setCompte(compte2);

        //        Création virement1

        Virement virement1 = new Virement();
        virement1.setBeneficiaire("Moufassa");
        virement1.setDate(LocalDate.now());
        virement1.setMontant(730);
        virement1.setMotif("Loyer");
        virement1.setCompte(compte1);

        //        Création virement2

        Virement virement2 = new Virement();
        virement2.setBeneficiaire("Iris");
        virement2.setDate(LocalDate.now());
        virement2.setMontant(455);
        virement2.setMotif("Voyage");
        virement2.setCompte(compte2);

        //        Persist de la banque
        em.getTransaction().begin();
        em.persist(banque1);
        em.persist(banque2);
        em.persist(compte1);
        em.persist(compte2);
        em.persist(assuranceVie1);
        em.persist(livretA1);
        em.persist(operation1);
        em.persist(operation2);
        em.persist(virement1);
        em.persist(virement2);
        em.persist(client1);
        em.persist(client2);
        em.getTransaction().commit();



    }
}