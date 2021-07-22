import java.util.*;

public class TrackSim {

    private double mean100m = 10.7459527863;
    private double sd100m = 0.133776557;
    private double mean200m = 21.52218721;
    private double sd200m = 0.160942679;
    private double mean400m = 44.8896305;
    private double sd400m = 0.3135084355;

    //sorts race based on time and assigns runners their postion
    public void sortRace(double[] runnersTime, Player[] runners) {

        Arrays.sort(runnersTime);

        for (int i = 0; i < runners.length; i++) {

            for (int j = 0; j < runnersTime.length; j++) {

                if (runners[i].getLastRaceTime() == runnersTime[j]) {

                    runners[i].setPlace(j + 1);
                }
            }
        }
    }

    //returns player 100m time based on 100m overall
    public double oneHundredMeters(Player player) {

        double overall = player.overall100m();
        double difference = 0.0;
        double divided = 0.0;
        double speed = 0.0;

        Random rand = new Random();

        //compares ovr to middle ovr and then adds/subtract from average 100m time
        if (overall >= 350.0) {

            difference = overall - 350.0;
            divided = difference * .005;

            speed = (rand.nextGaussian() * sd100m + (mean100m - divided));
        } else if (overall <= 350.0) {

            difference = 350.0 - overall;
            divided = difference * .005;

            speed = (rand.nextGaussian() * sd100m + (mean100m + divided));
        }

        return speed;
    }

    //generate time for 200m for runner
    public double twoHundredMeters(Player player) {

        double overall = player.overall200m();
        double difference = 0.0;
        double divided = 0.0;
        double speed = 0.0;

        Random rand = new Random();

        if (overall >= 350.0) {

            difference = overall - 350.0;
            divided = difference * .011;

            speed = (rand.nextGaussian() * sd200m + (mean200m - divided));
        } else if (overall <= 350.0) {

            difference = 350.0 - overall;
            divided = difference * .011;

            speed = (rand.nextGaussian() * sd200m + (mean200m + divided));
        }

        return speed;
    }

    //generate time for 400m for runner
    public double fourHundredMeters(Player player) {

        double overall = player.overall400m();
        double difference = 0.0;
        double divided = 0.0;
        double speed = 0.0;

        Random rand = new Random();

        if (overall >= 350.0) {

            difference = overall - 350.0;
            divided = difference * .011;

            speed = (rand.nextGaussian() * sd400m + (mean400m - divided));
        } else if (overall <= 350.0) {

            difference = 350.0 - overall;
            divided = difference * .011;

            speed = (rand.nextGaussian() * sd400m + (mean400m + divided));
        }

        return speed;
    }

    //Simulates 100m race for the # of players in the array
    public void oneHundredMetersRace(Player[] runners) {

        double[] runnersTime = new double[runners.length];
        double winningTime = 15.0;
        double index = 0;
        String winner = "";

        //Running 100m method to get a time for each runner
        for (int i = 0; i < runners.length; i++) {

            runnersTime[i] = Math.round(oneHundredMeters(runners[i]) * 100.0) / 100.0;
        }

        //Loops through the runner's times and sets fastest time as winning time
        for (int i = 0; i < runnersTime.length; i++) {

            if (runnersTime[i] < winningTime) {

                winningTime = runnersTime[i];
                winner = runners[i].getName();
                index = i;
            }
        }

        //Updating runner's last time
        for (int i = 0; i < runners.length; i++) {

            runners[i].setLastRaceTime(runnersTime[i]);
        }

        //Compares race time to runners fastest time and updates it if racetime is faster
        for (int i = 0; i < runners.length; i++) {

            if (runnersTime[i] < runners[i].getFastest100m()) {

                runners[i].setFastest100m(runnersTime[i]);
            }
        }

        //Print out name of runners, what lane they're in, and their times. Also prints out the winner and winning time.
        System.out.println("Mens 100M " + runners.length + " runners");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < runners.length; i++) {

            System.out.println("Lane " + (i + 1) + ":" + " " + runners[i].getName() + " ran: " + runnersTime[i]);
        }

        System.out.println("The winner is " + winner + " with a time of " + winningTime + "\n");

        //Remove Stamina after competing
        for (int i = 0; i < runners.length; i++) {

            runners[i].setStamina(runners[i].getStamina() - 20);
        }

        sortRace(runnersTime, runners);
    }

    //Simulates 200m race with # of runners in array
    public void twoHundredMetersRace(Player[] runners) {

        double[] runnersTime = new double[runners.length];
        double winningTime = 30.0;
        double index = 0;
        String winner = "";

        //Running 200m method to get a time foe each runner
        for (int i = 0; i < runners.length; i++) {

            runnersTime[i] = Math.round(twoHundredMeters(runners[i]) * 100.0) / 100.0;
        }

        //Loops through the runner's times and sets fastest time as winning time
        for (int i = 0; i < runnersTime.length; i++) {

            if (runnersTime[i] < winningTime) {

                winningTime = runnersTime[i];
                winner = runners[i].getName();
                index = i;
            }
        }

        //Updating runner's last time
        for (int i = 0; i < runners.length; i++) {

            runners[i].setLastRaceTime(runnersTime[i]);
        }

        //Compares race time to runners fastest time and updates it if racetime is faster
        for (int i = 0; i < runners.length; i++) {

            if (runnersTime[i] < runners[i].getFastest200m()) {

                runners[i].setFastest200m(runnersTime[i]);
            }
        }

        //Print out name of runners, what lane they're in, and their times. Also prints out the winner and winning time.
        System.out.println("Mens 200M " + runners.length + " runners");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < runners.length; i++) {

            System.out.println("Lane " + (i + 1) + ":" + " " + runners[i].getName() + " ran: " + runnersTime[i]);
        }

        System.out.println("The winner is " + winner + " with a time of " + winningTime + "\n");

        //Remove stamina after competing;
        for (int i = 0; i < runners.length; i++) {

            runners[i].setStamina(runners[i].getStamina() - 20);
        }

        sortRace(runnersTime, runners);
    }

    //Simulates 400m race with # of runners in array
    public void fourHundredMetersRace(Player[] runners) {

        double[] runnersTime = new double[runners.length];
        double winningTime = 60.0;
        double index = 0;
        String winner = "";

        //Running 200m method to get a time foe each runner
        for (int i = 0; i < runners.length; i++) {

            runnersTime[i] = Math.round(fourHundredMeters(runners[i]) * 100.0) / 100.0;
        }

        //Loops through the runner's times and sets fastest time as winning time
        for (int i = 0; i < runnersTime.length; i++) {

            if (runnersTime[i] < winningTime) {

                winningTime = runnersTime[i];
                winner = runners[i].getName();
                index = i;
            }
        }

        //Updating runner's last time
        for (int i = 0; i < runners.length; i++) {

            runners[i].setLastRaceTime(runnersTime[i]);
        }

        //Compares race time to runners fastest time and updates it if racetime is faster
        for (int i = 0; i < runners.length; i++) {

            if (runnersTime[i] < runners[i].getFastest400m()) {

                runners[i].setFastest400m(runnersTime[i]);
            }
        }

        //Print out name of runners, what lane they're in, and their times. Also prints out the winner and winning time.
        System.out.println("Mens 400M " + runners.length + " runners");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < runners.length; i++) {

            System.out.println("Lane " + (i + 1) + ":" + " " + runners[i].getName() + " ran: " + runnersTime[i]);
        }

        System.out.println("The winner is " + winner + " with a time of " + winningTime + "\n");

        //removes stamnia after competiting
        for (int i = 0; i < runners.length; i++) {

            runners[i].setStamina(runners[i].getStamina() - 20);
        }

        sortRace(runnersTime, runners);
    }
}