package test;

import trotinette.Utilisateur;

public class TestUtilisateur {
    public static void pay(Utilisateur u, double montant) {
        if(u.payer(montant)) {
            System.out.println("Payment successful (-"+montant+")");
            System.out.println(u);
        } else {
            System.out.println("Il n'a pas pu payer :"+montant);
            System.out.println(u);
        }
    }
    public static void main(String[] args) {
        Utilisateur utilisateur = new Utilisateur("John", 2898004);

        System.out.println(utilisateur);

        utilisateur.ajouterFonds(1780); System.out.println(utilisateur);

        int montant1 = 155;

        pay(utilisateur, montant1);
        pay(utilisateur, montant1*100000);

    }
}
