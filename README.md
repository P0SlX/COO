# Déroulement du jeu
Le jeu est divisé en plusieurs parties :
- Création du personnage
- Menu principal
- Inventaire
- Donjon
- Marchand

## Création du personnage
Afin de pouvoir jouer au jeu, il vous faudra rentrer le nom de votre héros, ainsi que sa classe.

Chaque classe possède des caractéristiques différentes, comme les armes et armures sur le héros par défaut ainsi que des dégâts plus ou moins important.

## Menu principal
Vous allez ensuite être redirigé vers le menu principal où vous aurez un récapitulatif de votre personnage.

Il vous sera demandé de faire un choix parmi :
- Afficher l'inventaire pour changer d'équipement ou consommer de la nourriture ou une potion.
- Rentrer dans le donjon pour combattre les monstres et gagner de l'argent/expérience.
- Aller chez le marchand pour acheter des équipements ou des consommables
- Quitter le jeu

## Inventaire
Lors de l'affichage de l'inventaire, il y aura toujours un récapitulatif de votre personnage et de son équipement actuel.

Si votre inventaire est vide alors vous serez redirigé vers le menu précédent.

Une liste de vos équipements ainsi que de vos consommables sera affiché et un choix parmi 5 options vous sera demandé.
Vous pourrez :
- Équiper un équipement (retirer un équipement de votre inventaire pour l'équiper sur votre héros)
- Utiliser un consommable (Ex : manger une pomme)
- Jeter un équipement
- Jeter un consommable
- Quitter l'inventaire

## Donjon
Enfin la partie intéressante ! Pour taper sur des montres, il faut rentrer dans le fameux donjon **444 nuits**.

Lors d'un combat, vous aurez à chaque tour un résumé de votre héros pour voir combien de points de vie, d'argent et de niveau que vous avez.

Les PNJ dans la pièce seront affichés à chaque tour avec leur niveau de vie ainsi que leur type et leur nom.
À chaque tour, vous pourrez attaquer un PNJ, pensez à tuer ceux qui font le plus mal en premier afin de survivre le plus longtemps possible !

À chaque PNJ tué, vous gagnez un peu d'argent et un peu d'expérience. Une fois tous les PNJ tués, vous gagnez en bonus de l'argent et de l'expérience.
Une fois la salle finie, vous pouvez choisir de continuer dans la pièce suivante et de prendre un peu de repos en prenant un petit encas ou en changeant votre équipement.

Il est aussi possible de quitter le donjon, mais toute votre progression sera perdue.

## Marchand

Afin de pouvoir survivre en période difficile, il vous faudra à manger, des protections pour réduire les dégâts, mais surtout des armes surpuissantes !
Eh bien, vous trouverez tout ça chez le marchand.

Les éléments en ventes sont organisés par catégories :
- Armes
- Protections
- Nourriture
- Potions

Et disposé en liste comme dans l'inventaire :
```text
Protections :
| (1) Casque en acier (0.5x) | (2) Casque en fer (0.7x) | (3) Casque en cuir (0.9x) |
| (4) Armure en acier (0.5x) | (5) Armure en fer (0.7x) | (6) Armure en cuir (0.9x) |
| (7) Bottes en acier (0.5x) | (8) Bottes en fer (0.7x) | (9) Bottes en cuir (0.9x) |
```

Il vous sera demandé de choisir la catégorie que vous voulez ainsi que le numéro de l'article que vous souhaitez acheter.
Une fois acheté, votre article ira directement dans votre inventaire, prêt pour le prochain combat !
