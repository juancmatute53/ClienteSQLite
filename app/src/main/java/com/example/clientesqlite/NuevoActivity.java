package com.example.clientesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clientesqlite.db.DbClientes;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtEmail;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbClientes dbClientes = new DbClientes(NuevoActivity.this);
                long id = dbClientes.insertarCliente(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtEmail.getText().toString());

                if(id>0){
                    Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else{
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private  void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    }
}