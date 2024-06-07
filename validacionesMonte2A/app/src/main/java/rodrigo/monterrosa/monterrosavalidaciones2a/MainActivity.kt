package rodrigo.monterrosa.monterrosavalidaciones2a

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1- Mandar a llamar a las cosas de la pantalla
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtClave = findViewById<EditText>(R.id.txtClave)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //2- Programar el botón

        btnAgregar.setOnClickListener {

            //Validamos que los campos no estan vacios
            if (txtNombre.text.isEmpty() || txtCorreo.text.isEmpty()
                || txtClave.text.isEmpty() || txtEdad.text.isEmpty()
                || txtDUI.text.isEmpty()) {

                Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show()


            }else{
                //Comprobar que solo ingrese numeros
                if (!txtEdad.text.matches("[0-9]+".toRegex())) {

                    Toast.makeText(this, "Hey maje ingresa números", Toast.LENGTH_SHORT).show()

                }else{

                    //Validar correo electronico
                    if (!txtCorreo.text.matches("[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+".toRegex())){

                        Toast.makeText(this, "Hey 0ton, ingresa un correo valido", Toast.LENGTH_SHORT).show()

                    }else {

                        //Validar que la contraseña tenga minimo 6 caracteres
                        if (txtClave.text.length < 6 ) {

                            Toast.makeText(this, "La contraseña debe tener 6 dijitos", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }
        }






    }
}