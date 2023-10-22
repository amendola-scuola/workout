package ManageWorkouts;

/*
 * @author Monica Ciuchetti
 * @see https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
 * @version 1.0
 */

class Team extends Thread {
    String nome;
    int idTeam;
    LockerRoom lockerRoom;

    public Team(String nome,
                int idTeam,
                LockerRoom lockerRoom) {
        this.nome = nome;
        this.idTeam = idTeam;
        this.lockerRoom = lockerRoom;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        entra();
        gioca();
        esci();
        lockerRoom.usaSpogliatoio(nome);
    }

    public void entra() {
        System.out.println("La squadra " + this.getNome() + " è entrata in campo.");
    }

    public void esci() {
        System.out.println("La squadra " + this.getNome() + " ha terminato gli allenamenti.");
    }

    public void gioca() {
        try {
            sleep(3000);
        } catch (InterruptedException ex) {
            System.err.println("Errore metodo sleep()");
        }
    }
}