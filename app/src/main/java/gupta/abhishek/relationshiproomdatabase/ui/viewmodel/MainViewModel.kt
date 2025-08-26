package gupta.abhishek.relationshiproomdatabase.ui.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import gupta.abhishek.relationshiproomdatabase.common.OneToOneRelation
import gupta.abhishek.relationshiproomdatabase.database.ExampleDao
import gupta.abhishek.relationshiproomdatabase.database.model.OwnerDog
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.async
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val exampleDao: ExampleDao) : ViewModel() {


    val list = mutableStateOf<List<OwnerDog>>(emptyList<OwnerDog>())

    init {

        viewModelScope.launch(Dispatchers.IO) {

            async { exampleDao.insertOwner(OneToOneRelation.getOwnerList()) }.await()
            async { exampleDao.insertDog(OneToOneRelation.getDogList()) }.await()
            async { list.value = exampleDao.getOwnerDogList() }.await()


        }
    }


}