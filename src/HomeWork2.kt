fun main() {
    val student1 = Students2("Kira")
    val mathLesson = Lessons("Math", arrayListOf(5,2,8,9,5,3,5,1,3,6,4))
    val performances = AcademicPerformance<Classes>()
    performances.average(student1, mathLesson)
    val a = 33 to "value"
    println(a)
}
abstract class Classes

class Students2(val name:String): Classes()

class Lessons(val nameLesson:String, val rating: ArrayList<Int>): Classes()

class AcademicPerformance<T:Classes>{
    fun average(st:T, les:T) {

        if (st is Students2 && les is Lessons){
            println("${st.name} is academic performance in ${les.nameLesson} is ${les.rating.average()}")
        }

    }
}

