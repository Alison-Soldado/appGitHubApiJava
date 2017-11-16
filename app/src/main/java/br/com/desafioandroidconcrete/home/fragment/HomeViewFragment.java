package br.com.desafioandroidconcrete.home.fragment;

import java.util.List;

import br.com.desafioandroidconcrete.data.model.listRepository.Items;

/**
 * Created by alison on 28/09/17.
 */

public interface HomeViewFragment {
    void showProgressBar();
    void hideProgressBar();
    void showFooter();
    void hideFooter();
    void showList();
    void hideList();
    void loadList();
    void addAll(List<Items> items);
    void showRetry(boolean show, String erroMsg);
    void success(List<Items> items);
    void failure();
}
