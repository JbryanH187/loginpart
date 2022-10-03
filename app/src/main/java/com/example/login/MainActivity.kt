package com.example.login

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.login.databinding.ActivityMainBinding
import com.example.login.modelos.RequestLogin
import com.example.login.modelos.ResponseLogin
import com.example.login.utilities.Utilities
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Boolean.FALSE


class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 101
    private lateinit var binding: ActivityMainBinding
    private val u:Utilities = Utilities()
    private  lateinit var preferences: SharedPreferences
    private var editor: SharedPreferences.Editor? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // if permissions are not provided we are requesting for permissions.
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_PHONE_STATE), REQUEST_CODE)
        }

        preferences =
            applicationContext.getSharedPreferences("facePreferences", 0) // 0 - for private mode

        editor = preferences.edit()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.StartButtonId.setOnClickListener{

            try{
                val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val imei = telephonyManager.imei.toString()
                Toast.makeText(this, "IMEI number: $imei",
                    Toast.LENGTH_LONG).show()
                register(imei)
            }catch (ex:Exception){
                ex.message?.let { Log.e("", it) }
            }
            Log.d("MainActivity","Como que no inicia xD")

        }
    }

    private fun register(imeiToSend: String){

        val call: Call<ResponseLogin> = u.getApiConnect().getLogin(RequestLogin(imeiToSend))

       call.enqueue(object: Callback<ResponseLogin> {
            override fun onResponse(
                call: Call<ResponseLogin>,
                response: Response<ResponseLogin>
            ) {

                val validationResultLogin = response.body()!!.resultLogin!!
                val validationMessageLogin = response.body()!!.messageLogin!!
                val validationStatusLogin = response.body()!!.status
//                val bundle = Bundle()
//                bundle.putCharSequence("deviceImei", imeiToSend)
                val bundle = Bundle()

                if (validationResultLogin != FALSE){

                    if(validationStatusLogin == "A"){

                        bundle.putString("imeiDevice",imeiToSend)
                        val menuOptions = Intent(this@MainActivity,Menu2::class.java)
                        startActivity(menuOptions.putExtras(bundle))
                        editor?.putString("imeiDevice",imeiToSend)
                        }
                    else if(validationStatusLogin == "P"){
                        Toast.makeText(this@MainActivity, "El dispositivo esta en espera de ser activado", Toast.LENGTH_SHORT).show()
                    }

                }
                else{
                    bundle.putString("imeiDevice",imeiToSend)
                    val registerDevice = Intent(this@MainActivity,RegisterDeviceActivity::class.java)
                    startActivity(registerDevice.putExtras(bundle))
                    editor?.putString("imeiDevice",imeiToSend)
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to Upload", Toast.LENGTH_SHORT).show()
            }
        })
    }
}