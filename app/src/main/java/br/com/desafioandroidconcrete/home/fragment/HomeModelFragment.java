package br.com.desafioandroidconcrete.home.fragment;

import java.util.List;

import br.com.desafioandroidconcrete.data.model.listRepository.Items;

/**
 * Created by alison on 23/09/17.
 */

public interface HomeModelFragment {

    interface onListenerFragment {
        void onSuccess(List<Items> items);
        void onFailure();
    }

    void loadAnswers(Integer currentPage, onListenerFragment listener);
    void loadAnswersFirstPage(Integer currentPage);
    void loadAnswersNextPage(Integer currentPage);
}
