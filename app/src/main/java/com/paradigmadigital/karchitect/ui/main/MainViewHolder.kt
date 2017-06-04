package com.paradigmadigital.karchitect.ui.main

import android.content.Context
import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.paradigmadigital.karchitect.R
import com.paradigmadigital.karchitect.domain.entities.Channel
import com.paradigmadigital.karchitect.domain.entities.ChannelData

class MainViewHolder(
        itemView: ViewGroup
) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.desc)
    lateinit var desc: TextView
    @BindView(R.id.qtty)
    lateinit var qtty: TextView

    lateinit private var channel: ChannelData
    private var clickListener: MainClickListener? = null

    private val context: Context
    private val resources: Resources

    init {
        ButterKnife.bind(this, itemView)
        resources = itemView.resources
        context = itemView.context
    }

    fun bind(channel: ChannelData, clickListener: MainClickListener?) {
        this.channel = channel
        this.clickListener = clickListener
        configureView()
    }

    private fun configureView() {
        qtty.text = "${channel.unreadCount}"
        desc.text = "${channel.channel.title}: ${channel.channel.description}"
    }

    @OnClick(R.id.main_row)
    internal fun onRowClick() {
        clickListener?.onClick(adapterPosition)
    }
}