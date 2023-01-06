package com.paipbook.app.modules.livrosrecomendados.ui

import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityLivrosRecomendadosBinding
import com.paipbook.app.modules.disciplinaaestudar.ui.DisciplinaAEstudarActivity
import com.paipbook.app.modules.livrosrecomendados.`data`.viewmodel.LivrosRecomendadosVM
import kotlin.String
import kotlin.Unit

class LivrosRecomendadosActivity :
    BaseActivity<ActivityLivrosRecomendadosBinding>(R.layout.activity_livros_recomendados) {
  private val viewModel: LivrosRecomendadosVM by viewModels<LivrosRecomendadosVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.livrosRecomendadosVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      val destIntent = DisciplinaAEstudarActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      // TODO please, add your navigation code here
      finish()
    }
  }

  companion object {
    const val TAG: String = "LIVROS_RECOMENDADOS_ACTIVITY"

  }
}
