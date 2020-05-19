package br.com.fiap.exemploderecyclerview;

import java.util.ArrayList;
import java.util.List;

public class GeradorContato {
    public static List<Contato> getContatos() {
        List<Contato> contatos = new ArrayList<>();

        Contato c1 = new Contato("Maria", "maria@fiap.com.br", "(11) 1111-1111", R.drawable.p0);
        contatos.add(c1);

        Contato c2 = new Contato("Pedro", "pedro@fiap.com.br", "(22) 2222-2222", R.drawable.p1);
        contatos.add(c2);

        Contato c3 = new Contato("João", "joao@fiap.com.br", "(33) 3333-3333", R.drawable.p2);
        contatos.add(c3);

        Contato c4 = new Contato("Joaquina", "joaquina@fiap.com.br", "(44) 4444-4444", R.drawable.p3);
        contatos.add(c4);
        return contatos;
    }
}
