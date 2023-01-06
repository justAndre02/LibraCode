package com.paipbook.app.modules.salasdeestudo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivitySalasDeEstudoBinding
import com.paipbook.app.modules.salasdeestudo.`data`.viewmodel.SalasDeEstudoVM
import kotlin.String
import kotlin.Unit

class SalasDeEstudoActivity :
    BaseActivity<ActivitySalasDeEstudoBinding>(R.layout.activity_salas_de_estudo) {
  private val viewModel: SalasDeEstudoVM by viewModels<SalasDeEstudoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.salasDeEstudoVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SALAS_DE_ESTUDO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SalasDeEstudoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
