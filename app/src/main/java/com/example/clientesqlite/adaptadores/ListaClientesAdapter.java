package com.example.clientesqlite.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clientesqlite.R;
import com.example.clientesqlite.VerActivity2;
import com.example.clientesqlite.entidades.Clientes;

import java.util.ArrayList;

public class ListaClientesAdapter extends RecyclerView.Adapter<ListaClientesAdapter.ClienteViewHolder> {

    ArrayList<Clientes> listaClientes;

    public  ListaClientesAdapter(ArrayList<Clientes> listaClientes){
        this.listaClientes = listaClientes;
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_cliente,null,false);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        holder.viewNombre.setText(listaClientes.get(position).getNombre());
        holder.viewTelefono.setText(listaClientes.get(position).getTelefono());
        holder.viewEmail.setText(listaClientes.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public class ClienteViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewTelefono, viewEmail;
        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewTelefono= itemView.findViewById(R.id.viewTelefono);
            viewEmail = itemView.findViewById(R.id.viewEmail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity2.class);
                    intent.putExtra("ID",listaClientes.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
