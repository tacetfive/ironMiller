package com.github.

import kotlin.Double

open class ElementUnique (
    val elementID: Int, // ID must be unique inside what????
    val title: String,
    val titleShort: String,
    val flipPrefix: String,
    val turn: Int,
    var flip: Int,
    var difficulty: string, // may be a Set of strings (A B C D)
    var points: Double,
    var bonusPoints: Double? = 0,
    var isActive: Boolean = true,
    var isInSeq: Boolean = false, // is this element in sequence with previous?
    var isInBlock: Boolean = false, // is this element in sequences block with previous?
    var next: ElementUnique? = null,
) {
    set(flip) {
       // <<change difficulty and points>>
    }
    fun activateDeactivateElement(): Unit {
	if(isActive) { isActive = false }
	else { isActive = true }
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
            bonusPoints = 0.0
    }
}

class ElementProgram : ElementUnique {
    var title: String = "new program"
    var sum: Double
    private var head: ElementUnique? = null
    private var tail: ElementUnique? = null
    private var size = 0
    fun addAtHead(newElement: ElementUnique): Unit { // add an unique element
        if ( head == null ) {
	    head = newElement
	    size++
	}
	else {
	    if (tail == null) { 
		tail = head
	    }
	    newElement.next = head
	    head = newElement
	    size++
	}
    }
	fun addToIndex(newElement: ElementUnique): Unit {
		if
	}
    fun addAtTail(newElement: ElementUnique) { // add an unique element
        if ( tail == null ) {
	    head = newElement
	    size++
	}
	else {
	    head.prev = newElement
	    newElement.next = head
	    size++
	}
    }
    fun swap(source: ElementUnique, target: ElementUnique) {
        val tempPrev = source.prev
        val tempNext = source.next
	source.prev = target.prev  
	source.next = target.next
	target.prev = tempPrev
	target.next = tempNext
        source.countBonusPoints()
        target.countBonusPoints()
    }
    fun activateDeactivateSequence(seqStart): Unit {
        if (seqStart.isActive) { 
	    do {
		seqStart.isActive = false
		seqStart = seqStart.next
	    } while(seqStart.isInSeq == true)
	}
	else {
	    do {
		seqStart.isActive = true
		seqStart = seqStart.next
	    } while(seqStart.isInSeq == true)
	}
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
