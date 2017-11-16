package br.com.desafioandroidconcrete.data.network.api;


import br.com.desafioandroidconcrete.data.network.service.ListPullRequestService;
import br.com.desafioandroidconcrete.data.network.service.ListRepositoryService;

/**
 * Created by alison on 22/09/17.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://api.github.com/";

    public static ListRepositoryService getListRepositoryService() {
        return ApiClient.getClient(BASE_URL).create(ListRepositoryService.class);
    }

    public static ListPullRequestService getListPullService() {
        return ApiClient.getClient(BASE_URL).create(ListPullRequestService.class);
    }
}
