package com.paipbook.app.modules.registerstep1.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.registerstep1.`data`.model.RegisterStep1Model
import org.koin.core.KoinComponent

class RegisterStep1VM : ViewModel(), KoinComponent {
  val registerStep1Model: MutableLiveData<RegisterStep1Model> =
      MutableLiveData(RegisterStep1Model())

  var navArguments: Bundle? = null
}
