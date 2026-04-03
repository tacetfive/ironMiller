package com.github.

import kotlin.Double

open class ElementUnique constructor(
    val elementID: Int // ID must be unique inside what????
    val title: String
    val titleShort: String
    val flip_prefix
    val turn: Int
    var flip: Int
    var difficulty: string // may be a Set of strings (A B C D)
    var points: Double
) {
    set(flip) {
        <<change difficulty and points>>
    }
}

class ElementSequence (
    val sequenceID
    var title: String
    var titleShort: String
    var elementSeq: MutableList<ElementUnique>(1) {  }
    var is_active: Boolean = true
) : ElementUnique {
    fun addElement(elementIndex: Int, addingElement: ElementUnique): Unit { // elementIndex: Int = (elementSeq.size() - 1),
	    this.elementSeq.add(elementIndex, addingElement)
        countBonusScore(bonusScore, elementSeq)
    }
    fun removeElement(elementIndex: Int): Unit { // add element into existing sequence
        this.elementSeq.removeAt(elementIndex)
        countBonusScore(bonusScore, elementSeq)
    }
    fun countBonusScore(elementSeq: List<ElementUnique>): Array<Double> {
        var bonusScore: Array<Double>(elementSeq.size() - 1)
        for (i in bonusScore) {
            bonusScore[i] = (elementSeq[i].points +
                             elementSeq[i + 1].points) / 2
        }
        return bonusScore
    }
    fun changeElementPosition(elementSeq: List<ElementUnique>,
                              indexCurrent: Int, indexTarget: Int): Unit {
        val temp = elementSeq[indexTarget]
        elementSeq[indexTarget] = elementSeq[indexCurrent]
        elementSeq[indexCurrent] = temp
        countBonusScore()
    }
    fun activateDeactivateSequence(): Unit {
        if (is_active) { is_active = false }
        if (!is_active) { is_active = true }
    }
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

class ElementProgram : ElementSequence {
    var title: String
    var sum: Double
    var elementProgram: MutableList<ElementSequence>
    constructor
    fun elementProgram() {
	addElement()
    }
    fun addElement() { // add an unique element
	
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

