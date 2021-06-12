package com.example.fatfaat

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_dialog.*

class LoginDialog(context: Context, interfaceLoginDialog: InterfaceLoginDialog) : Dialog(context) {

    var interfaceLoginDialog : InterfaceLoginDialog? = null

    init {
        this.interfaceLoginDialog = interfaceLoginDialog
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_dialog)

        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog_btn_login.setOnClickListener {
            val id = enter_ID.text
            val pw = enter_PW.text

            this.interfaceLoginDialog?.loginBtnClick(id.toString(), pw.toString())
        }
    }
}