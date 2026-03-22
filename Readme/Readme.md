# Mon Chef Algérien 🍽️

## Thème de l'application
Application de recettes algériennes.
L'utilisateur peut consulter des recettes salées et sucrées,
les ajouter aux favoris, en créer de nouvelles, les modifier ou les supprimer.

## Base de données
Room (locale) — base de données SQLite via Room

## Comment lancer le projet
1. Cloner le dépôt GitHub
2. Ouvrir le projet dans Android Studio
3. Lancer sur un émulateur ou un téléphone Android (API 26+)

## Structure du projet (MVVM)

- **DAO** : `app/src/main/java/com.example.monchefalgerien/data/local/RecetteDao.kt`
- **Entity** : `app/src/main/java/com.example.monchefalgerien/data/local/Recette.kt`
- **Database** : `app/src/main/java/com.example.monchefalgerien/data/local/RecetteDatabase.kt`
- **Repository** : `app/src/main/java/com.example.monchefalgerien/data/repository/RecetteRepository.kt`
- **ViewModel** : `app/src/main/java/com.example.monchefalgerien/viewmodel/RecetteViewModel.kt`
- **UI** : `app/src/main/java/com.example.monchefalgerien/ui/`

## DataStore
Fichier : `data/datastore/PreferencesDataStore.kt`

2 valeurs stockées :
- `dark_theme` : thème sombre ou clair (impact sur l'UI : couleur du fond et du texte)
- `show_favoris_only` : filtre pour afficher seulement les favoris (impact sur la liste affichée)

## Requête unique
Recherche par nom de recette via la barre de recherche (méthode `search()` dans le DAO)

## Comment lancer les tests
1. Ouvrir le fichier `app/src/test/java/com/example/monchefalgerien/RecetteTest.kt`
2. Clic droit sur le fichier
3. Cliquer sur **Run 'RecetteTest'**

5 tests unitaires :
- `testCreationRecette` : vérifier qu'une recette est bien créée
- `testToggleFavori` : vérifier le toggle favori
- `testFiltreCategorie