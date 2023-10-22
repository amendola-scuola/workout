package ManageWorkouts;

public class LockerRoom {
    private boolean spogliatoioLibero;
    public LockerRoom (boolean spogliatoioLibero) {
        this.spogliatoioLibero = spogliatoioLibero;
    }

    public void usaSpogliatoio(String nomeTeam) {
        while(!spogliatoioLibero) {
            System.out.println("Spogliatoio occupato! Il team: "
                    + nomeTeam + " sta aspettando che si liberi...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.err
                        .println("Errore wait()\n" + e.getStackTrace());
            }
        }

        spogliatoioLibero = false;
        try {
            System.out
                    .println("Inizio ad utilizzare lo spogliatoio!"
                            + nomeTeam);
            Thread.currentThread().sleep(3000);
            System.out
                    .println("Ho finito di utilizzare lo spogliatoio!"
                            + nomeTeam);
        } catch (InterruptedException e) {
            System.err
                    .println("Errore sleep()\n" + e.getStackTrace());
        }
        spogliatoioLibero = true;
        notify();
    }
}
