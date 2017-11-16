package br.com.desafioandroidconcrete.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import br.com.desafioandroidconcrete.data.model.listRepository.Items;

/**
 * Created by alison on 27/09/17.
 */

public interface HomePresenterAdapter {

    RecyclerView.ViewHolder switchViewHolderCreate(ViewGroup viewGroup, int viewType, LayoutInflater inflater, RecyclerView.ViewHolder viewHolder);
    void switchHolderBind(RecyclerView.ViewHolder holder, int position, Items item);

}
