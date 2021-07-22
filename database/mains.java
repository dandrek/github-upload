import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class mains {

    public static String randomName() throws FileNotFoundException, IOException {

        Random rnd = new Random();
        int numLine = rnd.nextInt(18239) + 1;
        String firstWord = Files.readAllLines(Paths.get("names.txt")).get(numLine);

        return firstWord;
    }

    public static void main(String[] args) throws IOException {

        Scanner scnr = new Scanner(System.in); // Scanner for user input
        TrackSim race = new TrackSim();
        Practice practice = new Practice();
        Players cpu = new Players();
        Random rnd = new Random();
        int acceleration = rnd.nextInt(10);
        int cpuAge = rnd.nextInt((30 - 10) + 1) + 10;
        int endurance = rnd.nextInt(10);
        int form = rnd.nextInt(10);
        int mental = rnd.nextInt(10);
        int speed = rnd.nextInt(10);
        int stamina = rnd.nextInt((100 - 90) + 1) + 90;
        int start = rnd.nextInt(10);
        boolean runProgram = true;
        boolean mainGame = true;
        String userName = "";
        int age = 0;
        int choice = 20;
        Player[] cpuPlayers = new Player[100];


        while (runProgram) {

            System.out.println("Create your player!");
            System.out.println();
            System.out.println("Input a name");

            userName = scnr.nextLine();

            System.out.println("Input an age");

            age = scnr.nextInt();

            Player player = new Player(0, age, 0, 0, 0, 0, 100, 0, userName);

            cpuPlayers[0] = player;

            for (int i = 1; i <= 9; i++) {

                cpuPlayers[i] = new Player(acceleration, cpuAge, endurance, form, mental, speed, stamina, start, randomName());
            }

            System.out.println();
            System.out.println("You start off at 0 in every attribute and 100 in stamina. " + "\nThe attributes are "
                    + "acceleration, endurance, form, mental, speed, and start " + "\nTrain and compete to increase your attributes!"
                    + "\nMake sure you rest to gain stamina! Training and competing cost stamina!");

            //Starting menu
            while (mainGame) {

                System.out.println();
                System.out.println("Would you like to compete? If so press 1");
                System.out.println("Would you like to practice? If so press 2");
                System.out.println("Would you like to rest? If so press 3");

                choice = scnr.nextInt();

                if (choice == 1) {

                    Player[] cpuRunners = new Player[8];

                    for (int i = 0; i < 8; i++) {

                        cpuRunners[i] = cpuPlayers[i];
                    }

                    System.out.println("What would you race would you like to run?");
                    System.out.println("1:100m");
                    System.out.println("2:200m");
                    System.out.println("3:400m");
                    choice = scnr.nextInt();

                    if (choice == 1) {

                        race.oneHundredMetersRace(cpuRunners);

                        System.out.println("You placed " + player.getPlace() + " with a time of " + player.getLastRaceTime());

                        practice.competeImprovement(player);
                        cpu.updateCPUCompetition(cpuRunners);
                        System.out.println(player);

                    }

                    if (choice == 2) {

                        race.twoHundredMetersRace(cpuRunners);

                        System.out.println("You placed " + player.getPlace() + " with a time of " + player.getLastRaceTime());

                        practice.competeImprovement(player);
                        cpu.updateCPUCompetition(cpuRunners);
                        System.out.println(player);

                    }

                    if (choice == 3) {

                        race.fourHundredMetersRace(cpuRunners);

                        System.out.println("You placed " + player.getPlace() + " with a time of " + player.getLastRaceTime());

                        practice.competeImprovement(player);
                        cpu.updateCPUCompetition(cpuRunners);
                        System.out.println(player);

                    }
                } else if (choice == 2) {

                    System.out.println();
                    System.out.println("What would you like to work on?");
                    System.out.println("1:100m Practice(You gain a random amount of xp in acceleration, speed, and start");
                    System.out.println("2:200m Practice(You gain a random amount of xp in acceleration, speed, and endurance");
                    System.out.println("3:400m Practice(You gain a random amount of xp in endurance, form and speed");
                    System.out.println("4:Acceleration Practie(You gain a random amount of xp up to 10)");
                    System.out.println("5:Endurance Practie(You gain a random amount of xp up to 10)");
                    System.out.println("6:Form Practie(You gain a random amount of xp up to 10)");
                    System.out.println("6:Mental Practie(You gain a random amount of xp up to 10)");
                    System.out.println("8:Speed Practie(You gain a random amount of xp up to 10)");
                    System.out.println("9:Start Practie(You gain a random amount of xp up to 10)");

                    choice = scnr.nextInt();

                    if (choice == 1) {

                        cpu.cpuRestOrTrain(cpuPlayers);
                        practice.oneHundredPractice(player);
                    } else if (choice == 2) {

                        cpu.cpuRestOrTrain(cpuPlayers);
                        practice.twoHundredPractice(player);
                    } else if (choice == 3) {

                        cpu.cpuRestOrTrain(cpuPlayers);
                        practice.fourHundredPractice(player);
                    } else if (choice == 4) {

                        cpu.cpuRestOrTrain(cpuPlayers);
                        practice.accelerationPractice(player);
                    } else if (choice == 5) {

                        cpu.cpuRestOrTrain(cpuPlayers);
                        practice.endurancePractice(player);
                    } else if (choice == 6) {

                        cpu.cpuRestOrTrain(cpuPlayers);
                        practice.formPractice(player);
                    } else if (choice == 7) {

                        cpu.cpuRestOrTrain(cpuPlayers);
                        practice.mentalPractice(player);
                    } else if (choice == 8) {

                        cpu.cpuRestOrTrain(cpuPlayers);
                        practice.speedPractice(player);
                    } else if (choice == 9) {

                        cpu.cpuRestOrTrain(cpuPlayers);
                        practice.startPractice(player);
                    } else {

                        System.out.println("You didn't select any of the options!");
                    }
                } else if (choice == 3) {

                    cpu.cpuRestOrTrain(cpuPlayers);
                    practice.rest(player);
                } else {

                    mainGame = false;
                    runProgram = false;
                }
            }
        }
    }
}