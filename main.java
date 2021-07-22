public class main {

    public static void main (String[] args) {

        TrackSim race = new TrackSim();
        Practice practice = new Practice();
        //acceleration, age, endurance, form, mental, speed, stamina, start

        Player tim = new Player(100,23,100,100,100,100,100,100,"Tim");
        Player joe = new Player(0,19,0,0,0,0,0,0,"Joe");
        Player bill = new Player(73,17,17,94,22,74,34,1,"Bill");
        Player jake = new Player(0,7,42,91,4,24,51,23,"jake");
        Player zack = new Player(3,17,7,11,23,84,42,13,"zack");
        Player harvey = new Player(12,57,63,33,20,61,89,18,"harvey");
        Player matt = new Player(48,37,4,94,22,74,34,31,"matt");
        Player tom = new Player(32,14,2,4,53,82,47,82,"tom");
        Player john = new Player(49,65,30,25,14,38,93,5,"John");
        Player mark = new Player(4,26,99,98,76,51,91,90,"Mark");
        Player lee = new Player(92,60,42,99,67,58,34,85,"Lee");
        Player mike = new Player(68,73,68,74,37,22,20,69,"Mike");
        Player dee = new Player(92,60,42,99,67,58,34,85,"Dee");
        Player robert = new Player(0,16,0,0,0,0,0,0,"Robert");
        Player dre = new Player(90,20,36,51,62,84,100,72,"Dre");//100m
        Player nick = new Player(32,20,100,74,84,64,100,31,"Nick");//400m
        Player jeff = new Player(73,20,62,65,67,90,100,56,"Jeff");//200m
        Player adeesh = new Player(78,20,64,66,63,78,100,61,"Adeesh");//all


        Player[] runners = new Player[8];
        Player[] test = new Player[4];        
        Player[] test1 = new Player[5];
        Player[] jfk = new Player[4];

        jfk[0] = dre;
        jfk[1] = nick;
        jfk[2] = robert;
        jfk[3] = jeff;

        test1[0] = tim;
        test1[1] = mark;
        test1[2] = lee;
        test1[3] = mike;
        test1[4] = dee;

        test[0] = john;
        test[1] = mark;
        test[2] = lee;
        test[3] = mike;

        runners[0] = tim;
        runners[1] = joe;
        runners[2] = bill;
        runners[3] = jake;
        runners[4] = zack;
        runners[5] = harvey;
        runners[6] = matt;
        runners[7] = tom;

        race.oneHundredMetersRace(jfk);
        race.twoHundredMetersRace(jfk);
        race.fourHundredMetersRace(jfk);
        System.out.println(dre.toString());
        System.out.println(nick.toString());
        System.out.println(jeff.toString());
        System.out.println(robert.toString());
        practice.twoHundredPractice(robert);
        System.out.println(robert.toString());

    }   
}