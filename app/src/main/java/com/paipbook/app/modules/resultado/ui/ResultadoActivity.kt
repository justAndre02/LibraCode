package com.paipbook.app.modules.resultado.ui

import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityResultadoBinding
import com.paipbook.app.modules.reserva1.ui.Reserva1Activity
import com.paipbook.app.modules.reserva2.ui.Reserva2Activity
import com.paipbook.app.modules.resultado.`data`.viewmodel.ResultadoVM
import kotlin.String
import kotlin.Unit

class ResultadoActivity : BaseActivity<ActivityResultadoBinding>(R.layout.activity_resultado) {
  private val viewModel: ResultadoVM by viewModels<ResultadoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.resultadoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = Reserva1Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      // TODO please, add your navigation code here
      finish()
    }
    binding.btnAdicionarReserva.setOnClickListener {
      val destIntent = Reserva2Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "RESULTADO_ACTIVITY"

  }
}
