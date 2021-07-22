import java.util.*;

public class Practice {

    public String method = "";//used for name of method in randomattributesincrease

    public void rest(Player runner) {

        Random rnd = new Random();
        int restStamina = rnd.nextInt(9) + 1;

        runner.setStamina(runner.getStamina() + restStamina);

        if (runner.getStamina() >= 100) {

            runner.setStamina(100);

            restStamina = 0;

            System.out.println("You've maxed your stamina!");
        } else {

            System.out.println("You've rested! and gained " + restStamina + " Stamina");
            System.out.println("Your stamina is now " + runner.getStamina());
        }
    }

    public void oneHundredPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(5) + 1;
        int xp2 = rnd.nextInt(3) + 1;
        int xp3 = rnd.nextInt(2) + 1;

        runner.setAcceleration(runner.getAcceleration() + xp);
        runner.setSpeed(runner.getSpeed() + xp2);
        runner.setStart(runner.getStart() + xp3);

        System.out.println("Your acceleration improved by " + xp
                + "\nYour speed improved by " + xp2
                + "\nYour start improved by " + xp3);

        runner.setStamina(runner.getStamina() - 10);

        System.out.println("Your stamina is now " + runner.getStamina());
    }


    public void twoHundredPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(3) + 1;
        int xp2 = rnd.nextInt(5) + 1;
        int xp3 = rnd.nextInt(2) + 1;

        runner.setAcceleration(runner.getAcceleration() + xp);
        runner.setSpeed(runner.getSpeed() + xp2);
        runner.setEndurance(runner.getSpeed() + xp3);

        System.out.println("Your acceleration improved by " + xp
                + "\nYour speed improved by " + xp2
                + "\nYour endurance improved by " + xp3);

        runner.setStamina(runner.getStamina() - 10);

        System.out.println("Your stamina is now " + runner.getStamina());
    }

    public void fourHundredPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(5) + 1;
        int xp2 = rnd.nextInt(3) + 1;
        int xp3 = rnd.nextInt(2) + 1;

        runner.setEndurance(runner.getEndurance() + xp);
        runner.setForm(runner.getForm() + xp2);
        runner.setSpeed(runner.getSpeed() + xp3);

        System.out.println("Your Endurance improved by " + xp
                + "\nYour form improved by " + xp2
                + "\nYour speed improved by " + xp3);

        runner.setStamina(runner.getStamina() - 10);

        System.out.println("Your stamina is now " + runner.getStamina());
    }

    public void accelerationPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setAcceleration(runner.getAcceleration() + xp);

        System.out.println("Your acceleration improved by " + xp);

        runner.setStamina(runner.getStamina() - 5);

        System.out.println("Your stamina is now " + runner.getStamina());
    }

    public void endurancePractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setEndurance(runner.getEndurance() + xp);

        System.out.println("Your endurance improved by " + xp);

        runner.setStamina(runner.getStamina() - 5);

        System.out.println("Your stamina is now " + runner.getStamina());
    }

    public void formPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setForm(runner.getForm() + xp);

        System.out.println("Your form improved by " + xp);

        runner.setStamina(runner.getStamina() - 5);

        System.out.println("Your stamina is now " + runner.getStamina());
    }

    public void mentalPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setMental(runner.getMental() + xp);

        System.out.println("Your mental improved by " + xp);

        runner.setStamina(runner.getStamina() - 5);

        System.out.println("Your stamina is now " + runner.getStamina());
    }

    public void speedPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setSpeed(runner.getSpeed() + xp);

        System.out.println("Your speed improved by " + xp);

        runner.setStamina(runner.getStamina() - 5);

        System.out.println("Your stamina is now " + runner.getStamina());
    }

    public void startPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setStart(runner.getStart() + xp);

        System.out.println("Your start improved by " + xp);

        runner.setStamina(runner.getStamina() - 5);

        System.out.println("Your stamina is now " + runner.getStamina());
    }

    //Method to get runner's attribute and increase it
    public void randomAttributeIncrease(int method, int number, Player runner) {


        //Sets get attribute methods to number then adds number to a number
        if (method == 1) {

            runner.setAcceleration(runner.getAcceleration() + number);
            this.method = "Acceleration";
        }

        if (method == 2) {

            runner.setEndurance(runner.getEndurance() + number);
            this.method = "Endurance";
        }

        if (method == 3) {

            runner.setForm(runner.getForm() + number);
            this.method = "Form";
        }

        if (method == 4) {

            runner.setSpeed(runner.getSpeed() + number);
            this.method = "Speed";
        }

        if (method == 5) {

            runner.setStart(runner.getStart() + number);
            this.method = "Start";
        }

        if (method == 6) {

            runner.setMental(runner.getMental() + number);
            this.method = "Mental";
        }
    }

    //Improves runner's random attribute by a random number after competing based on place
    public void competeImprovement(Player runner) {

        int place = runner.getPlace();
        Random rnd = new Random();
        int method = rnd.nextInt(6) + 1;
        int xp = 0;

        if (place == 1) {

            xp = rnd.nextInt((14 - 12) + 1) + 12;
            randomAttributeIncrease(method, xp, runner);
            System.out.println("You improved " + this.method + " by " + xp);
        } else if (place == 2) {

            xp = rnd.nextInt((11 - 9) + 1) + 9;
            randomAttributeIncrease(method, xp, runner);
            System.out.println("You improved " + this.method + " by " + xp);
        } else if (place == 3) {

            xp = rnd.nextInt((8 - 6) + 1) + 8;
            randomAttributeIncrease(method, xp, runner);
            System.out.println("You improved " + this.method + " by " + xp);
        } else if (place == 4) {

            randomAttributeIncrease(method, 5, runner);
            System.out.println("You improved " + this.method + " by " + 5);

        } else if (place == 5) {

            randomAttributeIncrease(method, 4, runner);
            System.out.println("You improved " + this.method + " by " + 4);
        } else if (place == 6) {

            randomAttributeIncrease(method, 3, runner);
            System.out.println("You improved " + this.method + " by " + 3);
        } else if (place == 7) {

            randomAttributeIncrease(method, 2, runner);
            System.out.println("You improved " + this.method + " by " + 2);
        } else if (place == 8) {

            randomAttributeIncrease(method, 1, runner);
            System.out.println("You improved " + this.method + " by " + 1);
        }
    }
}