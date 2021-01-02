# projet


Création d'une application android en utilisant Kotlin

L'application permet de créer des comptes aux utilisateurs et de les authentifier.
(Gestion des exceptions  (compte non existant, absence de mot passe, etc …)
Si l'authentification est réussie l'utilisateur peut accéder à une Api Rest.

L'api Rest contient les entreprises productrices de film,  l'accès à  l'Api ne se fait que par l'utilisation de l'ID des entreprises


Dans notre cas nous avons fait appel et ensuite affiché les elements de l'API par leur ID

Le lien pour acceder aux compagnies est:https://api.themoviedb.org/3/company/id?api_key=67a80710810611d36586dcc9328b2aa0

id doit etre remplacé par un entier 

architecture: MVVM
Langage: Kotlin
base de données :ROOM pour l'authentification et retrofit pour l'Api

Des modification ont été faites afin d'améliorer le design et d'afficher plusieurs élements de l'API au lieu d'un seul 

![image](https://user-images.githubusercontent.com/75430382/103449744-57139b80-4c8b-11eb-9053-32e586dc9b1b.png)

![image](https://user-images.githubusercontent.com/75430382/103449755-85917680-4c8b-11eb-86de-cef8de1a7659.png)


![image](https://user-images.githubusercontent.com/75430382/103449759-8de9b180-4c8b-11eb-8ece-8580b4c279c4.png)

![image](https://user-images.githubusercontent.com/75430382/103449761-9215cf00-4c8b-11eb-9f47-31a3e76f3496.png)

Accés aux infos des company


![image](https://user-images.githubusercontent.com/75430382/103449842-ad350e80-4c8c-11eb-954a-925da352b359.png)




