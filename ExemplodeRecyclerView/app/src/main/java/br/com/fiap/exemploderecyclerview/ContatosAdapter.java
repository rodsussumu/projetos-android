package br.com.fiap.exemploderecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ContatosAdapter extends RecyclerView.Adapter<ContatosAdapter.ContatoViewHolder> {

    private Context context;
    private List<Contato> contatos;

    public ContatosAdapter(Context context, List<Contato> contatos) {
        this.context = context;
        this.contatos = contatos;
    }

    @NonNull
    @Override
    public ContatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.recyclerview_contato, parent, false);
        ContatoViewHolder contatoViewHolder = new ContatoViewHolder(v);
        return contatoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContatoViewHolder holder, int position) {
        Contato contato = this.contatos.get(position);
        holder.imgContato.setImageResource(contato.getImagem());
        holder.txtNome.setText(contato.getNome());
        holder.txtTelefone.setText(contato.getTelefone());
    }

    @Override
    public int getItemCount() {
        return this.contatos.size();
    }

    public static class ContatoViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imgContato;
        TextView txtNome;
        TextView txtTelefone;
        public ContatoViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            imgContato = itemView.findViewById(R.id.imgContato);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtTelefone = itemView.findViewById(R.id.txtTelefone);
        }
    }
}
