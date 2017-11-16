package br.com.desafioandroidconcrete.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import br.com.desafioandroidconcrete.R;
import br.com.desafioandroidconcrete.home.adapter.viewHolder.HomeViewHolder;
import br.com.desafioandroidconcrete.home.adapter.viewHolder.LoadingViewHolder;
import br.com.desafioandroidconcrete.data.model.listRepository.Items;

/**
 * Created by alison on 27/09/17.
 */

public class HomePresenterImplAdapter implements HomePresenterAdapter {
    private static final int ITEM = 0;
    private static final int LOADING = 1;

    private HomeViewAdapter homeViewAdapter;

    public HomePresenterImplAdapter(HomeViewAdapter homeViewAdapter) {
        this.homeViewAdapter = homeViewAdapter;
    }

    @Override
    public RecyclerView.ViewHolder switchViewHolderCreate(ViewGroup viewGroup, int viewType, LayoutInflater inflater, RecyclerView.ViewHolder viewHolder) {
        switch (viewType) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.item_home, viewGroup, false);
                viewHolder = new HomeViewHolder(viewItem);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.progress_footer, viewGroup, false);
                viewHolder = new LoadingViewHolder(viewLoading);
                break;
        }
        return viewHolder;
    }

    @Override
    public void switchHolderBind(RecyclerView.ViewHolder holder, int position, Items item) {
        switch (homeViewAdapter.getItemViewType(position)) {
            case ITEM:
                final HomeViewHolder homeViewHolder = (HomeViewHolder) holder;
                homeViewAdapter.setHomeViewHolder(homeViewHolder, item);
                break;

            case LOADING:
                LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
                homeViewAdapter.setLoadingViewHolder(loadingViewHolder);
                break;
        }
    }
}
