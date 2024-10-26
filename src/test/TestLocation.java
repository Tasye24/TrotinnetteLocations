package test;

import trotinette.Location;
import trotinette.Trotinette;
import trotinette.Utilisateur;

public class TestLocation {
    public static void main(String[] args) {
        Trotinette t = new Trotinette("PARIS(75)-008", 25, true);
        Utilisateur hamid = new Utilisateur("Hamid B.", 18717489);

        double tarif = 2; // 2 euros pour parcourir 1 km

        Location location = new Location(t, hamid, 7);

        System.out.println(location);
    }
}
