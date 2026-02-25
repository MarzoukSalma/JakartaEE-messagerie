## JakartaEE-messagerie
Application web de messagerie développée en Java Servlet / JSP dans le cadre du TP1 du module Technologies Web JEE.
### Description
Chaque utilisateur peut consulter ses messages privés après authentification. Une page d'accueil publique affiche les messages visibles par tous.
### Technologies
Java Servlet / JSP
PostgreSQL
JSTL
WildFly
Maven
### Base de Données

Personne : stocke les utilisateurs (mot de passe haché en SHA-256)
Message : stocke les messages publics (idPersonne = 1) et privés
SGBD : PostgreSQL

### Fonctionnalités

Inscription avec hachage du mot de passe (SHA-256)
Connexion / Déconnexion avec gestion de session
Affichage des messages publics (sans connexion)
Affichage des messages privés (après connexion)
