package com.ingrid.showdofilmao.repositories.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMDBService {
    @GET("discover/movie")
    Call<AllMoviesResult> allMovies(@Query("api_key") String apiKey,
                                    @Query("with_genres") String genres,
                                    @Query("year") int year);



    @GET("discover/movie")
    Call<AllMoviesResult> allMovies2(@Query("api_key") String apiKey,
                                    @Query("primary_release_year.lte") int minimumReleaseDate,
                                    @Query("sort_by") String sortBy);
}
