import org.scalatest._
import memoriae.utils.auth.BCryptPasswordEncoder

class BCryptPasswordEncoderSpec extends FlatSpec with DiagrammedAssertions {

  "matches" should "return true" in {
    assert(BCryptPasswordEncoder.matches("pass", "$2a$10$zN1kawKT0F5hnoX03Qows.MTe2k/h2AC/zn00wmThUKdRrnR2dbg2") == true)
  }

  "matches" should "return false" in {
    assert(BCryptPasswordEncoder.matches("pass", "$2a$10$zN1kawKT0F5hnoX03Qows.MTe2k/h2AC/zn00wmThUKdRrnR2dbg5") == false)
  }

}
