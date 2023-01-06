package com.paipbook.app.modules.pginainicial.`data`.model

import com.paipbook.app.R
import com.paipbook.app.appcomponents.di.MyApp
import kotlin.String

data class PGinaInicialModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGerirdados: String? = MyApp.getInstance().resources.getString(R.string.lbl_gerir_dados)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHistricodere: String? =
      MyApp.getInstance().resources.getString(R.string.msg_hist_rico_de_r)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSaladeestudo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_verificar_sala)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtReservarlivro: String? =
      MyApp.getInstance().resources.getString(R.string.msg_fazer_uma_reser)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLivrosrecomend: String? =
      MyApp.getInstance().resources.getString(R.string.msg_livros_recomend)

)
