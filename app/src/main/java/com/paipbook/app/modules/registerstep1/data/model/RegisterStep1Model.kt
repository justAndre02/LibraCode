package com.paipbook.app.modules.registerstep1.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class RegisterStep1Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtRegisto: String? = MyApp.getInstance().resources.getString(R.string.lbl_registo2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etComponentValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etComponentOneValue: String? = null
)
