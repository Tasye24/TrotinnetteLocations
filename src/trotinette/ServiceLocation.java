package trotinette;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ServiceLocation {
    private ArrayList<Trotinette> trotinettes;
    private ArrayList<Utilisateur> utilisateurs;
    private ArrayList<Location> locationsEnCours;
    private ArrayList<Location> historiqueLocations;

    private double tarif = 1;
    private final double MIN_SOLDE = 10;

    public ServiceLocation() {
        trotinettes = new ArrayList<Trotinette>();
        utilisateurs = new ArrayList<Utilisateur>();
        locationsEnCours = new ArrayList<Location>();
        historiqueLocations = new ArrayList<Location>();
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public void ajouterTrotinette(Trotinette trotinette) {
        trotinettes.add(trotinette);
    }
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    /**
     * permet à un utilisateur de louer une trottinette si elle est disponible et si son solde est suffisant.
     * @param idUtilisateur
     * @param idTrotinette
     * @return
     */
    public Location louerTrotinette(int idUtilisateur, String idTrotinette) {
        Trotinette t = rechercherTrotinette(idTrotinette);
        Utilisateur u = rechercherUtilisateur(idUtilisateur);

        if (t != null && u != null && t.isDisponible() && u.getSolde() >= MIN_SOLDE) {
            Location l = new Location(t, u, tarif);
            locationsEnCours.add(l);
            return l;
        }
        return null;
    }
    public void retournerTrotinette(int idUtilisateur, String idTrotinette, double kmparcourus) {
        Utilisateur u = rechercherUtilisateur(idUtilisateur);
        Trotinette t = rechercherTrotinette(idTrotinette);
        Location l = rechercherLocationEnCours(t, u);

        if(l != null) {
            l.terminerLocation(kmparcourus);
            historiqueLocations.add(l);
            locationsEnCours.remove(l);
        }
    }

    public ArrayList<Location> afficherHistoriqueUtilisateurs(int idUtilisateur) {
        return getLocations(idUtilisateur, historiqueLocations);
    }
    public ArrayList<Location> afficherLocationEnCours(int idUtilisateur) {
        return getLocations(idUtilisateur, locationsEnCours);
    }

    public double calculerRevenus() {
        double sum = 0;

        for (Iterator<Location> it = historiqueLocations.iterator(); it.hasNext();) {
            Location l = it.next();
            sum += l.calculerCout();
        }
        return sum;
    }

    private ArrayList<Location> getLocations(int idUtilisateur, ArrayList<Location> arrLocation) {
        ArrayList<Location> locUser = new ArrayList<Location>();

        for(Iterator<Location> it = arrLocation.iterator(); it.hasNext();) {
            Location l = it.next();
            if(l.getUtilisateur().getIdUtilisateur() == idUtilisateur) {
                locUser.add(l);
            }
        }

        return locUser;
    }

    public Trotinette rechercherTrotinette(String idTrotinette) {
        for (Iterator<Trotinette> it = trotinettes.iterator(); it.hasNext();) {
            Trotinette trotinetteActuelle = it.next();
            if (trotinetteActuelle.getId().equals(idTrotinette)) {
                return trotinetteActuelle;
            }
        }
        return null;
    }
    public Utilisateur rechercherUtilisateur(int idUtilisateur) {
        for (Iterator<Utilisateur> it = utilisateurs.iterator(); it.hasNext();) {
            Utilisateur utilisateurActuelle = it.next();
            if (utilisateurActuelle.getIdUtilisateur() == idUtilisateur) {
                return utilisateurActuelle;
            }
        }
        return null;
    }
    public Location rechercherLocationEnCours(Trotinette trotinette, Utilisateur utilisateur) {
        for(Iterator<Location> it = locationsEnCours.iterator(); it.hasNext();) {
            Location loc = it.next();
            if(loc.getTrotinette().equals(trotinette) && loc.getUtilisateur().equals(utilisateur)) {
                return loc;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();

        sb.append("Tarif: ").append(tarif).append("/km\n");

        sb.append("\nTrotinettes: ");
        for(Trotinette t : trotinettes) {
            sb.append("\n").append(t.toString());
        }

        sb.append("\nUtilisateurs: ");
        for(Utilisateur u : utilisateurs) {
            sb.append("\n").append(u.toString());
        }

        sb.append("\nLocations En Cours: ");
        for(Location loc : locationsEnCours) {
            sb.append("\n").append(loc.toString());
        }

        sb.append("\nLocations Passés: ");
        for(Location loc : historiqueLocations) {
            sb.append("\n").append(loc.toString());
        }

        return sb.toString();
    }
}
