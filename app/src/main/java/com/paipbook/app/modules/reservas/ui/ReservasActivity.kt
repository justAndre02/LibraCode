package com.paipbook.app.modules.reservas.ui

import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityReservasBinding
import com.paipbook.app.modules.reservas.`data`.viewmodel.ReservasVM
import kotlin.String
import kotlin.Unit

class ReservasActivity : BaseActivity<ActivityReservasBinding>(R.layout.activity_reservas) {
  private val viewModel: ReservasVM by viewModels<ReservasVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.reservasVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "RESERVAS_ACTIVITY"

  }
}
