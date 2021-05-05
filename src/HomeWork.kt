fun main() {
    val boy1 = Boys("Pavel")
    val boy2 = Boys("Andrey")
    val girl1 = Girls("Nastya")
    val girl2 = Girls("Kira")
    val boysRating = Rating<Boys>()
    val girlsRating = Rating<Girls>()
    val rating = Rating<Students>()

    boysRating.addScore(boy1, 5)
    boysRating.addScore(boy2, 4)
    girlsRating.addScore(girl1, 6)
    girlsRating.addScore(girl2, 7)
    boysRating.bestStudent().forEach{(key, item) -> println("The best " +
            "boy student is ${key.name}. Rating = $item")}
    girlsRating.bestStudent().forEach{(key, item) -> println("The best " +
            "girl student is ${key.name}. Rating = $item")}
    rating.addScore(boy1, 8)
    rating.addScore(boy2, 6)
    rating.addScore(girl1, 7)
    rating.addScore(girl2, 8)
    rating.bestStudent().forEach{(key, item) -> println("The best " +
            "student is ${key.name}. Rating = $item")}


}

abstract class Students (val name:String)

class Boys(name: String): Students(name)

class Girls(name: String): Students(name)



class Rating<T:Students>{
    private val scores = mutableMapOf<T, Int>()

    fun addScore(t:T, shore:Int = 0){

        if (shore >= 0)
            scores[t] = shore
    }

    fun bestStudent(): MutableMap<T, Int> {
        val score = scores.values.max()
        val theBests = mutableMapOf<T, Int>()
            scores.forEach{(key, item) ->
            if (item == score)
                theBests[key] = item
        }
        return theBests
    }

}

