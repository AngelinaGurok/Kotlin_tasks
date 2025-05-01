package constructors

class Person(_name: String) {
    val name: String
    var age: Int
    var company: String

    init{
        name = _name
        age = 0
        company = "undefined"
    }

    constructor(_name: String, _age: Int): this(_name){
        age = _age
    }

    constructor(_name: String, _comp: String): this(_name){
       company = _comp
    }

    constructor(_name: String, _age: Int, _comp: String): this(_name, _age){
        company = _comp
    }
}