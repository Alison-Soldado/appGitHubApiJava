package br.com.desafioandroidconcrete.pull.activity;

/**
 * Created by alison on 24/09/17.
 */

public interface PullPresenter {
    void onDestroy();
    void onResume(String login, String name);
}
