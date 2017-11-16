package br.com.desafioandroidconcrete.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.desafioandroidconcrete.R;
import br.com.desafioandroidconcrete.data.model.listRepository.Items;
import br.com.desafioandroidconcrete.home.adapter.HomeAdapter;
import br.com.desafioandroidconcrete.utils.pagination.PaginationAdapterCallback;
import br.com.desafioandroidconcrete.utils.pagination.PaginationScrollListener;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alison on 28/09/17.
 */

public class HomeFragment extends Fragment implements HomeViewFragment, PaginationAdapterCallback {

    private static final int PAGE_START = 1;

    @BindView(R.id.rvListRepository) RecyclerView rvListRepository;
    @BindView(R.id.progressBarHome)
    ProgressBar progressBarHome;
    @BindView(R.id.imgGit)
    ImageView imgGit;
    @BindView(R.id.txtFailureText)
    TextView txtFailureText;
    @BindView(R.id.relativeContentHome)
    RelativeLayout relativeContentHome;

    private HomePresenterImplFragment homePresenterFragment;
    private HomeAdapter homeAdapter;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int TOTAL_PAGES = 5;
    private int currentPage = PAGE_START;
    private List<Items> items;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homePresenterFragment = new HomePresenterImplFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homePresenterFragment.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        homePresenterFragment.onResume(PAGE_START);
    }

    @Override
    public void showProgressBar() {
        progressBarHome.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarHome.setVisibility(View.GONE);
    }

    @Override
    public void showFooter() {
        homeAdapter.addLoadingFooter();
    }

    @Override
    public void hideFooter() {
        homeAdapter.removeLoadingFooter();
    }

    @Override
    public void showList() {
        rvListRepository.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideList() {
        rvListRepository.setVisibility(View.GONE);
    }

    @Override
    public void loadList() {
        homeAdapter = new HomeAdapter(getContext(), new ArrayList<Items>(0));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvListRepository.setLayoutManager(linearLayoutManager);
        rvListRepository.setAdapter(homeAdapter);
        rvListRepository.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rvListRepository.addItemDecoration(itemDecoration);

        rvListRepository.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;

                homePresenterFragment.loadNextPage(currentPage);
            }

            @Override
            public int getTotalPageCount() {
                return 0;
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean isLoading() {
                return false;
            }
        });

        homePresenterFragment.loadFirstPage(currentPage);
    }

    @Override
    public void addAll(List<Items> items) {
        homeAdapter.addAll(items);
    }

    @Override
    public void showRetry(boolean show, String erroMsg) {
        homeAdapter.showRetry(show, erroMsg);
    }

    @Override
    public void success(List<Items> items) {
        homeAdapter.updateAnswers(items);
    }

    @Override
    public void failure() {
        imgGit.setVisibility(View.VISIBLE);
        txtFailureText.setVisibility(View.VISIBLE);
    }

    @Override
    public void retryPageLoad() {
        homePresenterFragment.loadNextPage(currentPage);
    }
}
