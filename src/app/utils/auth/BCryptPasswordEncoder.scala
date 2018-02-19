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


  /**
   * Check the plaintext and encodedtext are match or not.
   *
   * @param plainPassword The plain text.
   * @param encodedPassword The plain text.
   * @return Password match or not.
    */
  def matches(plainPassword: String, encodedPassword: String): Boolean = {
    return bcrypt.matches(plainPassword, encodedPassword);
  }

}
