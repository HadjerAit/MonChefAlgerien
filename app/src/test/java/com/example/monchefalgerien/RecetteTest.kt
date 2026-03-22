package com.example.monchefalgerien

import com.example.monchefalgerien.data.local.Recette
import org.junit.Test
import org.junit.Assert.*

class RecetteTest {

    // test 1 : vérifier qu'une recette est bien créée
    @Test
    fun testCreationRecette() {
        val recette = Recette(
            title = "Couscous",
            imageRes = "couscous",
            ingredients = "semoule,carottes,viande",
            description = "Un plat algérien",
            categorie = "Salée"
        )
        assertEquals("Couscous", recette.title)
        assertEquals("Salée", recette.categorie)
        assertFalse(recette.isFavori)
    }

    // test 2 : vérifier le toggle favori
    @Test
    fun testToggleFavori() {
        val recette = Recette(
            title = "Makrout",
            imageRes = "makrout",
            ingredients = "semoule,dattes,miel",
            description = "Un dessert",
            categorie = "Sucrée"
        )
        val recetteFavori = recette.copy(isFavori = true)
        assertTrue(recetteFavori.isFavori)
    }

    // test 3 : vérifier le filtre par catégorie
    @Test
    fun testFiltreCategorie() {
        val liste = listOf(
            Recette(title = "Couscous", imageRes = "couscous", ingredients = "", description = "", categorie = "Salée"),
            Recette(title = "Makrout", imageRes = "makrout", ingredients = "", description = "", categorie = "Sucrée"),
            Recette(title = "Chorba", imageRes = "chorba", ingredients = "", description = "", categorie = "Salée")
        )
        val salees = liste.filter { it.categorie == "Salée" }
        assertEquals(2, salees.size)
    }

    // test 4 : vérifier la recherche par nom
    @Test
    fun testRechercheParNom() {
        val liste = listOf(
            Recette(title = "Couscous", imageRes = "couscous", ingredients = "", description = "", categorie = "Salée"),
            Recette(title = "Makrout", imageRes = "makrout", ingredients = "", description = "", categorie = "Sucrée"),
            Recette(title = "Chorba Frik", imageRes = "chorba", ingredients = "", description = "", categorie = "Salée")
        )
        val resultat = liste.filter { it.title.contains("cous", ignoreCase = true) }
        assertEquals(1, resultat.size)
        assertEquals("Couscous", resultat[0].title)
    }

    // test 5 : vérifier le filtre favoris
    @Test
    fun testFiltreFavoris() {
        val liste = listOf(
            Recette(title = "Couscous", imageRes = "couscous", ingredients = "", description = "", categorie = "Salée", isFavori = true),
            Recette(title = "Makrout", imageRes = "makrout", ingredients = "", description = "", categorie = "Sucrée", isFavori = false),
            Recette(title = "Zlabia", imageRes = "zlabia", ingredients = "", description = "", categorie = "Sucrée", isFavori = true)
        )
        val favoris = liste.filter { it.isFavori }
        assertEquals(2, favoris.size)
    }
}