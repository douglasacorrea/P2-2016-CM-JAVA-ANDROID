package com.aulas.controleaulas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.aulas.controleaulas.basedados.CadastroDb;
import com.aulas.controleaulas.entities.Cadastro;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity  {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        updateLista();

        Button btnSair = (Button) findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ListView lv = (ListView)findViewById(R.id.lstLista);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ProgressoActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        updateLista();
    }

    private void updateLista() {
        thread = new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(2500);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                CadastroDb cadastroDb = new CadastroDb(getApplicationContext());
                                ListView lista = (ListView)findViewById(R.id.lstLista);
                                ArrayAdapter<Cadastro> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, cadastroDb.selectAll());
                                lista.setAdapter(adapter);

                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        };
        thread.start();
    }

    public void openCadastro(View v) {
        Intent curso = new Intent(this, CadastroActivity.class);
        startActivity(curso);
    }

    public void openEnviarEmail(View V) {
        Intent email = new Intent(this, EmailActivity.class);
        startActivity(email);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Atividades") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
