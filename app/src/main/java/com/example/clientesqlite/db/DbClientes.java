package com.example.clientesqlite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.clientesqlite.entidades.Clientes;

import java.util.ArrayList;

public class DbClientes extends DbHelper {

    Context context;

    public DbClientes(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarCliente(String nombre, String telefono, String email){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre",nombre);
            values.put("telefono",telefono);
            values.put("email",email);

            id = db.insert(TABLE_CONTACTOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }

    public ArrayList<Clientes> mostrarClientes(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Clientes> listaClientes = new ArrayList<>();
        Clientes cliente = null;
        Cursor cursorClientes = null;

        cursorClientes = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS, null);
        if(cursorClientes.moveToFirst()){
            do{
                cliente = new Clientes();
                cliente.setId(cursorClientes.getInt(0));
                cliente.setNombre(cursorClientes.getString(1));
                cliente.setTelefono(cursorClientes.getString(2));
                cliente.setEmail(cursorClientes.getString(3));
                listaClientes.add(cliente);
            }while(cursorClientes.moveToNext());

        }
        cursorClientes.close();
        return listaClientes;
    }
}
