package com.github.tacetfive.ironmiller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.tacetfive.ironmiller.core.ui.theme.IronMillerTheme
import com.github.tacetfive.ironmiller.core.domain.models.ElementProgram
import com.github.tacetfive.ironmiller.core.domain.models.ElementUnique
import kotlin.Int

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IronMillerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IronMillerTheme {
        Greeting("Android")
    }
}

class Profile ( var profileName: String = "Kettlebell Juggler",
                val profilePrograms: MutableList<ElementProgram> = TODO(), // initialize with first element
) {
    fun addProgram(programName: String): Unit {
        profilePrograms.add(ElementProgram(title = programName))
    }
    fun removeProgram(programIndex: Int): Unit {
        profilePrograms.removeAt(programIndex)
    }
    fun copyProgram(programIndex: Int): Unit {
        profilePrograms.add(profilePrograms[programIndex])
    }
}

class Profiles() {
    val profiles: MutableList<Profile> = TODO()
    fun addProfile(name: String): Unit {
        profiles.add(Profile(profileName = name))
    }
    fun removeProfile(profileIndex: Int): Unit {
        profiles.removeAt(profileIndex)
    }
    fun copyProfile(profileIndex: Int): Unit {
        profiles.add(profiles[profileIndex])
    }
}


fun main(): Unit {
    var dataBase = "table.xml"
    var currentProfile = 0
    var currentProgram = 0
    val p: Profiles
    var index = 0
    p = Profiles()
    p.addProfile("Anton") // create new profile
    p.profiles[currentProfile].addProgram("Kettlebells in the Air 2026 spring")
    val c = p.profiles[currentProfile].profilePrograms[currentProgram]
    c.addAtHead(
        ElementUnique(
            title = "simple mill with turn 90",
            titleShort = "simple mill 90",
            flipPrefix = "×",
            turn = 90,
            )
    )
    c.addAtTail(
        ElementUnique(
            title = "simple lateral mill",
            points = 0.3,
            titleShort = "simple lat mill",
            flipPrefix = "×",
            turn = 0,
            flip = 2,
            difficulty = "B",
            )
    )
    c.addAtTail(
        ElementUnique(
            title = "simple lateral mill with turn 180",
            titleShort = "simple lat mill 180",
            flipPrefix = "×",
            turn = 180,
            )
    )
    c.addAtTail(
        ElementUnique(
            title = "simple lateral throw with turn 90",
            points = 0.3,
            titleShort = "simple lat throw 90",
            flipPrefix = "×",
            turn = 90,
            flip = 2,
            difficulty = "B",
            )
    )

}




//    Program checks:
//    are there duplicates in elementProgram;


/*
class ElementSequence : ElementUnique {
    val sequenceID
    var title: String
    var titleShort: String
    var elementSeq: MutableList<ElementUnique>(1) {  }
    var bonusScore: Array<Double>(elementSeq.size()) = countBonusScore(elementSeq)
    var is_active: Boolean = true
    constructor()
    fun sumPoints(): Double {
        var sum = 0.
        for (i in elementSeq) {
            sum += elementSeq[i].points
        }
        for (i in bonusScore) {
            sum += bonusScore[i]
        }
        return sum
    }
}
*/
