package com.thomasceballos.sesion2gui

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registro.*
import java.text.SimpleDateFormat
import java.util.*

class RegistroActivity : AppCompatActivity() {
    
    private lateinit var fecha: String
    private var cal = Calendar.getInstance()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val format = "MM/dd/yyyy"
                val simpleDateFormat = SimpleDateFormat(format, Locale.US)
                fecha = simpleDateFormat.format(cal.time).toString()
                tv_fecha_de_nacimiento.text = fecha
            }

        bt_calendario.setOnClickListener {
            DatePickerDialog(this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
            
        bt_guardar.setOnClickListener{
            val nombre = et_nombre.text.toString()
            val cedula = et_cedula.text.toString()
            val correo = et_correo.text.toString()
            val contrasena = et_contrasena.text.toString()
            val rep_contrasena = et_repita_contrasena.text.toString()
            val genero = if (rb_masculino.isChecked) "Masculino" else "Femenimo"
            var pasatiempos = ""
            val ciudadNacimiento = sp_ciudad_nacimiento.selectedItem.toString()

            if (ch_cine.isChecked) pasatiempos = "$pasatiempos cine"
            if (ch_play.isChecked) pasatiempos = "$pasatiempos PS4"
            if (ch_play.isChecked) pasatiempos = "$pasatiempos series"
            
            if (contrasena == rep_contrasena ) {
                tv_resultados.text = "Nombre:  $nombre \nCédula: $cedula" +
                        " \nCorreo: $correo \nPasatiempos: $pasatiempos " +
                        "\nCiudad de Nacimiento: $ciudadNacimiento" +
                        "\nFecha de Nacimiento: $fecha " +
                        "\nGénero: $genero"
            } else{
                tv_resultados.text = getString(R.string.no_iguales)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_actividad2){
            Log.d("Menu", "presionando el menu 1")
            val intent = Intent()
            intent.putExtra("nombre", et_nombre.text.toString())
            intent.putExtra("cedula", et_cedula.text.toString().toLong())
            setResult(Activity.RESULT_OK, intent)
            finish()
        } else{
            Log.d("Menu", "presionando el menu 2")
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onStart(){
        super.onStart()
        Log.d("OnStart", "ok")
    }

    override fun onResume(){
        super.onResume()
        Log.d("OnResume", "ok")
    }

    override fun onPause(){
        super.onPause()
        Log.d("OnPause", "ok")
    }

    override fun onStop(){
        super.onStop()
        Log.d("OnStop", "ok")
    }

    override fun onRestart(){
        super.onRestart()
        Log.d("OnRestart", "ok")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("OnDestroy", "ok")
    }
}