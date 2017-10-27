package br.com.fihpinato.pesquisa_api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private ImageView ivSprite;
    private TextView tvNome;
    private TextView tvTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = (EditText) findViewById(R.id.etNumero);
        ivSprite = (ImageView) findViewById(R.id.ivSprite);
        tvNome = (TextView) findViewById(R.id.tvNome);
        tvTipo = (TextView) findViewById(R.id.tvTipo);
    }

    public void searchPokemon(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);

        service.buscarPokemon(etNumero.getText().toString())
                .enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        if (response.isSuccessful()) {
                            Pokemon pokemon = response.body();

                            tvNome.setText(pokemon.getName());
                            Picasso.with(MainActivity.this)
                                    .load(pokemon.getSprites().getFront_default())
                                    .into(ivSprite);
                            StringBuilder sb = new StringBuilder();
                            for(Types types : pokemon.getTypes()) {
                                sb.append(types.getType().getName());
                                sb.append("\n");
                            }
                            tvTipo.setText(sb.toString());
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "Erro de API", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Toast.makeText(MainActivity.this,
                                "Erro de requisição", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
