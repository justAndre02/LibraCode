package com.paipbook.app.modules.requisio.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.requisio.`data`.model.RequisiOModel
import org.koin.core.KoinComponent

class RequisiOVM : ViewModel(), KoinComponent {
  val requisiOModel: MutableLiveData<RequisiOModel> = MutableLiveData(RequisiOModel())

  var navArguments: Bundle? = null
}
