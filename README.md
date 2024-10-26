Voici un exemple d’exercice Java basé sur une situation de la vie réelle, mais un peu plus original : un **système de gestion de location de trottinettes électriques** en ville. Ce programme permettra de suivre les trottinettes, les utilisateurs et les locations en cours.

---

### Sujet : Système de Gestion de Location de Trottinettes Électriques

**Objectif :** Créer un programme Java permettant de gérer une flotte de trottinettes électriques, les utilisateurs inscrits au service et les locations de trottinettes. Le programme doit permettre :
- L’ajout de nouvelles trottinettes et de nouveaux utilisateurs.
- La location d’une trottinette par un utilisateur.
- Le retour d’une trottinette après utilisation.
- Le calcul de la distance parcourue et de la facturation.

---

### Classes à Implémenter

1. **Classe `Trottinette`**
    - Représente une trottinette électrique de la flotte.
    - Attributs :
        - `String id` : identifiant unique de la trottinette.
        - `double autonomie` : autonomie restante de la trottinette (en km).
        - `boolean estDisponible` : indique si la trottinette est disponible.
    - Méthodes :
        - `void louer()` : met la trottinette en état de location (change l’attribut `estDisponible`).
        - `void retourner(double kmParcourus)` : marque la trottinette comme disponible et met à jour l’autonomie en fonction de la distance parcourue.
        - `String toString()` : retourne les informations sur la trottinette.

2. **Classe `Utilisateur`**
    - Représente un utilisateur inscrit au service.
    - Attributs :
        - `String nom`
        - `int idUtilisateur` : identifiant unique de l’utilisateur.
        - `double solde` : le solde de l’utilisateur pour payer les locations.
    - Méthodes :
        - `void ajouterFonds(double montant)` : permet d’ajouter des fonds au solde de l’utilisateur.
        - `boolean payer(double montant)` : déduit le montant si le solde est suffisant ; sinon, retourne `false`.
        - `String toString()` : retourne les informations sur l’utilisateur.

3. **Classe `Location`**
    - Représente une location en cours ou terminée d’une trottinette par un utilisateur.
    - Attributs :
        - `Trottinette trottinette`
        - `Utilisateur utilisateur`
        - `double kmParcourus` : distance parcourue lors de la location.
        - `double tarif` : coût de la location par kilomètre.
    - Méthodes :
        - `double calculerCout()` : retourne le coût total de la location basé sur `kmParcourus * tarif`.
        - `String toString()` : retourne les informations de la location (id trottinette, utilisateur, coût total).

4. **Classe `ServiceLocation`**
    - Permet de gérer les trottinettes, les utilisateurs et les locations.
    - Attributs :
        - `ArrayList<Trottinette> trottinettes` : liste des trottinettes disponibles.
        - `ArrayList<Utilisateur> utilisateurs` : liste des utilisateurs inscrits.
        - `ArrayList<Location> locationsEnCours` : liste des locations en cours.
    - Méthodes :
        - `void ajouterTrottinette(Trottinette t)` : ajoute une trottinette à la flotte.
        - `void ajouterUtilisateur(Utilisateur u)` : inscrit un utilisateur.
        - `Location louerTrottinette(int idUtilisateur, String idTrottinette)` : permet à un utilisateur de louer une trottinette si elle est disponible et si son solde est suffisant.
        - `void retournerTrottinette(Location location, double kmParcourus)` : termine une location, met à jour l’autonomie de la trottinette, et facture l’utilisateur.

---

### Fonctionnalités Bonus

- **Géolocalisation des trottinettes** : ajouter des attributs `latitude` et `longitude` dans la classe `Trottinette` pour savoir où elle se trouve.
- **Suivi de la recharge** : si l’autonomie de la trottinette est inférieure à un certain seuil, marquer la trottinette comme nécessitant une recharge.
- **Historique des locations** : ajouter une liste `historiqueLocations` dans `Utilisateur` pour stocker les locations passées.

Cet exercice vous permet de travailler avec des concepts d’objets, de listes, et de gestion des états, tout en représentant un problème intéressant et concret de mobilité urbaine.