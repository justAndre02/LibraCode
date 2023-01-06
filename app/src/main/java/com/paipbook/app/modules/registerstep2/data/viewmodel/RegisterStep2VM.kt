package com.paipbook.app.modules.registerstep2.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paipbook.app.modules.registerstep2.`data`.model.RegisterStep2Model
import org.koin.core.KoinComponent

class RegisterStep2VM : ViewModel(), KoinComponent {
  val registerStep2Model: MutableLiveData<RegisterStep2Model> =
      MutableLiveData(RegisterStep2Model())

  var navArguments: Bundle? = null
}
