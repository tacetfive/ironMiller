package com.github.

import kotlin.Double

open class ElementUnique (
    val elementID: Int // ID must be unique inside what????
    val title: String
    val titleShort: String
    val flip_prefix: String
    val turn: Int
    var flip: Int
    var difficulty: string // may be a Set of strings (A B C D)
    var points: Double
    var bonusPoints: Double? = 0
    var isInSeq: Boolean = false // is this element in sequence with previous?
    var prev: ElementUnique? = null
    var next: ElementUnique? = null
) {
    set(flip) {
        <<change difficulty and points>>
    }
    fun addInSeq(): Unit { // add this element in Sequence with previous.
        if ( prev == null ) {
            // throw an error
        }
        else {
            isInSeq = true
            countBonusPoints()
        }
    }
    fun rmFromSeq(): Unit { // remove this element from Sequence with prev
        isInSeq = false
        countBonusPoints()
    }
    fun countBonusPoints(): Unit {
        if (isInSeq)
            bonusPoints = (this.points + this.prev.points) / 2
        else
            bonusPoints = 0.
    }
}

class ElementProgram : ElementUnique {
    var title: String
    var sum: Double
    var elementProgram: MutableList<ElementSequence>
    constructor
    fun addElement(newElement: ElementUnique) { // add an unique element
        if ()
    }
    fun swap()
    fun changeElementPosition(source: ElementUnique, target: ElementUnique) {
        val temp = source
        source = target
        target = temp
        source.countBonusPoints()
        target.countBonusPoints()
    }
    fun activateDeactivateSequence(): Unit {
        if (is_active) { is_active = false }
        if (!is_active) { is_active = true }
    }
}

class Profile {
    var profileName: String
    var profilePrograms: List<ElementProgram>
    constructor(profileName: String = "Kettlebell Juggler") {
        this.profileName = profileName
    }
    fun copyProgram(): Unit {
        var
    }
    set(profileName)
}


fun main {
//    create/choose/open_recent profile
//    user actions:
    var dataBase = "table.xml"
	if (true) { // user press "add element" first time
	    call createProgram
	if user press "add element"
	    call addElement
    Program checks:
	are there duplicates in elementProgram;


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
