package com.paipbook.app.modules.reserva1.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityReserva1Binding
import com.paipbook.app.modules.reserva1.`data`.viewmodel.Reserva1VM
import kotlin.String
import kotlin.Unit

class Reserva1Activity : BaseActivity<ActivityReserva1Binding>(R.layout.activity_reserva_1) {
  private val viewModel: Reserva1VM by viewModels<Reserva1VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.reserva1VM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "RESERVA1ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Reserva1Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
