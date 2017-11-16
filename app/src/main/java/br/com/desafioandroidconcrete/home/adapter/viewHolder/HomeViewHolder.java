package br.com.desafioandroidconcrete.home.adapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.desafioandroidconcrete.R;
import br.com.desafioandroidconcrete.utils.ClickRecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by alison on 27/09/17.
 */

public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    @BindView(R.id.txtNameHome) public TextView txtNameHome;
    @BindView(R.id.txtDescriptionHome) public TextView txtDescriptionHome;
    @BindView(R.id.linearHome) public RelativeLayout linearHome;
    @BindView(R.id.pbImgUserHome) public ProgressBar pbImgUserHome;
    @BindView(R.id.imgUserHome) public CircleImageView imgUserHome;
    @BindView(R.id.txtUserNameHome) public TextView txtUserNameHome;
    @BindView(R.id.imgForkRepositoryHome) public ImageView imgForkRepositoryHome;
    @BindView(R.id.txtForkRepositoryHome) public TextView txtForkRepositoryHome;
    @BindView(R.id.imgStarRepositoryHome) public ImageView imgStarRepositoryHome;
    @BindView(R.id.txtStarRepositoryHome) public TextView txtStarRepositoryHome;
    private ClickRecyclerView clickRecyclerView;

    public HomeViewHolder(View itemView) {
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
