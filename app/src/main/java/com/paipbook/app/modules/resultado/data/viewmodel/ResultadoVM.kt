package com.paipbook.app.modules.resultado.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.resultado.`data`.model.ResultadoModel
import org.koin.core.KoinComponent

class ResultadoVM : ViewModel(), KoinComponent {
  val resultadoModel: MutableLiveData<ResultadoModel> = MutableLiveData(ResultadoModel())

  var navArguments: Bundle? = null
}
