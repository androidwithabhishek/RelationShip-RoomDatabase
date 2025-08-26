package gupta.abhishek.relationshiproomdatabase.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Owner(
    @PrimaryKey(autoGenerate = false)
    val ownerId: Int,
    val name: String
)
