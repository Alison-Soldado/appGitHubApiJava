package br.com.desafioandroidconcrete.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import br.com.desafioandroidconcrete.R;
import br.com.desafioandroidconcrete.home.adapter.viewHolder.HomeViewHolder;
import br.com.desafioandroidconcrete.home.adapter.viewHolder.LoadingViewHolder;
import br.com.desafioandroidconcrete.utils.ClickRecyclerView;
import br.com.desafioandroidconcrete.data.model.listRepository.Items;
import br.com.desafioandroidconcrete.pull.activity.PullActivity;
import br.com.desafioandroidconcrete.utils.pagination.PaginationAdapterCallback;

/**
 * Created by alison on 21/09/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements HomeViewAdapter {

    private static final int ITEM = 0;
    private static final int LOADING = 1;

    public PaginationAdapterCallback paginationAdapterCallback;
    private HomePresenterImplAdapter homePresenterImplAdapter;
    private boolean isLoadingAdded = false;
    private boolean retryPageLoad = false;
    private List<Items> items;
    private Context context;
    private String errorMsg;

    public HomeAdapter(Context context, List<Items> items) {
        this.items = items;
        this.context = context;
        homePresenterImplAdapter = new HomePresenterImplAdapter(this);
    }

    public List<Items> getItems() {
        return items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return homePresenterImplAdapter.switchViewHolderCreate(parent, viewType, inflater, viewHolder);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Items item = items.get(position);
        homePresenterImplAdapter.switchHolderBind(holder, position, item);
    }

    @Override
    public int getItemViewType(int position) {
        return (position == items.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void updateAnswers(List<Items> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public void setHomeViewHolder(final HomeViewHolder homeViewHolder, final Items item) {
        homeViewHolder.txtNameHome.setText(item.getName());
        homeViewHolder.txtDescriptionHome.setText(item.getDescription());
        homeViewHolder.txtForkRepositoryHome.setText(String.valueOf(item.getForksCount()));
        homeViewHolder.txtStarRepositoryHome.setText(String.valueOf(item.getStargazersCount()));
        homeViewHolder.txtUserNameHome.setText(item.getOwner().getLogin());
        loadImage(item.getOwner().getAvatar_url()).into(homeViewHolder.imgUserHome);
        loadImage(item.getOwner().getAvatar_url())
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        homeViewHolder.pbImgUserHome.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        homeViewHolder.pbImgUserHome.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(homeViewHolder.imgUserHome);


        homeViewHolder.setClickListener(new ClickRecyclerView() {
            @Override
            public void onItemClick(View view, int position, boolean isLongClick) {
                Intent itPull = new Intent(context, PullActivity.class);
                itPull.putExtra("item", item);
                context.startActivity(itPull);
            }
        });

    }

    @Override
    public void setLoadingViewHolder(LoadingViewHolder loadingViewHolder) {
        if (retryPageLoad) {
            loadingViewHolder.loadmore_errorlayout.setVisibility(View.VISIBLE);
            loadingViewHolder.loadmore_progress.setVisibility(View.GONE);

            loadingViewHolder.loadmore_errortxt.setText(
                    errorMsg != null ?
                            errorMsg :
                            context.getString(R.string.error_msg_unknown));

        } else {
            loadingViewHolder.loadmore_errorlayout.setVisibility(View.GONE);
            loadingViewHolder.loadmore_progress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void add(Items item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    @Override
    public void addAll(List<Items> items) {
        for (Items item : items) {
            add(item);
        }
    }

    @Override
    public void remove(Items item) {
        int position = items.indexOf(item);
        if (position > -1) {
            items.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    @Override
    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Items());
    }

    @Override
    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = items.size() - 1;
        Items item = getItem(position);

        if (item != null) {
            items.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public void showRetry(boolean show, String errorMsg) {
        retryPageLoad = show;
        notifyItemChanged(items.size() - 1);

        if (errorMsg != null) this.errorMsg = errorMsg;
    }

    private Items getItem(int position) {
        return items.get(position);
    }

    private DrawableRequestBuilder<String> loadImage(@NonNull String posterPath) {
        return Glide
                .with(context)
                .load(posterPath)
                .diskCacheStrategy(DiskCacheStrategy.ALL)   // cache both original & resized image
                .centerCrop()
                .crossFade();
    }
}
