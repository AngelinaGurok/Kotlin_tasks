package constructors

fun main(){
    val tom = Person("Tom")
    println("name: ${tom.name}; age: ${tom.age}; company: ${tom.company}")

    val linda = Person("Linda", 25)
    println("name: ${linda.name}; age: ${linda.age}; company: ${linda.company}")

    val max = Person("Max", 32, "Andersen")
    println("name: ${max.name}; age: ${max.age}; company: ${max.company}")

    val will = Person(_name = "Will", _comp = "Company")
    println("name: ${will.name}; age: ${will.age}; company: ${will.company}")
}