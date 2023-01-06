package com.paipbook.app.modules.registerstep2.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityRegisterStep2Binding
import com.paipbook.app.modules.pginainicial.ui.PGinaInicialActivity
import com.paipbook.app.modules.registerstep1.ui.RegisterStep1Activity
import com.paipbook.app.modules.registerstep2.`data`.viewmodel.RegisterStep2VM
import kotlin.String
import kotlin.Unit

class RegisterStep2Activity :
    BaseActivity<ActivityRegisterStep2Binding>(R.layout.activity_register_step_2) {
  private val viewModel: RegisterStep2VM by viewModels<RegisterStep2VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.registerStep2VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageReply.setOnClickListener {
      val destIntent = RegisterStep1Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnSignUp.setOnClickListener {
      val destIntent = PGinaInicialActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "REGISTER_STEP2ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegisterStep2Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
