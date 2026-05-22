package com.github.tacetfive.ironmiller.core.domain.models

import com.github.tacetfive.ironmiller.core.domain.models.ElementUnique

class ElementProgram (
    var title: String = "new program",
    var head: ElementUnique? = null, // private????
    var tail: ElementUnique? = null,
    var size: Int = 0,
) {
    fun addAtHead(newElement: ElementUnique, ): Unit { // add unique element
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
    fun addAtTail(newElement: ElementUnique) { // add unique element
        if ( tail == null ) {
            tail = newElement
            head = newElement
            size++
        }
        else {
            tail!!.next = newElement
            tail = newElement
            size++
        }
    }
    fun getByIndex(index: Int): ElementUnique? {
        var result = head
        for (i in 0..<index) {
            result = result?.next
        }
        return result
    }
    fun addToIndex(newElement: ElementUnique, index: Int): Unit {
        var currentElement = getByIndex(index)
        newElement.next = currentElement!!.next
        currentElement.next = newElement
        size++
    }
    fun swap(source: Int, target: Int) {
        var sourceElement = getByIndex(source)
        var targetElement = getByIndex(target)
        val temp = sourceElement?.next
        sourceElement?.next = targetElement?.next
        targetElement?.next = temp
        calcSum()
    }
    fun activateDeactivateSequence(startIndex: Int): Unit {     // !!! what if element inside Seq is deactivated
        var tmp = getByIndex(startIndex)
        val flag = tmp!!.isInSeq
        while( tmp!!.isInSeq ) {
            tmp.isActive = !flag
            tmp = tmp.next
        }
        tmp.isActive = !flag
    }
    fun clearSeq(): Unit {
        var tmp: ElementUnique?
        while (head != null) {
            tmp = head
            head = tmp?.next
            tmp = null
            size--
        }
    }
    fun removeHead() {
        head = head?.next
        size--
    }
//    This version uses the scope function to decrement size only when head is not null, before moving head to next
//    fun removeHead() {
//        head = head?.also { size-- }?.next
//    }
    fun removeElement(index: Int) {
        val previousElement = getByIndex(index - 1)
        previousElement?.next = previousElement.next?.next
        size--
    }
    // optimization exercise: recalculate not a whole sum, but just changed fields
    fun calcSum(): Double {
        var sum: Double = 0.0
        var tmp = head
        while(tmp != null) {
            sum += tmp.points + tmp.bonusPoints
            tmp = tmp.next
        }
        return sum
    }
    fun countBonusPoints(index: Int): Double {
        var bonusPoints: Double
        val tmp = getByIndex(index-1)
        if ( tmp != null) {
            if ( tmp.next!!.isInSeq ) {
                bonusPoints = (tmp.points + tmp.next!!.points)
            }
            else bonusPoints = 0.0
        }
        else bonusPoints = 0.0
        return bonusPoints
    }
    fun cascadeSeq (index: Int): Unit { // add to sequence all elements from index to tail
        var tmp = getByIndex(index)
        if ( tmp != null ) {
            var prevPoints: Double = tmp.points
            tmp = tmp.next
            while (tmp != null) {
                tmp.bonusPoints = (prevPoints + tmp.points) / 2
                tmp.isInSeq = true
                prevPoints = tmp.points
                tmp = tmp.next
            }
        }
    }
    fun collapseSeq (index: Int): Unit {
        var tmp = getByIndex(index+1)
        while( tmp != null && tmp.isInSeq ) {
            tmp.isInSeq = false
            tmp.bonusPoints = 0.0
            tmp = tmp.next
        }
    }
    fun addToSeq(index: Int) {
        getByIndex(index)?.addToSeq()
        countBonusPoints(index)
    }
    fun rmFromSeq(index: Int) {
        getByIndex(index)?.rmFromSeq()
        countBonusPoints(index)
    }
    fun addToBlock(index: Int) {
        var previousSequenceStart: ElementUnique? = head
        var previousSequenceEnd: ElementUnique? = head
        var i = 0 // counter
        val current = getByIndex(index)
// go through linked list to find a previous sequence:
        while (true) {
//            if ( previousSequenceStart?.isInSeq == false ) { // condition is undue
            if ( previousSequenceEnd?.next?.isInSeq == true ) {
                previousSequenceEnd = previousSequenceEnd.next
                i++
            }
            else {
                previousSequenceStart = previousSequenceEnd?.next
                previousSequenceEnd = previousSequenceStart
                i++
            }
//            }
            if ( i >= index-1 ) break
        }
        if ( previousSequenceEnd == previousSequenceStart ) {
            current?.isInBlock = true
        }
        else { // is condition full????
            while (true) {
                previousSequenceStart = previousSequenceStart?.next
                previousSequenceStart?.isInBlock = true
                if ( previousSequenceStart == current) break
            }
        }
    }
    fun rmFromBlock(index: Int) {
             /*  */
    }
}