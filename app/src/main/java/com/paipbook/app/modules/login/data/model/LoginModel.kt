package com.paipbook.app.modules.login.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class LoginModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLogin: String? = MyApp.getInstance().resources.getString(R.string.lbl_log_in2)
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
