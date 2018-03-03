package memoriae.services.cache

import scala.concurrent.duration.{ Duration, _ }
import scala.concurrent.{ Await, Future }
import scala.concurrent.ExecutionContext.Implicits.global
import scala.reflect.ClassTag
import play.api.cache.ehcache.EhCacheApi
import net.sf.ehcache.CacheManager

class EhCacheProvider(cacheName: String) {

  private val name = cacheName
  private val cacheManager = CacheManager.create
  cacheManager.addCache(name)

  private val cache = new EhCacheApi(cacheManager.getEhcache(name))

  def get[T](key: String, dur: Duration = Duration.Inf)(implicit cTag: ClassTag[T]): Option[T] = {
    Await.result(cache.get[T](key), dur)
  }

  def set(key: String, value: Any, dur: Duration = Duration.Inf): Unit = {
    cache.set(key, value, dur)
  }

  def remove(key: String): Unit = {
    cache.remove(key)
  }
}
