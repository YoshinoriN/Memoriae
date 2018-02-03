package memoriae.bootstraps

import javax.inject.Singleton
import io.getquill._
import org.flywaydb.core.Flyway
import memoriae.utils.config.db.{ DBConfig, Migrate }
import memoriae.utils.Logger

@Singleton
class DBMigrate extends Logger {

  val flyway = new Flyway()
  flyway.setDataSource(DBConfig.url, DBConfig.user, DBConfig.password)
  flyway.setLocations("filesystem:" + System.getProperty("user.dir") + Migrate.sqlPath)
  flyway.migrate()

}
