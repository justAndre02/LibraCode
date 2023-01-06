package com.paipbook.app.modules.registerstep1.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityRegisterStep1Binding
import com.paipbook.app.modules.registerstep1.`data`.viewmodel.RegisterStep1VM
import com.paipbook.app.modules.registerstep2.ui.RegisterStep2Activity
import com.paipbook.app.modules.welcome.ui.WelcomeActivity
import kotlin.String
import kotlin.Unit

class RegisterStep1Activity :
    BaseActivity<ActivityRegisterStep1Binding>(R.layout.activity_register_step_1) {
  private val viewModel: RegisterStep1VM by viewModels<RegisterStep1VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.registerStep1VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageReply.setOnClickListener {
      val destIntent = WelcomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnNext.setOnClickListener {
      val destIntent = RegisterStep2Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "REGISTER_STEP1ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegisterStep1Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
