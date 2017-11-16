package br.com.desafioandroidconcrete.home.fragment;

import android.content.Context;

import java.util.List;

import br.com.desafioandroidconcrete.data.model.listRepository.Items;

/**
 * Created by alison on 23/09/17.
 */

public class HomePresenterImplFragment implements HomePresenterFragment, HomeModelFragment.onListenerFragment {

    private HomeViewFragment homeViewFragment;
    private HomeModelFragment homeModel;

    public HomePresenterImplFragment(HomeViewFragment homeViewFragment) {
        this.homeViewFragment = homeViewFragment;
        this.homeModel = new HomeModelImplFragment(this);
    }

    @Override
    public Context getContext() {
        return (Context) homeViewFragment;
    }

    @Override
    public void onDestroy() {
        homeViewFragment = null;
    }

    @Override
    public void onResume(Integer currentPage) {
        if (homeViewFragment != null){
            homeViewFragment.hideList();
            homeViewFragment.showProgressBar();
        }

        homeModel.loadAnswers(currentPage, this);
    }

    @Override
    public void loadNextPage(Integer currentPage) {
        homeModel.loadAnswersNextPage(currentPage);
    }

    @Override
    public void loadFirstPage(Integer currentPage) {
        homeModel.loadAnswersFirstPage(currentPage);
    }

    @Override
    public void addLoadingFooter() {
        if (homeViewFragment != null) {
            homeViewFragment.showFooter();
        }
    }

    @Override
    public void removeLoadingFooter() {
        if (homeViewFragment != null) {
            homeViewFragment.hideFooter();
        }
    }

    @Override
    public void addAll(List<Items> items) {
        if (homeViewFragment != null) {
            homeViewFragment.addAll(items);
        }
    }

    @Override
    public void showRetry(boolean show, String erroMsg) {
        homeViewFragment.showRetry(show, erroMsg);
    }

    @Override
    public void onSuccess(List<Items> repositories) {
        if (homeViewFragment != null){
            homeViewFragment.hideProgressBar();
            homeViewFragment.loadList();
            homeViewFragment.success(repositories);
            homeViewFragment.showList();
        }
    }

    @Override
    public void onFailure() {
        if (homeViewFragment != null){
            homeViewFragment.hideProgressBar();
            homeViewFragment.hideList();
            homeViewFragment.failure();
        }
    }
}
