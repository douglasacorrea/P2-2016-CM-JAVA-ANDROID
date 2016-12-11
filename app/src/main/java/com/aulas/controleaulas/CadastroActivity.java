package com.aulas.controleaulas;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.aulas.controleaulas.basedados.CadastroDb;
import com.aulas.controleaulas.entities.Cadastro;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btnSair = (Button) findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void cadastrar(View v) {
        try {
            CadastroDb CadastroDb = new CadastroDb(this);

            EditText txtNome = (EditText)findViewById(R.id.txtNome);
            EditText txtMatricula = (EditText)findViewById(R.id.txtMatricula);
            EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
            EditText txtContaGit = (EditText)findViewById(R.id.txtContaGit);
            Spinner spiCurso = (Spinner)findViewById(R.id.spiCursos);

            Cadastro cadastro = new Cadastro();
            cadastro.setNome(txtNome.getText().toString());
            cadastro.setMatricula(txtMatricula.getText().toString());
            cadastro.setEmail(txtEmail.getText().toString());
            cadastro.setContaGit(txtContaGit.getText().toString());
            cadastro.setCurso(spiCurso.getSelectedItem().toString());

            CadastroDb.insert(cadastro);
            finish();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}