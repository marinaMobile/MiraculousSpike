package com.aqupepgames.projectp.two
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.aqupepgames.projectp.databinding.TwoRcItemBinding


class RcAdapterSec(val jnjasdas : List<RcSecData>, val activity: AppCompatActivity) : RecyclerView.Adapter<RcAdapterSec.Kiosjdsj>() {
    class Kiosjdsj(val vockbobkockobcv: TwoRcItemBinding) : RecyclerView.ViewHolder(vockbobkockobcv.root) {
        fun cfgasdghasdhasdjjasd(eijdsijsdji: RcSecData, activity : AppCompatActivity) = with(vockbobkockobcv){
            tvName.text = eijdsijsdji.name
            tvWin.text = eijdsijsdji.win


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Kiosjdsj {
        val ovbknb = TwoRcItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Kiosjdsj(ovbknb)
    }

    override fun onBindViewHolder(holder: Kiosjdsj, position: Int) {
        holder.cfgasdghasdhasdjjasd(jnjasdas[position], activity)

    }

    override fun getItemCount(): Int = jnjasdas.size



}