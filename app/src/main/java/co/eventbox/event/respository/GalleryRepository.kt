package co.eventbox.event.respository

import co.eventbox.event.network.Either
import co.eventbox.event.network.XException
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.co.eventbox.event.DashboardCacheQuery


/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 4/17/20.
 */
class GalleryRepository :
    Repository<DashboardCacheQuery.Data, Operation.Variables, DashboardCacheQuery>() {
    suspend fun request() = DashboardCacheQuery.builder().build().run { fetch(this) }
}
