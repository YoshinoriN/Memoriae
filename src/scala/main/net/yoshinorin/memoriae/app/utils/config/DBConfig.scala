package net.yoshinorin.memoriae.utils.config

object DBConfig extends ConfigProvider {

  val url = configuration.getString("db.ctx.dataSource.url")
  val user = configuration.getString("db.ctx.dataSource.user")
  val password = configuration.getString("db.ctx.dataSource.password")

}
