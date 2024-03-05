package be.kiliannuytten.poperinge_screen_designs.ui.viewmodels

import androidx.lifecycle.ViewModel
import be.kiliannuytten.poperinge_screen_designs.data.mockup.Spoken
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import be.kiliannuytten.poperinge_screen_designs.data.models.Spook

class CollectionViewModel(): ViewModel() {
    private var spookState by mutableStateOf<Spook?>(null)
    fun updateSpookState (s: Spook){
        spookState = s;
    }
    fun getSpook() : Spook? {
        return spookState;
    }

    var spoken = Spoken.getSpoken()
}