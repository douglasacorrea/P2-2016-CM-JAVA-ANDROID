package com.aulas.controleaulas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    // UI references.
    private EditText txtEmail;
    private EditText txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarLogin();
            }
        });

        Button btnLimpar = (Button) findViewById(R.id.buttonlimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampo();
            }
        });


    }

    private void verificarLogin() {
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        // Reset errors.
        txtEmail.setError(null);
        txtSenha.setError(null);

        String email = txtEmail.getText().toString();
        String password = txtSenha.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!password.isEmpty() && !isPasswordValid(password)) {
            txtSenha.setError(getString(R.string.error_invalid_password));
            focusView = txtSenha;
            cancel = true;
        }

        if (email.isEmpty()) {
            txtEmail.setError(getString(R.string.error_field_required));
            focusView = txtEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            txtEmail.setError(getString(R.string.error_invalid_email));
            focusView = txtEmail;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            Intent curso = new Intent(this, MainActivity.class);
            startActivity(curso);
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private void limpaCampo() {
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtSenha.setText("");
        txtEmail.setText("");

        };
}
