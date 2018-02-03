package memoriae.models

case class Users(
  id: Long,
  userName: String,
  password: String,
  isAdmin: Option[Boolean] = Some(false),
  forcePasswordReset: Option[Boolean] = Some(false),
  lastSigninAt: Option[java.sql.Timestamp] = None,
  createdAt: java.sql.Timestamp = new java.sql.Timestamp(System.currentTimeMillis()),
  updatedAt: Option[java.sql.Timestamp] = None,
  deletedAt: Option[java.sql.Timestamp] = None
)
