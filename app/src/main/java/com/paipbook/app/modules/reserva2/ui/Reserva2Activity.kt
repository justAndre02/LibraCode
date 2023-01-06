package com.paipbook.app.modules.reserva2.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityReserva2Binding
import com.paipbook.app.modules.pginainicial.ui.PGinaInicialActivity
import com.paipbook.app.modules.reserva2.`data`.viewmodel.Reserva2VM
import kotlin.String
import kotlin.Unit

class Reserva2Activity : BaseActivity<ActivityReserva2Binding>(R.layout.activity_reserva_2) {
  private val viewModel: Reserva2VM by viewModels<Reserva2VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.reserva2VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnFazerASuaReserva.setOnClickListener {
      val destIntent = PGinaInicialActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "RESERVA2ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Reserva2Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
