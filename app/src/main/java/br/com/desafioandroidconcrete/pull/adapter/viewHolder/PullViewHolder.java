package br.com.desafioandroidconcrete.pull.adapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.desafioandroidconcrete.R;
import br.com.desafioandroidconcrete.utils.ClickRecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by alison on 27/09/17.
 */

public class PullViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    @BindView(R.id.txtNamePull) public TextView txtNamePull;
    @BindView(R.id.txtDescriptionPull) public TextView txtDescriptionPull;
    @BindView(R.id.imgUserPull) public CircleImageView imgUserPull;
    @BindView(R.id.txtUserNamePull) public TextView txtUserNamePull;
    @BindView(R.id.txtFullNamePull) public TextView txtFullNamePull;
    @BindView(R.id.txtDataPull) public TextView txtDataPull;
    private ClickRecyclerView clickRecyclerView;

    public PullViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setClickListener(ClickRecyclerView clickListener){
        this.clickRecyclerView = clickListener;
    }

    @Override
    public void onClick(View view) {
        clickRecyclerView.onItemClick(view, getAdapterPosition(), false);
    }

    @Override
    public boolean onLongClick(View view) {
        clickRecyclerView.onItemClick(view, getAdapterPosition(), true);
        return true;
    }
}
