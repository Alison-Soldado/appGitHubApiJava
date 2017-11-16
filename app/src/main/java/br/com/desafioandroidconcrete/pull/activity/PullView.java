package br.com.desafioandroidconcrete.pull.activity;

import java.util.List;

import br.com.desafioandroidconcrete.data.model.listPullRequest.PullRequest;

/**
 * Created by alison on 24/09/17.
 */

public interface PullView {

    void showProgressBar();
    void hideProgressBar();
    void showList();
    void hideList();
    void loadList();
    void success(List<PullRequest> pullRequests, int numberOpen, int numberClose);
    void failure();
}
