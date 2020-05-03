package br.com.fiap.exemplodeadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PaisAdapter extends BaseAdapter {
    private Context context;
    private List<Pais> paises;

    public PaisAdapter(Context context, List<Pais> paises){
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return this.paises.size();
    }

    @Override
    public Object getItem(int position) {
        return this.paises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        Pais pais = this.paises.get(position);

        View v = inflater.inflate(R.layout.adapter_pais, null);

        ImageView imgPais = v.findViewById(R.id.imgPais);
        TextView txtNome = v.findViewById(R.id.txtNome);
        TextView txtCapital = v.findViewById(R.id.txtCapital);

        imgPais.setImageResource(pais.getBandeira());
        txtNome.setText(pais.getNome());
        txtCapital.setText(pais.getCapital());
        return v;
    }
}
