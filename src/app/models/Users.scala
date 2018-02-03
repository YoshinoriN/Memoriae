package memoriae.models

import java.time.LocalDateTime

case class Users(
  id: Long,
  userName: String,
  password: String,
  isAdmin: Boolean,
  forcePasswordReset: Boolean,
  lastSigninAt: Option[LocalDateTime],
  createdAt: LocalDateTime,
  updatedAt: LocalDateTime,
  deletedAt: Option[LocalDateTime]
)
