package br.com.desafioandroidconcrete.data.network.service;

import java.util.List;

import br.com.desafioandroidconcrete.data.model.listPullRequest.PullRequest;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by alison on 23/09/17.
 */

public interface ListPullRequestService {

    @GET("repos/{login}/{name}/pulls")
    Call <List<PullRequest>> getPullRequests(
            @Path("login") String login,
            @Path("name") String name);
}
