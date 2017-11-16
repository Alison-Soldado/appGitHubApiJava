package br.com.desafioandroidconcrete.home.fragment;

import android.content.Context;

import java.util.List;

import br.com.desafioandroidconcrete.data.model.listRepository.Items;

/**
 * Created by alison on 23/09/17.
 */

public interface HomePresenterFragment {

    Context getContext();
    void onDestroy();
    void onResume(Integer page);
    void loadNextPage(Integer currentPage);
    void loadFirstPage(Integer currentPage);
    void addLoadingFooter();
    void removeLoadingFooter();
    void addAll(List<Items> results);
    void showRetry(boolean show, String erroMsg);

}
