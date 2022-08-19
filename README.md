# Application exemple d'une architecture événementielle

Cette application exemple sert à démontrer la pertinence d'une architecture de type événementielle dans laquelle chaque brique métier va émettre des événements métier et en écouter.

Le contexte métier présenté : les applications de rencontre pour développeurs.

L'application permet :

* de s'inscrire via un login
* de liker (ou pas) un autre login inscrit sur la plateforme
  * chaque like génère un match partiel
  * quand deux matchs partiels se rencontrent, cela crée un match complet
* d'être notifié quand on obtient un match complet
* de consulter le résultat de ses matchs

![image](https://user-images.githubusercontent.com/51753/185647435-0d2dae5a-e6aa-410e-888c-e1ebc66f4b7b.png)
