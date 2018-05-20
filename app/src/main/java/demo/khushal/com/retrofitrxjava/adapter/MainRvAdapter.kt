package demo.khushal.com.retrofitrxjava.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import demo.khushal.com.retrofitrxjava.R
import demo.khushal.com.retrofitrxjava.beans.GitHubResponse
import demo.khushal.com.retrofitrxjava.databinding.ListItemBinding

class MainRvAdapter(private val list: List<GitHubResponse>) : RecyclerView.Adapter<MainRvAdapter.Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val gitHubResponse = list[position]
        holder.listItemBinding!!.response = gitHubResponse
        holder.listItemBinding!!.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var listItemBinding: ListItemBinding? = null

        init {
            listItemBinding = DataBindingUtil.bind(itemView)
        }
    }
}
