package br.com.fiap.listagemdedados;

import java.util.ArrayList;
import java.util.List;

public class GeradorContatos {
    public static List<Contato> getContatos() {
        List<Contato> contatos = new ArrayList();
        Contato c1 = new Contato("João", "11 1234-5678", "joao@gmail.com", R.drawable.p1);
        Contato c2 = new Contato("Maria", "11 2345-6789", "Maria@gmail.com", R.drawable.p2);
        Contato c3 = new Contato("José", "11 3456-7891", "jose@gmail.com", R.drawable.p3);
        Contato c4 = new Contato("George", "11 4567-8910", "george@gmail.com", R.drawable.p4);

        contatos.add(c1);
        contatos.add(c2);
        contatos.add(c3);
        contatos.add(c4);

        return contatos;
    }
}
