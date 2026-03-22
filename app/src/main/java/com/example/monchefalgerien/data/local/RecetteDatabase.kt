package com.example.monchefalgerien.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Recette::class], version = 1)
abstract class RecetteDatabase : RoomDatabase() {
    abstract fun recetteDao(): RecetteDao

    companion object {
        @Volatile private var INSTANCE: RecetteDatabase? = null

        fun getInstance(context: Context): RecetteDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    RecetteDatabase::class.java,
                    "recettes.db"
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            INSTANCE?.let { database ->
                                CoroutineScope(Dispatchers.IO).launch {
                                    prePopulate(database.recetteDao())
                                }
                            }
                        }
                    })
                    .build().also { INSTANCE = it }
            }
        }

        private suspend fun prePopulate(dao: RecetteDao) {
            val recettes = listOf(
                Recette(title = "Couscous", imageRes = "couscous",
                    ingredients = "500g de semoule,2 carottes,2 courgettes,1 oignon,Pois chiches,Viande,Épices",
                    description = "Le couscous est un plat emblématique de la cuisine algérienne.",
                    categorie = "Salée"),
                Recette(title = "Chakhchoukha", imageRes = "chakhchoukha",
                    ingredients = "Pâte traditionnelle,2 tomates,1 oignon,Ail,Pois chiches,Épices",
                    description = "La chakhchoukha est un plat généreux composé de pâtes traditionnelles.",
                    categorie = "Salée"),
                Recette(title = "Rechta", imageRes = "rechta",
                    ingredients = "Pâtes fines maison,Poulet,Pois chiches,Oignon,Cannelle,Beurre,Bouillon",
                    description = "La rechta est un plat traditionnel algérois.",
                    categorie = "Salée"),
                Recette(title = "Mhadjeb", imageRes = "mhadjeb",
                    ingredients = "Semoule fine,Farine,Eau,Sel,Tomates,Oignons,Piments",
                    description = "Les mhadjeb sont des crêpes feuilletées farcies.",
                    categorie = "Salée"),
                Recette(title = "Chorba Frik", imageRes = "chorba_frik",
                    ingredients = "Viande,Frik,Tomates,Oignon,Pois chiches,Coriandre,Épices",
                    description = "La chorba frik est une soupe traditionnelle algérienne.",
                    categorie = "Salée"),
                Recette(title = "Tajine Zitoun", imageRes = "tajine_zitoun",
                    ingredients = "Poulet,Olives vertes,Carottes,Citron,Ail,Épices",
                    description = "Le tajine zitoun est un plat mijoté aux olives vertes.",
                    categorie = "Salée"),
                Recette(title = "Kalb el Louz", imageRes = "kalb_el_louz",
                    ingredients = "Semoule,Sucre,Beurre,Eau de fleur d'oranger,Miel",
                    description = "Kalb el louz est un gâteau moelleux imbibé de miel.",
                    categorie = "Sucrée"),
                Recette(title = "Makrout", imageRes = "makrout",
                    ingredients = "Semoule moyenne,Pâte de dattes,Beurre fondu,Huile,Miel",
                    description = "Le makrout est un classique de la pâtisserie algérienne.",
                    categorie = "Sucrée"),
                Recette(title = "Zlabia", imageRes = "zlabia",
                    ingredients = "Farine,Maïzena,Eau,Levure,Miel",
                    description = "La zlabia est une pâtisserie frite en forme de spirale.",
                    categorie = "Sucrée"),
                Recette(title = "Tamina", imageRes = "tamina",
                    ingredients = "Semoule grillée,Beurre,Miel",
                    description = "La tamina est un dessert simple et réconfortant.",
                    categorie = "Sucrée"),
                Recette(title = "Baklawa", imageRes = "baklawa",
                    ingredients = "Feuilles de pâte,Amandes,Beurre,Miel",
                    description = "La baklawa est une pâtisserie feuilletée garnie d'amandes.",
                    categorie = "Sucrée"),
                Recette(title = "Griwech", imageRes = "griwach",
                    ingredients = "Farine,Beurre,Œufs,Sésame,Miel",
                    description = "Le griwech est une torsade croustillante enrobée de miel.",
                    categorie = "Sucrée")
            )
            recettes.forEach { dao.insert(it) }
        }
    }
}