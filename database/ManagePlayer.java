import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManagePlayer {
    private static SessionFactory factory;

    public static void main(String[] args) {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManagePlayer MP = new ManagePlayer();

        /* Add few Player records in database */
        Integer empID1 = MP.addPlayer(78, 20, 64, 66, 63, 78, 100, 61, "Adeesh");
        Integer empID2 = MP.addPlayer(90, 20, 36, 51, 62, 84, 100, 72, "Dre");
        Integer empID3 = MP.addPlayer(73, 20, 62, 65, 67, 90, 100, 56, "Jeff");

        /* List down all the Players */
        MP.listPlayers();

        /* Update Player's records */
        MP.updatePlayer(empID1, 5000);

        /* Delete an Player from the database */
        MP.deletePlayer(empID2);

        /* List down new list of the Players */
        MP.listPlayers();
    }

    /* Method to CREATE an Player in the database */
    public Integer addPlayer(int acceleration, int age, int endurance, int form, int mental, int speed, int stamina, int start, String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer PlayerID = null;

        try {
            tx = session.beginTransaction();
            Player player = new Player(acceleration, age, endurance, form, mental, speed, stamina, start, name);
            playerID = (Integer) session.save(player);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return playerID;
    }

    /* Method to  READ all the Players */
    public void listPlayers() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List players = session.createQuery("FROM Player").list();
            for (Iterator iterator = players.iterator(); iterator.hasNext(); ) {
                Player player = (Player) iterator.next();
                System.out.print("First Name: " + player.getName());
                System.out.println("  Salary: " + player.getAge());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE age for an Player */
    public void updatePlayer(Integer PlayerID, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Player player = (Player) session.get(Player.class, PlayerID);
            player.setAge(salary);
            session.update(player);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an Player from the records */
    public void deletePlayer(Integer PlayerID) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Player player = (Player) session.get(Player.class, PlayerID);
            session.delete(player);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}