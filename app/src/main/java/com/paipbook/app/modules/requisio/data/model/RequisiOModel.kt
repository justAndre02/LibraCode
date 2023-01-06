package com.paipbook.app.modules.requisio.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class RequisiOModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtUmaAventura: String? = MyApp.getInstance().resources.getString(R.string.lbl_uma_aventura)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtUmaAventuraem: String? =
      MyApp.getInstance().resources.getString(R.string.msg_uma_aventura_em6)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupTwentyOneValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupFifteenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupSeventeenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupNineteenValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupTwentyFiveValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupTwentyThreeValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupTwentySevenValue: String? = null
)
