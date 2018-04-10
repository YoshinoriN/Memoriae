package memoriae.modules

import com.google.inject.AbstractModule
import memoriae.bootstraps.DBMigrate

class MemoriaeModule extends AbstractModule {

  override def configure() {
    bind(classOf[DBMigrate]).asEagerSingleton()
  }

}
