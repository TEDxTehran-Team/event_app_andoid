package co.eventbox.tedxtehran.view.home.speakers

import android.content.Context
import co.eventbox.tedxtehran.R
import co.eventbox.tedxtehran.listener.ListOnClickListener
import co.eventbox.tedxtehran.utilities.loadRadius
import co.eventbox.tedxtehran.utilities.toImageURL
import com.apollographql.apollo.co.eventbox.tedxtehran.DashboardCacheQuery
import ir.farshid_roohi.customadapterrecycleview.AdapterRecyclerView
import kotlinx.android.synthetic.main.row_main_speaker.view.*
import kotlinx.android.synthetic.main.row_main_speaker.view.img_speaker
import kotlinx.android.synthetic.main.row_main_speaker.view.layoutRoot
import kotlinx.android.synthetic.main.row_main_speaker.view.txtTitle
import kotlinx.android.synthetic.main.row_speaker.view.*

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 10/2/20.
 */
class MainSpeakerAdapter(var listener: ListOnClickListener) : AdapterRecyclerView<DashboardCacheQuery.Speaker2>(
    R.layout.row_main_speaker,
    R.layout.row_loading,
    R.layout.row_error,
    R.id.btnErrorLoadList
) {

    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: DashboardCacheQuery.Speaker2?
    ) {
        val itemView = viewHolder.itemView

        itemView.txtTitle.text = element?.title()
        itemView.txtDescription.text = element?.description()
        itemView.img_speaker.loadRadius(element?.imageUrl()?.toImageURL())

        itemView.layoutRoot.setOnClickListener {
            this.listener.onSelected(position,element!!.id().toInt())
        }

    }

}