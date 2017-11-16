package br.com.desafioandroidconcrete.pull.activity;

import java.util.List;

import br.com.desafioandroidconcrete.data.model.listPullRequest.PullRequest;

/**
 * Created by alison on 24/09/17.
 */

public class PullPresenterImpl implements PullPresenter, PullModel.onListenerPull {

    private PullView pullViewActivity;
    private PullModel pullModel;

    public PullPresenterImpl(PullView pullViewActivity) {
        this.pullViewActivity = pullViewActivity;
        pullModel = new PullModelImpl(this);
    }

    @Override
    public void onDestroy() {
        pullViewActivity = null;
    }

    @Override
    public void onResume(String login, String name) {
        if (pullViewActivity != null) {
            pullViewActivity.hideList();
            pullViewActivity.showProgressBar();
        }

        pullModel.loadAnswers(login, name, this);
    }

    @Override
    public void onSuccess(List<PullRequest> pullRequests) {
        if (pullViewActivity != null) {
            pullViewActivity.hideProgressBar();
            pullViewActivity.loadList();
            pullViewActivity.success(pullRequests, countNumberOpen(pullRequests), countNumberClose(pullRequests));
            pullViewActivity.showList();
        }
    }

    @Override
    public void onFailure() {
        if (pullViewActivity != null) {
            pullViewActivity.hideProgressBar();
            pullViewActivity.hideList();
            pullViewActivity.failure();
        }
    }

    private int countNumberOpen(List<PullRequest> pullRequests){
        int count = 0;
        for (int i = 0; i < pullRequests.size(); i++){
            if (pullRequests.get(i).getState().equals("open")){
                count++;
            }
        }
        return count;
    }

    private int countNumberClose(List<PullRequest> pullRequests){
        int count = 0;
        for (int i = 0; i < pullRequests.size(); i++){
            if (pullRequests.get(i).getState().equals("close")){
                count++;
            }
        }
        return count;
    }

}
