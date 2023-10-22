package ManageWorkouts;

public class LockerRoom {
    private boolean spogliatoioLibero;
    public LockerRoom (boolean spogliatoioLibero) {
        this.spogliatoioLibero = spogliatoioLibero;
    }

    public void usaSpogliatoio(String nomeTeam) {
        synchronized(this) {
            while (!spogliatoioLibero) {
                System.out.println("Spogliatoio occupato! Il team: "
                        + nomeTeam + " sta aspettando che si liberi...");
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.err.println("Errore wait()\n" + e.getStackTrace());
                }
            }

            spogliatoioLibero = false;
            try {
                System.out.println("La squadra " + nomeTeam + " ha iniziato ad utilizzare lo spogliatoio!");
                wait(3000);
                System.out.println("La squadra " + nomeTeam + " ha finito di utilizzare lo spogliatoio!");
            } catch (InterruptedException e) {
                System.err.println("Errore sleep()\n" + e.getStackTrace());
            }
            spogliatoioLibero = true;
            notify();
        }
    }
}
