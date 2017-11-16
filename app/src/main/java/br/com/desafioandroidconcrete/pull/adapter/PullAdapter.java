package br.com.desafioandroidconcrete.pull.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.desafioandroidconcrete.R;
import br.com.desafioandroidconcrete.pull.adapter.viewHolder.PullViewHolder;
import br.com.desafioandroidconcrete.utils.ClickRecyclerView;
import br.com.desafioandroidconcrete.data.model.listPullRequest.PullRequest;

/**
 * Created by alison on 23/09/17.
 */

public class PullAdapter extends RecyclerView.Adapter<PullViewHolder> implements PullViewAdapter {

    private List<PullRequest> pullRequests;
    private Context context;

    public PullAdapter(Context context, List<PullRequest> pullRequests) {
        this.pullRequests = pullRequests;
        this.context = context;
    }

    @Override
    public PullViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pull, parent, false);
        return new PullViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PullViewHolder holder, int position) {
        final PullRequest pullRequest = pullRequests.get(position);
        holder.txtNamePull.setText(pullRequest.getTitle());
        holder.txtDescriptionPull.setText(pullRequest.getBody());
        holder.txtUserNamePull.setText(pullRequest.getUser().getLogin());
        holder.txtFullNamePull.setText(pullRequest.getUser().getLogin());
        holder.txtDataPull.setText(formatDataBr(pullRequest.getCreated_at()));
        Glide.with(context).load(pullRequest.getUser().getAvatar_url()).into(holder.imgUserPull);

        holder.setClickListener(new ClickRecyclerView() {
            @Override
            public void onItemClick(View view, int position, boolean isLongClick) {
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(pullRequest.getHtml_url())));
            }
        });
    }

    @Override
    public int getItemCount() {
        return pullRequests.size();
    }


    @Override
    public void updateAnswers(List<PullRequest> pullRequests) {
        this.pullRequests = pullRequests;
        notifyDataSetChanged();
    }

    private String formatDataBr(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date dataEntrada = null;
        try {
            dataEntrada = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(dataEntrada);
    }
}
