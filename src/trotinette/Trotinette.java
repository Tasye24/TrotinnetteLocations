package trotinette;

public class Trotinette implements InterfaceTrotinette {
    private String id;
    /**
     * Autonomie en km de la trotinette
     */
    private double autonomie;
    private boolean estDisponible;

    public Trotinette(String id, double autonomie, boolean estDisponible) {
        this.id = id;
        this.autonomie = autonomie;
        this.estDisponible = estDisponible;
    }

    // #GETTERS
    public String getId() {
        return id;
    }
    public double getAutonomie() {
        return autonomie;
    }
    public boolean isDisponible() {
        return estDisponible;
    }

    // SETTERS
    public void setAutonomie(double autonomie) {
        this.autonomie = autonomie;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    @Override
    public void louer() {
        setEstDisponible(false);
    }

    @Override
    public void retourner(double kmparcouru) {
        setAutonomie(autonomie - kmparcouru);
        setEstDisponible(true);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb
                .append("Trotinette:")
                .append("\n\tid: ")
                .append(getId())
                .append("\n\tautonomie: ")
                .append(getAutonomie())
                .append("\n\tdispo? ")
                .append(isDisponible());
        return sb.toString();
    }
}
