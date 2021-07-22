package entity;
import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "acceleration")
    private int acceleration;

    @Column(name = "age")
    private int age;

    @Column(name = "endurance")
    private int endurance;

    @Column(name = "place")
    private int place;

    @Column(name = "form")
    private int form;

    @Column(name = "mental")
    private int mental;

    @Column(name = "speed")
    private int speed;

    @Column(name = "stamina")
    private int stamina;

    @Column(name = "start")
    private int start;

    @Column(name = "fastest100m")
    private double fastest100m;

    @Column(name = "fastest200m")
    private double fastest200m;

    @Column(name = "fastest400m")
    private double fastest400m;

    @Column(name = "lastRaceTime")
    private double lastRaceTime;

    @Column(name = "name")
    private String name;

    public Player() {
    }

    public Player(int acceleration, int age, int endurance, int form, int mental, int speed, int stamina, int start, String name) {

        this.acceleration = acceleration;
        this.age = age;
        this.endurance = endurance;
        this.form = form;
        this.mental = mental;
        this.speed = speed;
        this.stamina = stamina;
        this.start = start;
        this.name = name;
        fastest100m = 15.0;
        fastest200m = 30.0;
        fastest400m = 60.0;
        lastRaceTime = 100.0;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setFastest100m(double fastest100m) {
        this.fastest100m = fastest100m;
    }

    public void setFastest200m(double fastest200m) {
        this.fastest200m = fastest200m;
    }

    public void setFastest400m(double fastest400m) {
        this.fastest400m = fastest400m;
    }

    public void setLastRaceTime(double lastRaceTime) {
        this.lastRaceTime = lastRaceTime;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getAge() {
        return age;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getPlace() {
        return place;
    }

    public int getForm() {
        return form;
    }

    public int getMental() {
        return mental;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStamina() {
        return stamina;
    }

    public int getStart() {
        return start;
    }

    public int getId() {
        return id;
    }

    public double getFastest100m() {
        return fastest100m;
    }

    public double getFastest200m() {
        return fastest200m;
    }

    public double getFastest400m() {
        return fastest400m;
    }

    public double getLastRaceTime() {
        return lastRaceTime;
    }

    //Method to print out runner's Last race type, time and place
    public String getLastRace() {

        double time = getLastRaceTime();
        String race = "";

        if ((time < 70 && time > 24)) {

            race = "400m";
        } else if ((time < 35 && time > 15)) {

            race = "200m";
        } else if ((time < 15)) {

            race = "100m";
        }

        return race + " with a time of " + time + " and placed " + getPlace();
    }

    //Prints out name, attributes and fastest times
    public String toString() {

        return name + " Acceleration:" + acceleration + " Speed:" + speed + " start:" + start + " Stamina:" + stamina + " Form:"
                + form + " Endurance:" + endurance + " Mental:" + mental + "\n100m Overall:" + Math.round(overall100m() * 100.0) / 100.0
                + " 200m Overall:" + Math.round(overall200m() * 100.0) / 100.0 + " 400m Overall:" + Math.round(overall400m() * 100.0) / 100.0
                + "\nFastest 100m: " + getFastest100m() + " Fastest 200m:" + getFastest200m() + " Fastest 400m:" + getFastest400m() + "\n";
    }

    //Calculates overall for 100m
    public double overall100m() {

        double acceleration = 2 * this.acceleration;
        double speed = 1.5 * this.speed;
        double start = 1.25 * this.start;
        double form = this.form;
        double endurance = .75 * this.endurance;
        double stamina = .4 * this.stamina;
        double mental = .1 * this.mental;
        double ovr = acceleration + speed + start + form + endurance + stamina + mental;

        return ovr;
    }

    //Calculates overall for 200m
    public double overall200m() {

        double acceleration = 1.5 * this.acceleration;
        double speed = 2 * this.speed;
        double start = .3 * this.start;
        double form = 1.0 * this.form;
        double endurance = 1.30 * this.endurance;
        double stamina = .7 * this.stamina;
        double mental = .15 * this.mental;
        double ovr = acceleration + speed + start + form + endurance + stamina + mental;

        return ovr;
    }

    //Calculates overall for 400m
    public double overall400m() {

        double acceleration = .8 * this.acceleration;
        double speed = 1.1 * this.speed;
        double start = .2 * this.start;
        double form = 1.3 * this.form;
        double endurance = 2.5 * this.endurance;
        double stamina = .7 * this.stamina;
        double mental = .4 * this.mental;
        double ovr = acceleration + speed + start + form + endurance + stamina + mental;

        return ovr;
    }
}
