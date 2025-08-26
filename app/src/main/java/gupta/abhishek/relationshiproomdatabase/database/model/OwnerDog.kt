package gupta.abhishek.relationshiproomdatabase.database.model

import androidx.room.Embedded
import androidx.room.Relation

////OneToOne
//data class OwnerDog(
//    @Embedded
//    val owner: Owner,
//    @Relation(
//        parentColumn = "ownerId",
//        entityColumn = "dogOwnerId"
//    )
//    val dog: Dog
//)


//OneToMany
data class OwnerDog(
    @Embedded
    val owner: Owner,
    @Relation(
        parentColumn = "ownerId",
        entityColumn = "dogOwnerId"
    )
    val dog: List<Dog>? = null
)