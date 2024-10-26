package trotinette;

public interface InterfaceTrotinette {
    void louer();

    /**
     * marque la trottinette comme disponible et met à jour l’autonomie en fonction de la distance parcourue.
     * @param kmparcouru distance parcouru en location
     */
    void retourner(double kmparcouru);
}
