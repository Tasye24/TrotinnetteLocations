package test;

import trotinette.Trotinette;

public class TestTrotinette {
    public static void main(String[] args) {
        // Création d'une trotinette
        Trotinette trotti = new Trotinette("1489eaF", 20, true);

        System.out.println(trotti);

        trotti.louer(); System.out.println(trotti);

        trotti.retourner(7); System.out.println(trotti);
    }
}
