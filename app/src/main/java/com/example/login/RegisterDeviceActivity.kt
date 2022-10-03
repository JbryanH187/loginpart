package com.example.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityRegisterDeviceBinding
import com.example.login.modelos.RequestRegisterDevice
import com.example.login.modelos.ResponseRegisterDevice
import com.example.login.utilities.Utilities
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Boolean.FALSE

class RegisterDeviceActivity : AppCompatActivity(){

    private lateinit var binding: ActivityRegisterDeviceBinding
    private val u: Utilities = Utilities()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_device)

        binding = ActivityRegisterDeviceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        var s:String? = null
        s = bundle!!.getString("imeiDevice","")
        val imeiToSend = s
        //val imeiDevice = intent.extras?.getString("imeiDevice")
        val messageNameEmpty =
            Toast.makeText(this, "Ingrese el nombre del dispositivo valido", Toast.LENGTH_SHORT)

        binding.registerDeviceButton.setOnClickListener {

            val deviceName = binding.deviceNameEditText.text.toString()
            if(deviceName.isEmpty()){

                messageNameEmpty.show()
                return@setOnClickListener
            }
            if (imeiToSend != null) {
                registerDeviceName(deviceName,imeiToSend)
            }
        }

    }

    private fun registerDeviceName(deviceName: String, imei: String) {

        val call: Call<ResponseRegisterDevice> = u.getApiConnect().getDeviceRegister(RequestRegisterDevice(deviceName,imei))

        call.enqueue(object: Callback<ResponseRegisterDevice> {
            override fun onResponse(
                call: Call<ResponseRegisterDevice>,
                response: Response<ResponseRegisterDevice>
            ) {

                val validationResultRegister = response.body()!!.resultRegisterDevice
                val validationMessageRegister = response.body()!!.messageRegisterDevice


                if(validationResultRegister != FALSE){

                    Toast.makeText(this@RegisterDeviceActivity, "Registro con exito, espere a ser activado", Toast.LENGTH_SHORT).show()

                }else{

                    Toast.makeText(this@RegisterDeviceActivity, "Registro no exitoso", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<ResponseRegisterDevice>, t: Throwable) {
                Toast.makeText(this@RegisterDeviceActivity, "Failed to Upload", Toast.LENGTH_SHORT).show()

            }
        })
    }
}