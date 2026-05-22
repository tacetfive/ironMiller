package com.github.tacetfive.ironmiller.core.domain.models

open class ElementUnique (
    val elementID: Int = 0, // ID must be unique inside what????
    val title: String,
    val titleShort: String,
    val flipPrefix: String,
    val turn: Int = 1,
    var flip: Int = 1,
    var difficulty: String = "A", // may be an enum of strings (A B C D)
    var points: Double = 0.2,     // depends on flips
    var bonusPoints: Double = 0.0,
    var isActive: Boolean = true,
    var isInSeq: Boolean = false, // is this element in sequence with previous?
    var isInBlock: Boolean = false, // is this element in block with previous?
    var next: ElementUnique? = null,
) {
    fun activateDeactivateElement(): Unit { // checkbox function
        isActive = !isActive
    }
    // addIn and removeFrom are different functions because it will be on different buttons
    fun addToSeq(): Unit { // add next element in Sequence with current
        isInSeq = true
    }
    fun rmFromSeq(): Unit { // remove next element from Sequence with current
        isInSeq = false
    }
}