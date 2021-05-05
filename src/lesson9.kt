fun main() {
    val cat1 = Cat("cat1")
    val cat2 = Cat("cat2")
    val cat3 = Cat("cat2")
    val dog1 = Dog("dog1")
    val fish1 = Fish("fish1")
    val catVet = Vet<Cat>()
    val petVet = Vet<Pet>()
    val dogVet = Vet<Dog>()
    val fishVet = Vet<Fish>()
    val catContest = Contest<Cat>(catVet)
    val dogContest = Contest<Dog>(petVet)
    catContest.addScores(cat1, 2)
    catContest.addScores(cat2 ,1)
    catContest.addScores(cat3 ,2)
    val winners = catContest.getWinners()
    winners.forEach { println(it.name) }
    println("-----------------------")
    val petContest = Contest<Pet>(petVet)
    petContest.addScores(cat1, 10)
    petContest.addScores(cat2, 50)
    petContest.addScores(fish1, 50)
    petContest.getWinners().forEach { println(it.name) }

    println("------------task1-------------")
    val catOwner = PetOwner(cat1)
//    catOwner.add(fish1)
    catOwner.add(cat2)
    catOwner.pets.forEach{ println(it.name) }
    println("--------------------")
    catOwner.remove(cat2)
    catOwner.pets.forEach{ println(it.name) }
    println("--------------------")
    val fishOwner = PetOwner(fish1)
//    petOwner.add(cat1)
//    petOwner.add(cat2)
    fishOwner.pets.forEach{ println(it.name) }
    println("--------------------")
    val petOwner = PetOwner<Pet>(cat1)
    petOwner.add(fish1)
    petOwner.pets.forEach{ println(it.name) }
    println("--------------------")
    catVet.treat(cat1)
    dogVet.treat(dog1)
    fishVet.treat(fish1)
    catContest.vet.treat(cat2)
    println("--------------------")
    val catRetailer1:CatRetailer = CatRetailer()
    val catRetailer2 = CatRetailer()
    val dogRetailer1: Retailer<Dog> = DogRetailer()
    val petRetailer1:Retailer<Pet> = DogRetailer()

}

abstract class Pet(var name:String){

}

class Cat(name: String): Pet(name){

}

class Dog(name: String): Pet(name){

}

class Fish(name: String): Pet(name){

}

class Contest<T:Pet>(val vet: Vet<T>){
    val scores: MutableMap<T, Int> = mutableMapOf()

    fun addScores(t:T, score: Int = 0){
        if (score >= 0) scores[t] = score

    }

    fun getWinners(): MutableSet<T> {
        val highScore = scores.values.max()
        val winners: MutableSet<T> = mutableSetOf()
//        for ((t, score) in scores) {
//            if (score == highScore) winners.add(t)
//        }
        scores.forEach{
            if (it.value == highScore) winners.add(it.key)
        }
        return winners
    }


}

interface Retailer<out T>{
    fun sell(): T
}

class CatRetailer: Retailer<Cat>{
    override fun sell(): Cat {
        println("Sell cat")
        return Cat("")
    }
}
class DogRetailer: Retailer<Dog>{
    override fun sell(): Dog {
        println("Sell cat")
        return Dog("")
    }
}
class FishRetailer: Retailer<Fish>{
    override fun sell(): Fish {
        println("Sell cat")
        return Fish("")
    }
}

class Vet<in T:Pet>{
    fun treat(t:T) {
        println("Thret pet ${t.name}")
    }
}