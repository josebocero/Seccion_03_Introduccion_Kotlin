package others

import android.util.Log

// DOC: #https://kotlinlang.org/docs/reference/classes.html
// DOC: #https://kotlinlang.org/docs/reference/properties.html
// DOC: #https://kotlinlang.org/docs/reference/data-classes-html
// DOC: #https://kotlinlang.org/docs/reference/enum-classes.html
// DOC: #https://kotlinlang.org/docs/reference/object-declarations.html

// Clases son públicas y final por defecto
// Si queremos que una clse se pueda ser heredada, usaremos open (open class xxx)

class Classes {
    private fun showCase1() {
        // Clases en kotlin puede tener un constructor PRIMARIO y uno o más constructorees SECUNDARIOS.
        // PRIMARIO se encuentra en la firma de la declaración de la clase.
        // SECUNDARIO se encuentra dentro de la declaracióm de la clase.

        // CONSTRUCTORES PRIMARIOS
        class Person1
        class Person2 constructor(var firstName: String) // constructor PRIMARIO
        class Person3 (var firstName: String) // "contructor" puede ser omitido
        class Person4 (val firstName: String, val lastName: String, var age: Int){
            init {
                age = 10
            }
        }

        class Person5 (val firstName: String = "Alejandro", val lastName: String = "Lora", var age: Int = 27)

        // Para crear instancias de objetos, no usamos la palabra "new"
        val p1 = Person1()
        val p2 = Person2("Alejandro")
        val p3 = Person3("Alejandro")
        val p4 = Person4("Alejandro","Lora", 27)
        val p5_1 = Person5("Roberto","Perez",50)
        val p5_2 = Person5()
        val p5_3 = Person5("Roberto")
        val p5_4 = Person5(age = 50)
    }

    private fun showCase2() {
        // Clases en kotlin pueden tener un constructor PRIMARIO y uno o más constructores SECUNDARIOS.
        // PRIMARIO se encuentra en la firma de la declaración de la clase.
        // SECUNDARIO se encuentra dentro de la declaracióm de la clasee.

        // CONSTRUCTORES SECUNDARIOS (son menos usados en kotlin)
        open class Person {
            constructor(firstName: String, lastName: String) {
                Log.w("CLASSES-2", "Welcome $firstName $lastName!")
            }
        }

        class Person1 : Person {
            constructor(firstName: String) : super(firstName, "Lora")
            constructor(firstName: String, lastName : String) : super(firstName, lastName)
        }

        val p = Person1("Alejandro", "Lora")
        // No tenemos acceso a person.firstName, ver showCase numero 5
    }

    private fun showCase3() {
        // Diferencia entre INIT Y CONSTRUCTOR secundario

        class Person1 {

             // Init se va a ejecutar antes que el constructor secundario y después que el constructor primario
            init {
                 Log.w("CLASSES-3", "Welcome from INIT!") // No puede acceder a firstName o lastName
             }

            constructor(firstName: String, lastName: String) {
                Log.w("CLASSES-3", "Welcome from SECONDARY CONSTRUCTOR!")
            }
        }

        class Person2 (firstName: String, lastName: String){

            init {
                // Aquí si podemos acceder a las propiedades, conservando init y constructor secundario
            }
            constructor() : this("Alejandro","Lora")
        }

        val p1 = Person1("Alejandro", "Lora")
        val p2 = Person2("Roberto", "Perez")
        val p3 = Person2() // Alejandro Lora
    }

    private fun showCase4() {
        // ¿VAL, VAR O NADA EN EL CONSTRUCTOR?
        class Person1(firstName: String) // No puedees acceder a firstName cuando crees la instancia
        class Person2(var firstName: String) // Puedes acceder a firstName cuando crees la instancia. Puedes cambiar su valor
        class Person3(val firstName: String) // Puedes acceder a firstName cuando crees la instancia. No puedes cambiar su valor

        val p1 = Person1("")
        val p2 = Person2("")
        val p3 = Person3("")

        // p1.fistName // Error
        p2.firstName = ""
        p3.firstName
    }

    private fun showCase5() {
        // PROPIEDADES - GETTERS & SETTERS

        class Person1(var firstName: String)

        val p1 = Person1("Alejandro")
        p1.firstName // Sería el equivalente a getFirstName()
        p1.firstName = "Antonio" // Sería el equivalente a setFirstName("Antonio!)

        class Person2 {
            // field - representa a la propiedad, nunca usar this.propiedad
            var firstName: String
                get() = field.capitalize()
            set(value) {
                field = value.capitalize()
            }
            constructor(firstName: String, lastName: String) {
                this.firstName = firstName
            }
        }

    }

    fun showCaseS() {
        showCase1()
        showCase2()
        showCase3()
        showCase4()
    }
}