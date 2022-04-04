package com.example.clientesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.clientesqlite.db.DbClientes;
import com.example.clientesqlite.entidades.Clientes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VerActivity2 extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtEmail;
    Button btnGuarda;
    FloatingActionButton fabEditar;

    Clientes cliente;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver2);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        btnGuarda = findViewById(R.id.btnGuarda);
        fabEditar = findViewById(R.id.fabEditar);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();

            if(extras == null){
                id = Integer.parseInt(null);
            }else{
                id = extras.getInt("ID");
            }
        }else{
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbClientes dbClientes = new DbClientes(VerActivity2.this);
        cliente = dbClientes.verClientes(id);

        if(cliente !=null){
            txtNombre.setText(cliente.getNombre());
            txtTelefono.setText(cliente.getTelefono());
            txtEmail.setText(cliente.getEmail());
            btnGuarda.setVisibility(View.INVISIBLE);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtTelefono.setInputType(InputType.TYPE_NULL);
            txtEmail.setInputType(InputType.TYPE_NULL);
        }
        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerActivity2.this,EditarActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
            }
        });
    }
}