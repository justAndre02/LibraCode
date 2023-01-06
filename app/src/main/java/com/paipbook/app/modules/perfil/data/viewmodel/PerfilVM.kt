package com.paipbook.app.modules.perfil.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.perfil.`data`.model.PerfilModel
import org.koin.core.KoinComponent

class PerfilVM : ViewModel(), KoinComponent {
  val perfilModel: MutableLiveData<PerfilModel> = MutableLiveData(PerfilModel())

  var navArguments: Bundle? = null
}
