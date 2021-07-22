import java.util.Random;

public class Players {

    public void cpuOneHundredPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(5) + 1;
        int xp2 = rnd.nextInt(3) + 1;
        int xp3 = rnd.nextInt(2) + 1;

        runner.setAcceleration(runner.getAcceleration() + xp);
        runner.setSpeed(runner.getSpeed() + xp2);
        runner.setStart(runner.getStart() + xp3);
        runner.setStamina(runner.getStamina() - 10);
    }


    public void cpuTwoHundredPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(3) + 1;
        int xp2 = rnd.nextInt(5) + 1;
        int xp3 = rnd.nextInt(2) + 1;

        runner.setAcceleration(runner.getAcceleration() + xp);
        runner.setSpeed(runner.getSpeed() + xp2);
        runner.setEndurance(runner.getSpeed() + xp3);
        runner.setStamina(runner.getStamina() - 10);
    }

    public void cpuFourHundredPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(5) + 1;
        int xp2 = rnd.nextInt(3) + 1;
        int xp3 = rnd.nextInt(2) + 1;

        runner.setEndurance(runner.getEndurance() + xp);
        runner.setForm(runner.getForm() + xp2);
        runner.setSpeed(runner.getSpeed() + xp3);
        runner.setStamina(runner.getStamina() - 10);
    }

    public void cpuAccelerationPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setAcceleration(runner.getAcceleration() + xp);
        runner.setStamina(runner.getStamina() - 5);
    }

    public void cpuEndurancePractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setEndurance(runner.getEndurance() + xp);
        runner.setStamina(runner.getStamina() - 5);
    }

    public void cpuFormPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setForm(runner.getForm() + xp);
        runner.setStamina(runner.getStamina() - 5);
    }

    public void cpuMentalPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setMental(runner.getMental() + xp);
        runner.setStamina(runner.getStamina() - 5);
    }

    public void cpuSpeedPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setSpeed(runner.getSpeed() + xp);
        runner.setStamina(runner.getStamina() - 5);
    }

    public void cpuStartPractice(Player runner) {

        Random rnd = new Random();
        int xp = rnd.nextInt(10) + 1;

        runner.setStart(runner.getStart() + xp);
        runner.setStamina(runner.getStamina() - 5);
    }

    public void updateCPU(Player[] cpu) {

        Random rnd = new Random();
        int choice = 0;

        for (int i = 0; i < 8; i++) {

            choice = rnd.nextInt(9) + 1;

            if (choice == 1) {

                cpuOneHundredPractice(cpu[i + 1]);
            } else if (choice == 2) {

                cpuTwoHundredPractice(cpu[i + 1]);
            } else if (choice == 3) {

                cpuFourHundredPractice(cpu[i + 1]);
            } else if (choice == 4) {

                cpuAccelerationPractice(cpu[i + 1]);
            } else if (choice == 5) {

                cpuEndurancePractice(cpu[i + 1]);
            } else if (choice == 6) {

                cpuFormPractice(cpu[i + 1]);
            } else if (choice == 7) {

                cpuMentalPractice(cpu[i + 1]);
            } else if (choice == 8) {

                cpuSpeedPractice(cpu[i + 1]);
            } else if (choice == 9) {

                cpuStartPractice(cpu[i + 1]);
            }
        }
    }

    public void updateCPUCompetition(Player[] cpu) {

        Practice practice = new Practice();

        for (int i = 0; i < 8; i++) {

            int place = cpu[i].getPlace();
            Random rnd = new Random();
            int method = rnd.nextInt(6) + 1;
            int xp = 0;

            if (place == 1) {

                xp = rnd.nextInt((14 - 12) + 1) + 12;
                practice.randomAttributeIncrease(method, xp, cpu[i]);
            } else if (place == 2) {

                xp = rnd.nextInt((11 - 9) + 1) + 9;
                practice.randomAttributeIncrease(method, xp, cpu[i]);
            } else if (place == 3) {

                xp = rnd.nextInt((8 - 6) + 1) + 8;
                practice.randomAttributeIncrease(method, xp, cpu[i]);
            } else if (place == 4) {

                practice.randomAttributeIncrease(method, 5, cpu[i]);
            } else if (place == 5) {

                practice.randomAttributeIncrease(method, 4, cpu[i]);
            } else if (place == 6) {

                practice.randomAttributeIncrease(method, 3, cpu[i]);
            } else if (place == 7) {

                practice.randomAttributeIncrease(method, 2, cpu[i]);
            } else if (place == 8) {

                practice.randomAttributeIncrease(method, 1, cpu[i]);
            }
        }
    }

    public void cpuRest(Player[] cpu) {

        for (int i = 0; i < 8; i++) {

            Random rnd = new Random();
            int restStamina = rnd.nextInt(9) + 1;

            cpu[i + 1].setStamina(cpu[i + 1].getStamina() + restStamina);

            if (cpu[i + 1].getStamina() >= 100) {

                cpu[i + 1].setStamina(100);
            }
        }
    }

    public void cpuRestOrTrain(Player[] cpu) {

        Random rnd = new Random();
        int choice = rnd.nextInt(2);

        if (choice == 0) {

            cpuRest(cpu);
        } else {

            updateCPU(cpu);
        }
    }
}