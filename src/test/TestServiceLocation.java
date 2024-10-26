package test;

import trotinette.ServiceLocation;
import trotinette.Trotinette;
import trotinette.Utilisateur;

import java.util.ArrayList;

public class TestServiceLocation {
    public static void main(String[] args) {
        ServiceLocation serviceLocation = new ServiceLocation();
        serviceLocation.setTarif(5);

        serviceLocation.ajouterTrotinette(new Trotinette("PARIS-008", 25, true));
        serviceLocation.ajouterTrotinette(new Trotinette("PARIS-015", 12, false));
        serviceLocation.ajouterTrotinette(new Trotinette("PARIS-005", 12, true));

        Utilisateur a = new Utilisateur("John", 25);
        a.ajouterFonds(700);

        Utilisateur b = new Utilisateur("Karim", 213);
        b.ajouterFonds(15);

        serviceLocation.ajouterUtilisateur(a);
        serviceLocation.ajouterUtilisateur(b);

        System.out.println(serviceLocation);

        System.out.println("\n LOCATION de l'user 25 et PARIS-008");

        System.out.println(
            serviceLocation.louerTrotinette(25, "PARIS-008")
        );

        serviceLocation.retournerTrotinette(25, "PARIS-008", 7);


        System.out.println("Revenus total: "+serviceLocation.calculerRevenus());
        System.out.println(serviceLocation);


    }
}
