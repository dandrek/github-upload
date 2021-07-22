import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.Player;

public class Main {

    public static void main (String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TrackSim tracksim = new TrackSim();
        Practice practice = new Practice();
        Players cpu = new Players();

        Player player1 = (Player) entityManager.find(Player.class, 19);
        Player player2 = (Player) entityManager.find(Player.class, 10);
        Player player3 = (Player) entityManager.find(Player.class, 7);
        Player player4 = (Player) entityManager.find(Player.class, 8);
        Player player5 = (Player) entityManager.find(Player.class, 18);
        Player player6 = (Player) entityManager.find(Player.class, 2);
        Player player7 = (Player) entityManager.find(Player.class, 4);
        Player player8 = (Player) entityManager.find(Player.class, 11);
        Player[] racers = new Player[8];

        racers[0] = player1;
        racers[1] = player2;
        racers[2] = player3;
        racers[3] = player4;
        racers[4] = player5;
        racers[5] = player6;
        racers[6] = player7;
        racers[7] = player8;

        System.out.println(player3.getName());
        System.out.println(tracksim.oneHundredMeters(player3));
        tracksim.oneHundredMetersRace(racers);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
