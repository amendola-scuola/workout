package ManageWorkouts;

public class Manager {
    public static void main(String[] args) {
        System.out.println("Apertura struttura!");
        LockerRoom lockerRoom = new LockerRoom(true);
        Team t1 = new Team("FA", 1, lockerRoom);
        Team t2 = new Team("MC", 2, lockerRoom);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.err.println("Errore join");
        }
        System.out.println("Chiusura struttura!");
    }
}
