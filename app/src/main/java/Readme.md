Création d'une application android en utilisant Kotlin

L'application permet d'enregistrer un utilisateur et de l'authentifier

Après authentification réussie l'utilisateur accède à un élément de l'api rest l'accès se fait par Id à partir de l'application ApiActivity

L'api contient les compagnies productrices de film, mais l'accès aux élément de cette Api ne se fait que par id et donc l'affichage de liste n'est pas possible
par contre nous affichons les caractéristiques de chaque compagnie après spécification de son ID dans ApiActivity


dans notre cas nous avons accédé à l'élément ayant l'id 64



l'architecture utilisée MVVM
Langage Kotlin
base de données :ROOM pour l'authentification et retrofit pour l'Api
