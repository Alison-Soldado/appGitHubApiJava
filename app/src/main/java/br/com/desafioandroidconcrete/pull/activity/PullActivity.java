package br.com.desafioandroidconcrete.pull.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.desafioandroidconcrete.R;
import br.com.desafioandroidconcrete.data.model.listPullRequest.PullRequest;
import br.com.desafioandroidconcrete.data.model.listRepository.Items;
import br.com.desafioandroidconcrete.pull.adapter.PullAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alison on 23/09/17.
 */

public class PullActivity extends AppCompatActivity implements PullView {

    @BindView(R.id.rvListPull)
    RecyclerView rvListPull;
    @BindView(R.id.progressBarPull)
    ProgressBar progressBarPull;
    @BindView(R.id.imgGitPull)
    ImageView imgGitPull;
    @BindView(R.id.txtFailureTextPull)
    TextView txtFailurePull;
    @BindView(R.id.txtNumberOpen)
    TextView txtNumberOpen;
    @BindView(R.id.txtNumberClose)
    TextView txtNumberClose;
    private PullAdapter pullAdapter;
    private PullPresenterImpl pullPresenter;
    private Items item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);
        ButterKnife.bind(PullActivity.this);
        pullPresenter = new PullPresenterImpl(this);
        init();
        setupActionBar();
    }

    private void init(){
        Intent itPull = getIntent();
        item = (Items) itPull.getSerializableExtra("item");
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(item.getName());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pullPresenter.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        pullPresenter.onResume(item.getOwner().getLogin(), item.getName());
    }

    @Override
    public void showProgressBar() {
        progressBarPull.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarPull.setVisibility(View.GONE);
    }

    @Override
    public void showList() {
        rvListPull.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideList() {
        rvListPull.setVisibility(View.GONE);
    }

    @Override
    public void loadList(){
        pullAdapter = new PullAdapter(this, new ArrayList<PullRequest>(0));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvListPull.setLayoutManager(layoutManager);
        rvListPull.setAdapter(pullAdapter);
        rvListPull.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvListPull.addItemDecoration(itemDecoration);
    }

    @Override
    public void success(List<PullRequest> pullRequests, int numberOpen, int numberClose) {
        pullAdapter.updateAnswers(pullRequests);
        txtNumberOpen.setText(String.valueOf(numberOpen));
        txtNumberClose.setText(String.valueOf(numberClose));
    }

    @Override
    public void failure() {
        imgGitPull.setVisibility(View.VISIBLE);
        txtFailurePull.setVisibility(View.VISIBLE);
    }
}
