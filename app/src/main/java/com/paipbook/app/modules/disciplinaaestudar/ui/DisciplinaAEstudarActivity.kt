package com.paipbook.app.modules.disciplinaaestudar.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.paipbook.app.R
import com.paipbook.app.appcomponents.base.BaseActivity
import com.paipbook.app.databinding.ActivityDisciplinaAEstudarBinding
import com.paipbook.app.modules.disciplinaaestudar.`data`.viewmodel.DisciplinaAEstudarVM
import kotlin.String
import kotlin.Unit

class DisciplinaAEstudarActivity :
    BaseActivity<ActivityDisciplinaAEstudarBinding>(R.layout.activity_disciplina_a_estudar) {
  private val viewModel: DisciplinaAEstudarVM by viewModels<DisciplinaAEstudarVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.disciplinaAEstudarVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "DISCIPLINA_A_ESTUDAR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DisciplinaAEstudarActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
