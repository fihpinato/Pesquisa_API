package br.com.fihpinato.pesquisa_api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {
    @GET("/api/v2/pokemon/{number}")
    Call<Pokemon> buscarPokemon(@Path(value = "number")String number);
}
