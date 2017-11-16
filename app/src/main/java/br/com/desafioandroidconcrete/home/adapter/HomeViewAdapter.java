package br.com.desafioandroidconcrete.home.adapter;

import java.util.List;

import br.com.desafioandroidconcrete.home.adapter.viewHolder.HomeViewHolder;
import br.com.desafioandroidconcrete.home.adapter.viewHolder.LoadingViewHolder;
import br.com.desafioandroidconcrete.data.model.listRepository.Items;

/**
 * Created by alison on 27/09/17.
 */

public interface HomeViewAdapter {

    void add(Items item);
    void addAll(List<Items> items);
    void remove(Items items);
    void clear();
    void addLoadingFooter();
    void removeLoadingFooter();
    int getItemViewType(int position);
    void showRetry(boolean show, String errorMsg);
    void updateAnswers(List<Items> items);
    void setHomeViewHolder(HomeViewHolder homeViewHolder, Items item);
    void setLoadingViewHolder(LoadingViewHolder loadingViewHolder);
}
