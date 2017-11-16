package br.com.desafioandroidconcrete.pull.activity;

import java.util.List;

import br.com.desafioandroidconcrete.data.model.listPullRequest.PullRequest;

/**
 * Created by alison on 24/09/17.
 */

public interface PullModel {

    interface onListenerPull {
        void onSuccess(List<PullRequest> pullRequests);
        void onFailure();
    }

    void loadAnswers(String login, String name, onListenerPull listenerPull);
}
