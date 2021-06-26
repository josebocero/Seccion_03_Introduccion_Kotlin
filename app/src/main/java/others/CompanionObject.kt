package others

import android.util.Log

// DOC: #https://kotling.org/docs/reference/object-declaration.html#companion-object

class CompanionObject {
    private fun showCase1() {
        // Normal Companion Object
        val value = MyClass1.flag
        MyClass1.welcome()
    }

    private fun showCase2() {
        // Implementando Interfaz en Companion Object
        MyClass2.welcome()
    }

    fun showCasees() {
        showCase1()
        showCase2()
    }
}

class MyClass1 {
    companion object {
        val flag = 1

        fun welcome() {
            Log.w("COMPANION-OBJECT-1", "Welcome from Companion Object")
        }
    }
}

class MyClass2 {
    companion object: Welcome {
        override fun welcome() {
            Log.w("COMPANION-OBJECT-2", "Welcome from Companion Object + Interface!")
        }

    }
}

interface Welcome {
    fun welcome()
}