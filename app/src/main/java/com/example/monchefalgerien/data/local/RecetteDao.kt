package com.example.monchefalgerien.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RecetteDao {
    @Query("SELECT * FROM recettes")
    fun getAll(): Flow<List<Recette>>

    @Query("SELECT * FROM recettes WHERE isFavori = 1")
    fun getFavoris(): Flow<List<Recette>>

    @Query("SELECT * FROM recettes WHERE title LIKE '%' || :query || '%'")
    fun search(query: String): Flow<List<Recette>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recette: Recette)

    @Update
    suspend fun update(recette: Recette)

    @Delete
    suspend fun delete(recette: Recette)
}