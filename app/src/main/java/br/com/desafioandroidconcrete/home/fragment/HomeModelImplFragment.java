package br.com.desafioandroidconcrete.home.fragment;

import android.content.Context;
import android.net.ConnectivityManager;

import java.util.List;
import java.util.concurrent.TimeoutException;

import br.com.desafioandroidconcrete.R;
import br.com.desafioandroidconcrete.data.model.listRepository.Items;
import br.com.desafioandroidconcrete.data.model.listRepository.Repository;
import br.com.desafioandroidconcrete.data.network.api.ApiUtils;
import br.com.desafioandroidconcrete.data.network.service.ListRepositoryService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alison on 23/09/17.
 */

public class HomeModelImplFragment implements HomeModelFragment {

    private ListRepositoryService listRepositoryService = ApiUtils.getListRepositoryService();
    private HomePresenterFragment homePresenterFragment;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int TOTAL_PAGES = 5;

    public HomeModelImplFragment(HomePresenterFragment homePresenterFragment) {
        this.homePresenterFragment = homePresenterFragment;
    }

    @Override
    public void loadAnswers(Integer currentPage, final onListenerFragment listener) {
        listRepositoryService.getRepository(currentPage).enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {
                if(response.isSuccessful()) {
                    List<Items> items = response.body().getItems();
                    if (items != null) {
                        listener.onSuccess(items);
                    }
                } else {
                    listener.onFailure();
                }
            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {
                listener.onFailure();
            }
        });
    }

    @Override
    public void loadAnswersFirstPage(final Integer currentPage) {
        listRepositoryService.getRepository(currentPage).enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {

                if (response.isSuccessful()) {
                    List<Items> items = response.body().getItems();

                    if (items != null) {
                        homePresenterFragment.addAll(items);
                    }

                    if (currentPage <= TOTAL_PAGES) {
                        homePresenterFragment.addLoadingFooter();
                    } else {
                        isLastPage = true;
                    }
                }
            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void loadAnswersNextPage(final Integer currentPage) {
        listRepositoryService.getRepository(currentPage).enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {
                if (response.isSuccessful()) {
                    homePresenterFragment.removeLoadingFooter();
                    isLoading = false;

                    List<Items> items = response.body().getItems();
                    if (items != null) {
                        homePresenterFragment.addAll(items);
                    }

                    if (currentPage != TOTAL_PAGES) {
                        homePresenterFragment.addLoadingFooter();
                    } else {
                        isLastPage = true;
                    }
                }
            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {
                t.printStackTrace();
                homePresenterFragment.showRetry(true, fetchErrorMessage(t));
            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) homePresenterFragment.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    private String fetchErrorMessage(Throwable throwable) {
        String errorMsg = homePresenterFragment.getContext().getString(R.string.error_msg_unknown);

        if (!isNetworkConnected()) {
            errorMsg = homePresenterFragment.getContext().getString(R.string.error_msg_no_internet);
        } else if (throwable instanceof TimeoutException) {
            errorMsg = homePresenterFragment.getContext().getString(R.string.error_msg_timeout);
        }

        return errorMsg;
    }
}
