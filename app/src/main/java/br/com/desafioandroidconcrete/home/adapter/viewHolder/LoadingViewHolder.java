package br.com.desafioandroidconcrete.home.adapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.desafioandroidconcrete.R;
import br.com.desafioandroidconcrete.home.adapter.HomeAdapter;
import br.com.desafioandroidconcrete.utils.ClickRecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alison on 27/09/17.
 */

public class LoadingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    @BindView(R.id.loadmore_progress) public ProgressBar loadmore_progress;
    @BindView(R.id.loadmore_retry) public ImageButton loadmore_retry;
    @BindView(R.id.loadmore_errortxt) public TextView loadmore_errortxt;
    @BindView(R.id.loadmore_errorlayout) public LinearLayout loadmore_errorlayout;

    private HomeAdapter homeAdapter;
    private ClickRecyclerView clickRecyclerView;

    public LoadingViewHolder(View itemView) {
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
        switch (view.getId()) {
            case R.id.loadmore_retry:
            case R.id.loadmore_errorlayout:
                homeAdapter.showRetry(false, null);
                homeAdapter.paginationAdapterCallback.retryPageLoad();
                break;
        }
    }

    @Override
    public boolean onLongClick(View view) {
        clickRecyclerView.onItemClick(view, getAdapterPosition(), true);
        return true;
    }
}
