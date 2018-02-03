package memoriae.services

import io.getquill.{ MysqlJdbcContext, SnakeCase }

/**
 * Provide quill context
 */
trait QuillProvider {

  lazy val ctx = new MysqlJdbcContext[SnakeCase](SnakeCase, "db.ctx")

}

