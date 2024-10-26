package trotinette;

public class Location {
    private Trotinette trotinette;
    private Utilisateur utilisateur;

    double kmparcourus = 0;
    /**
     * Prix au km
     */
    double tarif;

    long debutLocation;
    long finLocation = 0;

    /**
     * constructeur qui initialise une nouvelle location, enregistre la trottinette, l’utilisateur et le tarif, et démarre le timestamp.
     * @param trotinette object trotinette
     * @param utilisateur object utilisateur
     * @param tarif prix au km
     */
    public Location(Trotinette trotinette, Utilisateur utilisateur, double tarif) {
        this.trotinette = trotinette;
        this.utilisateur = utilisateur;
        this.tarif = tarif;
        this.debutLocation = System.currentTimeMillis();
    }

    public double calculerCout() {
        return kmparcourus * tarif;
    }

    void terminerLocation(double kmparcourus) {
        this.finLocation = System.currentTimeMillis();
        this.kmparcourus = kmparcourus;
    }

    long duree() {
        if(finLocation != 0) {
            return finLocation - debutLocation;
        }
        return 0;
    }

    public Trotinette getTrotinette() {
        return trotinette;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public String toString() {
        return trotinette.toString()+"\n"+utilisateur.toString()+"\n Km parcourus: "+kmparcourus+"\n Tarif: "+tarif+ "\n Cout du trajet: "+ calculerCout();
    }

}
