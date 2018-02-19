package memoriae.utils.auth

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

object BCryptPasswordEncoder {

  val bcrypt = new BCryptPasswordEncoder()

  /**
   * Encode plain text.
   *
   * @param plainText Text to encode.
   * @return The hashed password
   */
  def encode(plainText: String): String = {
    return bcrypt.encode(plainText)
  }

}
