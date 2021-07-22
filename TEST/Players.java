import java.util.*;
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

    public void updateCPU(ArrayList<Player>  cpu) {

        Random rnd = new Random();
        int choice = 0;

        for (int i = 0; i < cpu.size(); i++) {

            choice = rnd.nextInt(9) + 1;

            if (choice == 1) {

                cpuOneHundredPractice(cpu.get(i));
            }
    
            else if (choice == 2) {
    
                cpuTwoHundredPractice(cpu.get(i));
            }
    
            else if (choice == 3) {
    
                cpuFourHundredPractice(cpu.get(i));
            }
    
            else if (choice == 4) {
    
                cpuAccelerationPractice(cpu.get(i));
            }
    
            else if (choice == 5) {
    
                cpuEndurancePractice(cpu.get(i));
            }
    
            else if (choice == 6) {
    
                cpuFormPractice(cpu.get(i));
            }
    
            else if (choice == 7) {
    
                cpuMentalPractice(cpu.get(i));
            }
    
            else if (choice == 8) {
    
                cpuSpeedPractice(cpu.get(i));
            }
    
            else if (choice == 9) {
    
                cpuStartPractice(cpu.get(i));
            }
        }
    }

    public void updateCPUCompetition(Player[] cpu) {

        Practice practice = new Practice();

        for (int i = 0; i < cpu.length; i++) {

            int place = cpu[i].getPlace();
            Random rnd = new Random();
            int method = rnd.nextInt(6) + 1;
            int xp = 0;

            if (place == 1) {

                xp = rnd.nextInt((14 - 12) + 1) + 12;
                practice.randomAttributeIncrease(method, xp, cpu[i]);
            }
            
            else if (place == 2) {

                xp = rnd.nextInt((11 - 9) + 1) + 9;
                practice.randomAttributeIncrease(method, xp, cpu[i]);
            }

            else if (place == 3) {

                xp = rnd.nextInt((8 - 6) + 1) + 8;
                practice.randomAttributeIncrease(method, xp, cpu[i]);
            }

            else if (place == 4) {

                practice.randomAttributeIncrease(method, 5, cpu[i]);
            }

            else if (place == 5) {

                practice.randomAttributeIncrease(method, 4, cpu[i]);
            }

            else if (place == 6) {

                practice.randomAttributeIncrease(method, 3, cpu[i]);
            }

            else if (place == 7) {

                practice.randomAttributeIncrease(method, 2, cpu[i]);
            }

            else if (place == 8) {

                practice.randomAttributeIncrease(method, 1, cpu[i]);
            }
        }
    }

    public void cpuRest(ArrayList<Player>  cpu) {

        for (int i = 0; i < cpu.size(); i++) {

            Random rnd = new Random();
            int restStamina = rnd.nextInt(9) + 1;
    
            cpu.get(i).setStamina(cpu.get(i).getStamina() + restStamina);
    
            if (cpu.get(i).getStamina() >= 100) {
    
                cpu.get(i).setStamina(100);
            }
        }
    }

    public void cpuRestOrTrain(ArrayList<Player>  cpu) {

        Random rnd = new Random();
        int choice = rnd.nextInt(2);

        if (choice == 0) {

            cpuRest(cpu);
        }

        else {

            updateCPU(cpu);
        }
    }
}