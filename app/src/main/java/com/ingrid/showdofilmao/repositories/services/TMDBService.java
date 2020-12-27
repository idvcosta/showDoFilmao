package com.ingrid.showdofilmao.repositories.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMDBService {
    @GET("discover/movie")
    Call<AllMoviesResult> allMovies(@Query("api_key") String apiKey);

}
