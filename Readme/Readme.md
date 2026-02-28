README — TP2 Android 
 
1/Thème choisi:

L’application présente des recettes traditionnelles algériennes, organisées en deux catégories : salées et sucrées.
L’utilisateur peut consulter la liste des recettes, afficher les détails d’un plat, ajouter des favoris et changer le thème clair/sombre.

2/Étapes pour lancer le projet:

1. Cloner le dépôt GitHub :git clone https://github.com/HadjerAit/MonChefAlgerien.git
2. Ouvrir le projet dans Android Studio
3. Laisser Gradle synchroniser automatiquement
4. Lancer l’application sur un émulateur ou un appareil Android

3/Emplacement du switch clair/sombre:
Le bouton permettant de changer le thème se trouve dans la section supérieure de l’écran principal (ButtonsSection).
Il apparaît sous forme de bouton :🎨 Couleur

Ce bouton appelle la fonction onToggleColor() et modifie l’état isDark dans `Maincreen.kt, ce qui change la couleur du fond entre :
• mode clair (blanc)
• mode sombre (gris foncé)
Le changement est appliqué via :.background(if (isDark) Color(0xFF1E1E1E) else Color.White)
