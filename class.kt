package com.github.

import kotlin.Double
import kotlin.plus

open class ElementUnique (
    val elementID: Int, // ID must be unique inside what????
    val title: String,
    val titleShort: String,
    val flipPrefix: String,
    val turn: Int,
    var flip: Int,
    var difficulty: string, // may be an enum of strings (A B C D)
    var points: Double,     // depends on flips
    var isActive: Boolean = true,
    var isInSeq: Boolean = false, // is next element in sequence with current?
    var isInBlock: Boolean = false, // is this element in sequences block with previous?
    var next: ElementUnique? = null,
) {
    fun activateDeactivateElement(): Unit { // checkbox function
        isActive = !isActive 
    }
// addIn and removeFrom are different functions because it will be on different buttons
    fun addToSeq(): Unit { // add next element in Sequence with current
        if ( next != null ) isInSeq = true
        else return
        countBonusPoints()
    }
    fun rmFromSeq(): Unit { // remove next element from Sequence with current
        isInSeq = false
        countBonusPoints()
    }
    fun bonusPoints(): Double {
        var result: Double = 0
        if (isInSeq)
            result = (points + next.points) / 2
        else
            result = 0
        return result
    }
}

class ElementProgram ( 
    var title: String = "new program"
    private var head: ElementUnique? = null
    private var tail: ElementUnique? = null
    private var size = 0 
) : ElementUnique {
    fun addAtHead(newElement: ElementUnique): Unit { // add an unique element
        if ( head == null ) {
            head = newElement
            tail = newElement
            size++
        }
        else {
            newElement.next = head
            head = newElement
            size++
        }
    }
    fun addAtTail(newElement: ElementUnique) { // add an unique element
        if ( tail == null ) {
            tail = newElement
            head = newElement
            size++
        }
        else {
            tail.next = newElement
            tail = newElement
            size++
        }
    }
    fun getByIndex(index: Int): ElementUnique {
        result = head
        for (i, i < index, i++) {
            result = result.next
        }
        return result
    }
    fun addToIndex(newElement: ElementUnique, index: Int): Unit {
        currentElement = getByIndex(index)
        newElement.next = currentElement.next
        currentElement.next = newElement
        size++
    }
    fun swap(source: Int, target: Int) {
        sourceElement = getByIndex(source)
        targetElement = getByIndex(target)
        temp = sourceElement.next
        sourceElement.next = targetElement.next
        targetElement.next = temp
        calcSum()
    }
    fun activateDeactivateSequence(startIndex: Int): Unit {     // !!! what if element inside Seq is deactivated
        var tmp = getByIndex(startIndex)
        val flag = tmp.isInSeq
        while( tmp.isInSeq == true ) {
            tmp.isActive = !flag
            tmp = tmp.next
        }
        tmp.isActive = !flag
    }
    fun clearSeq(): Unit {
        while (head != null) {
            tmp = head
            head = head.next
            tmp = null
            size--
        }
    }
    fun removeHead() {
        head = head.next
        size--
    }
    fun removeElement(index: Int) {
        val previousElement = getByIndex(index - 1)
        previousElement.next = previousElement.next.next
        size--
    }
    // optimization excersice: recalculate not a whole sum, but just changed fieds
    fun calcSum(): Double {
        var sum: Double = 0.0
        var tmp = head
        while(tmp != null) {
            sum = sum + tmp.points + tmp.bonusPoints()
            tmp = tmp.next
        }
        return sum
    }
    fun cascadeSeq (index: Int): Unit { // add to sequense all elements from index to tail
        var tmp = getByIndex(index)
        while(tmp != null) {
            tmp.isInSeq = true
            tmp = tmp.next // ?: return
        }
    }
    fun collapseSeq (index: Int): Unit {
        var tmp = getByIndex(index)
        while( tmp != null && tmp.isInSeq == true ) {
            seqFirstElement.isActive = !flag
            seqFirstElement = seqFirstElement.next
        }
    }
    fun addToSeq(index: Int) {
        getByIndex(index - 1).addInSeq()
    }
    fun rmFromSeq(index: Int) {
        getByIndex(index - 1).rmFromSeq()
    }
}

class Profile ( var profileName: String = "Kettlebell Juggler" ) {
    val profilePrograms: List<ElementProgram> // private????
    fun addProgram(programName: String): Unit {
        profilePrograms.add(ElementSequence(title = programName))
    }
    fun removeProgram(programIndex: Int): Unit {
        profilePrograms.removeAt(programIndex)
    }
    fun copyProgram(programIndex: Int): Unit {
        profilePrograms.add(profilePrograms[programIndex])
    }
}

class Profiles() {
    val profiles: List<Profile>
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
    var currentProfile: Int = 0
    var currentProgram: Int = 0
    val p: Profiles()
    var index: Int = 0
    p.profiles.addProfile("Anton") // create new profile
    p.profiles[currentProfile].addProgram("Kettlebells in the Air 2026 spring")
    val c = p.profiles[currentProfile].profilePrograms[currentProgram]
    c.addAtHead(
        title = ,
        points = ,
    )
    index = 3
    c.addToSeq(index)


    

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
