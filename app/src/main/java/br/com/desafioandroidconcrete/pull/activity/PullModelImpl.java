package br.com.desafioandroidconcrete.pull.activity;

import java.util.List;

import br.com.desafioandroidconcrete.data.network.service.ListPullRequestService;
import br.com.desafioandroidconcrete.data.model.listPullRequest.PullRequest;
import br.com.desafioandroidconcrete.data.network.api.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alison on 24/09/17.
 */

public class PullModelImpl implements PullModel {

    private static final String TAG = "pull";
    private ListPullRequestService listPullRequestService = ApiUtils.getListPullService();
    private PullPresenter pullPresenterActivity;

    public PullModelImpl(PullPresenter pullPresenterActivity) {
        this.pullPresenterActivity = pullPresenterActivity;
    }

    @Override
    public void loadAnswers(String login, String name, final onListenerPull listenerPull) {
        listPullRequestService.getPullRequests(login, name).enqueue(new Callback<List<PullRequest>>() {
            @Override
            public void onResponse(Call<List<PullRequest>> call, Response<List<PullRequest>> response) {
                if (response.isSuccessful()) {
                    listenerPull.onSuccess(response.body());
                } else {
                    listenerPull.onFailure();
                }
            }

            @Override
            public void onFailure(Call<List<PullRequest>> call, Throwable t) {
                listenerPull.onFailure();
            }
        });
    }
}
