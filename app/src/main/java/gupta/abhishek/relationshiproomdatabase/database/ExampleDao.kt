package gupta.abhishek.relationshiproomdatabase.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gupta.abhishek.relationshiproomdatabase.database.model.Dog
import gupta.abhishek.relationshiproomdatabase.database.model.Owner

import gupta.abhishek.relationshiproomdatabase.database.model.OwnerDog


@Dao
interface ExampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwner(owner: List<Owner>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(dog: List<Dog>)

    @Query("SELECT * FROM Owner")
    suspend fun getAllOwner(): List<Owner>

    @Query("SELECT * FROM Dog")
    suspend fun getAllDog(): List<Dog>

    @Query("SELECT * FROM Owner ")
    suspend fun getOwnerDogList(): List<OwnerDog>


}