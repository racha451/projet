# projet


Création d'une application android en utilisant Kotlin

L'application permet de créer des comptes aux utilisateurs et de les authentifier
Si l'authentification est réussie l'utilisateur peut accéder à une Api Rest 

L'api Rest contient les compagnies productrices de film, mais l'accès aux élément de cette Api ne se fait que par id,donc l'affichage de liste n'est pas possible
par contre nous affichons les caractéristiques de chaque compagnie après spécification de son ID dans la classe ApiActivity


dans notre cas nous avons accédé à la compagnie ayant l'id 64



architecture utilisée: MVVM
Langage: Kotlin
base de données :ROOM pour l'authentification et retrofit pour l'Api
