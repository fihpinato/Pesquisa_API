package br.com.fihpinato.pesquisa_api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//Cria o caminho entre o apk e a api
public interface PokemonService {
    //caminho da informação que quer buscar
    @GET("/api/v2/pokemon/{number}")
    Call<Pokemon> buscarPokemon(@Path(value = "number")String number);
}
