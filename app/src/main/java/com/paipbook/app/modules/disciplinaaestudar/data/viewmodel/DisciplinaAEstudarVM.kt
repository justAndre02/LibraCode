package com.paipbook.app.modules.disciplinaaestudar.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.disciplinaaestudar.`data`.model.DisciplinaAEstudarModel
import org.koin.core.KoinComponent

class DisciplinaAEstudarVM : ViewModel(), KoinComponent {
  val disciplinaAEstudarModel: MutableLiveData<DisciplinaAEstudarModel> =
      MutableLiveData(DisciplinaAEstudarModel())

  var navArguments: Bundle? = null
}
