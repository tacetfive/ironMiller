class ElementUnique {
    val title: String
    val titleShort: String
    val turn: Int
    var flip: Int
    var points: Double

}

class ElementSequence : ElementUnique {
    var previousElement: ?
    var nextElement: ?
    fun elementSequence() {
	var elemSeq: List<ElementUnique>
    }
    fun addElement(sequenceID: List<ElementUnique>) { // add element into existing sequence
	sequenceID.add()
    }
}

class ElementProgram : ElementSequence {
    var title: String
    var sum: Double
    fun elementProgram() {
	addElement()
    }
    fun addElement() { // add an unique element
	
    }

}

class Profile {
    var profileName: String
}


fun main {
    create/choose/open_recent profile
    user actions:
	if user press "add element" first time
	    call createProgram
	if user press "add element"
	    call addElement
	
    Program checks:
	are there duplicates in elementProgram;

