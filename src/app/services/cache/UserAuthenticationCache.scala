package memoriae.services.cache

object UserAuthenticationCache {

  val cache = new EhCacheProvider("user-authentication")

}
