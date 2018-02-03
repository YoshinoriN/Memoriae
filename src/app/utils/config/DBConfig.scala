package memoriae.utils.config.db

import memoriae.utils.config.ConfigProvider

object DBConfig extends ConfigProvider {

  val url = configuration.getString("db.ctx.dataSource.url")
  val user = configuration.getString("db.ctx.dataSource.user")
  val password = configuration.getString("db.ctx.dataSource.password")

}

object Migrate extends ConfigProvider {

  val sqlPath = configuration.getString("flyway.sqlfilePath")

}
