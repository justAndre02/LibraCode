package com.paipbook.app.modules.registerstep2.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class RegisterStep2Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtRegisto: String? = MyApp.getInstance().resources.getString(R.string.lbl_registo2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.msg_by_signing_up)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etComponentValue: String? = null
)
