package com.paipbook.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityLoginBinding
import com.paipbook.app.modules.login.`data`.viewmodel.LoginVM
import com.paipbook.app.modules.pginainicial.ui.PGinaInicialActivity
import com.paipbook.app.modules.welcome.ui.WelcomeActivity
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
  private val viewModel: LoginVM by viewModels<LoginVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnLogInOne.setOnClickListener {
      val destIntent = PGinaInicialActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageReply.setOnClickListener {
      val destIntent = WelcomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "LOGIN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LoginActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
