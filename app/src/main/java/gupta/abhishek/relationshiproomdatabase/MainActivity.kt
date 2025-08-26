package gupta.abhishek.relationshiproomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import gupta.abhishek.relationshiproomdatabase.ui.viewmodel.MainViewModel
import gupta.abhishek.relationshiproomdatabase.ui.theme.RelationshipRoomDatabaseTheme
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel by viewModels()
            RelationshipRoomDatabaseTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->

                    MainScreen( modifier = Modifier.padding(innerPadding),viewModel = viewModel)
                }
            }
        }
    }
}


@Composable
fun MainScreen(modifier: Modifier , viewModel: MainViewModel) {
    val list = viewModel.list.value
    LazyColumn {
        items(list) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp), verticalArrangement = Arrangement.Center
            ) {
                Text(text = "OwnerName : ${it.owner.name} ")

                it.dog?.forEach {
                    Text(text = "DogName : ${it.name} -- DogId: ${it.dogId}")

                }


            }
        }
    }

}