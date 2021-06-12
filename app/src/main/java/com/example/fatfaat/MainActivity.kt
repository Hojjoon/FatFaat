package com.example.fatfaat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fatfaat.retrofit.InterfaceRetrofit
import com.example.fatfaat.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_login_dialog.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.map_view.*
import net.daum.mf.map.api.MapView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener, InterfaceLoginDialog {

    var loginData : LoginData? = null
    var retrofitClient : Retrofit? = null
    var interfaceRetrofit : InterfaceRetrofit? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofitClient = RetrofitClient.getRetrofitClient()
        interfaceRetrofit = retrofitClient!!.create(InterfaceRetrofit::class.java)

        main_btn_login.setOnClickListener(this)
        btn_kakao_login.setOnClickListener(this)
        btn_naver_login.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.main_btn_login ->{
                val loginDialog = LoginDialog(this,this)
                loginDialog.show()
            }
            R.id.btn_kakao_login ->{
                //setContentView(R.layout.layout_map_finder)
                setContentView(R.layout.map_view)

                val map = MapView(this)
                val mapViewContainer = map_view as ViewGroup

                mapViewContainer.addView(map)
                Toast.makeText(this,"API 호출 성공",Toast.LENGTH_SHORT).show()
            }
//            R.id.btn_naver_login ->{
//                val viewMapActivity = Intent(this, Map::class.java)
//                startActivity(viewMapActivity)
//            }
        }
    }

    override fun loginBtnClick(id : String, pw : String) {
        Toast.makeText(this, "로그인 버튼 클릭-> id:${id}, pw:${pw}",Toast.LENGTH_SHORT).show()
        interfaceRetrofit!!.loginRequest(id, pw).enqueue(object: Callback<LoginData>{
            override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
                loginData = response.body()
                var receivedCode = loginData?.code
                Toast.makeText(this@MainActivity, "API Call Succeed", Toast.LENGTH_SHORT).show()
                if(receivedCode == "1000"){
                    val intent = Intent(this@MainActivity, Map::class.java)
                    startActivity(intent)
                }
            }
            override fun onFailure(call: Call<LoginData>, t: Throwable) {
                Log.e("LOGIN",t.message)
                Toast.makeText(this@MainActivity, "API Call Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
