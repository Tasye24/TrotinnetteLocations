package trotinette;

public class Utilisateur {
    private String nom;
    private int idUtilisateur;
    private double solde;

    public Utilisateur(String nom, int idUtilisateur) {
        setNom(nom);
        setIdUtilisateur(idUtilisateur);
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public double getSolde() {
        return solde;
    }

    public void ajouterFonds(double montant) {
        this.solde += montant;
    }
    public boolean payer(double montant) {
        if(montant <= getSolde()) {
            solde -= montant;
        } else {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Utilisateur: ");
        sb.append(nom).append(", idUtilisateur: ").append(idUtilisateur);
        sb.append(", solde: ").append(solde);
        return sb.toString();
    }

}
