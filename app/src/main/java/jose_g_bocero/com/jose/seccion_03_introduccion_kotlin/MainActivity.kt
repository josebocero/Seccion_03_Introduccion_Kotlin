package jose_g_bocero.com.jose.seccion_03_introduccion_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import others.ControlFlow
import others.Nullable
import others.Operators
import others.Variables

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Variables().showCases()
        Nullable() // Si llamamos al showCases tendremos NPE
        Operators().showCases()
        ControlFlow().showCases()
    }
}