package memoriae.modules

import com.google.inject.AbstractModule
import io.getquill._
import org.flywaydb.core.Flyway
import memoriae.utils.config.db.{ DBConfig, Migrate }
import memoriae.utils.Logger

class DBMigrateModule extends AbstractModule with Logger {

  def configure() {
    println(System.getProperty("user.dir"))
    val flyway = new Flyway()
    flyway.setDataSource(DBConfig.url, DBConfig.user, DBConfig.password)
    flyway.setLocations("filesystem:" + System.getProperty("user.dir") + Migrate.sqlPath)
    flyway.migrate()

  }

}
