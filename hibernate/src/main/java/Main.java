import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.Player;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main (String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TrackSim tracksim = new TrackSim();
        Practice practice = new Practice();
        Players cpu = new Players();

        boolean runProgram = true;
        boolean mainGame = true;
        Scanner scnr = new Scanner(System.in);
        int choice = 20;

        Player user = (Player) entityManager.find(Player.class, 3);
        /*Player player1 = (Player) entityManager.find(Player.class, 19);
        Player player2 = (Player) entityManager.find(Player.class, 10);
        Player player3 = (Player) entityManager.find(Player.class, 7);
        Player player4 = (Player) entityManager.find(Player.class, 8);
        Player player5 = (Player) entityManager.find(Player.class, 18);
        Player player6 = (Player) entityManager.find(Player.class, 2);
        Player player7 = (Player) entityManager.find(Player.class, 4);
        Player player8 = (Player) entityManager.find(Player.class, 11);
        Player[] test = new Player[8];*/

        while (mainGame) {

            System.out.println();
            System.out.println("Would you like to compete? If so press 1");
            System.out.println("Would you like to practice? If so press 2");
            System.out.println("Would you like to rest? If so press 3");
            System.out.println("Would you like to see other players info? If so press 4");
            System.out.println("Would you like to see your info? If so press 5");
            System.out.println("Would you like to compare your player to another? If so press 6");

            choice = scnr.nextInt();

            if (choice == 1) {

                Player[] cpuRacers = new Player[7];
                Player[] racers = new Player[8];
                racers[0] = user;

                ArrayList<Integer> genNums = new ArrayList<Integer>(8);

                for (int i = 1; i <= 19; i++) {
                    genNums.add(i);
                }

                System.out.println(genNums.get(4));
                genNums.remove(2);

                Collections.shuffle(genNums);
                System.out.println(genNums);

                for (int i = 0; i < 7; i++) {
                    racers[i+1] = entityManager.find(Player.class, genNums.get(i));
                    cpuRacers[i] = entityManager.find(Player.class, genNums.get(i));
                }

                System.out.println("What would you race would you like to run?");
                System.out.println("1:100m");
                System.out.println("2:200m");
                System.out.println("3:400m");
                choice = scnr.nextInt();

                if (choice == 1) {

                    tracksim.oneHundredMetersRace(racers);

                    System.out.println("You placed " + user.getPlace() + " with a time of " + user.getLastRaceTime());

                    practice.competeImprovement(user);
                    cpu.updateCPUCompetition(cpuRacers);
                    System.out.println(user);

                }

                if (choice == 2) {

                    tracksim.twoHundredMetersRace(racers);

                    System.out.println("You placed " + user.getPlace() + " with a time of " + user.getLastRaceTime());

                    practice.competeImprovement(user);
                    cpu.updateCPUCompetition(cpuRacers);
                    System.out.println(user);

                }

                if (choice == 3) {

                    tracksim.fourHundredMetersRace(racers);

                    System.out.println("You placed " + user.getPlace() + " with a time of " + user.getLastRaceTime());

                    practice.competeImprovement(user);
                    cpu.updateCPUCompetition(cpuRacers);
                    System.out.println(user);

                }

                else {
                    mainGame = false;
                }
            }
        }

        /*
        test[0] = player1;
        test[1] = player2;
        test[2] = player3;
        test[3] = player4;
        test[4] = player5;
        test[5] = player6;
        test[6] = player7;
        test[7] = player8;

        System.out.println(player3.getName());
        System.out.println(tracksim.oneHundredMeters(player3));
        tracksim.oneHundredMetersRace(test);*/

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
