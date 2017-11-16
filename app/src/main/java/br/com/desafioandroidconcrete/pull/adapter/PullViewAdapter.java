package br.com.desafioandroidconcrete.pull.adapter;

import java.util.List;

import br.com.desafioandroidconcrete.data.model.listPullRequest.PullRequest;

/**
 * Created by alison on 27/09/17.
 */

public interface PullViewAdapter {

    void updateAnswers(List<PullRequest> pullRequests);
}
