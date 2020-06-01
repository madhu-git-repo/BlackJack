
class card(val pip:Int,val suit:Char,val face:String=""){
}
/**
 * deck is function to create deck of cards and returns the same
 * deck contains four suits C,S,D,H
 * Each face card King,Queen and Jack pip value is 10
 * Ace pip value is 11
 */
fun deck(): Set<card>{
    val deckOfCards = mutableSetOf<card>()
    val arrayOfSuit = arrayListOf('C','S','D','H')
    val faceCards = arrayListOf<String>("King","Queen","Jack","Ace")
    //Iterate through each suite and crate card from 2 to 10 and add to deck
    for(suit in arrayOfSuit){
        for(value in 2..10){
            deckOfCards.add(card(value,suit))
        }
    }
    //Iterate through each suite and crate card for each face card and Ace and add to deck
    for(suit in arrayOfSuit){
        for(face in faceCards){
            deckOfCards.add (if(face == "Ace") card(11,suit,face) else card(10,suit,face))
        }
    }
    //Print total size of the deck to check all cards created
    println("This size of the deck is ${deckOfCards.size}")
    return deckOfCards
}

/**
 * getCards return random card from given set of deck.
 */
fun getCard(deckOfCards:Set<card>):card{
  return deckOfCards.random()
}
fun main(){
    val deckOfCards=deck()
    if(!deckOfCards.isNullOrEmpty()){
        val firstCard:card = deckOfCards.random()
        deckOfCards.minus(firstCard)
        val secondCard: card = deckOfCards.random()
        val totalInHand = firstCard.pip+secondCard.pip

        println("Your hand was:")
        if(!(firstCard.face == "")) println("${firstCard.face}: ${firstCard.suit}") else println("${firstCard.pip}: ${firstCard.suit}")
        if(!(secondCard.face == "")) println("${secondCard.face}: ${secondCard.suit}") else println("${secondCard.pip}: ${secondCard.suit}")
        println("For a total of: ${totalInHand}")
        if(totalInHand == 21) println("You Win!") else println("You Lose!")
    }
}