import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_select_photos.view.*

/**
 * Created by JAI on 01,July,2019
 */
class AddImageSelectionAdapter(var list: MutableList<ProfileImage>) :
    RecyclerView.Adapter<AddImageSelectionAdapter.ViewHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddImageSelectionAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_select_photos, parent, false)
        context = view.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AddImageSelectionAdapter.ViewHolder, position: Int) {
     CommontUtil.loadImage(list[position].url,context,holder.itemView.ivSelected)

    }

    fun swapItems(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition..toPosition - 1) {
                list.set(i, list.set(i + 1, list.get(i)))
            }
        } else {
            for (i in fromPosition..toPosition + 1) {
                list.set(i, list.set(i - 1, list.get(i)))
            }
        }

        notifyItemMoved(fromPosition, toPosition)
    }

    class ViewHolder(rootView: View) : BaseViewHolder<View>(rootView) {
        override fun onBind(item: View) {
        }

    }

}