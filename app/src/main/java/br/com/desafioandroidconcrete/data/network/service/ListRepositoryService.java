package br.com.desafioandroidconcrete.data.network.service;


import br.com.desafioandroidconcrete.data.model.listRepository.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alison on 22/09/17.
 */

public interface ListRepositoryService {

    @GET("search/repositories?q=language:Java&sort=stars")
    Call<Repository> getRepository(@Query("page") Integer page);
}
