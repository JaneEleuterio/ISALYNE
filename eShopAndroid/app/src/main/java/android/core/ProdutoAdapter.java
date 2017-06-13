package android.core;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import eShop.App;
import eShop.ProdutoActivity;
import utils.Produto;
import ufms.eshop.R;

/**
 * Created by thiag on 30/05/2017.
 */

public class ProdutoAdapter extends BaseAdapter {

    Activity activity;
    LayoutInflater inflater;
    ArrayList<Produto> lista;

    public ProdutoAdapter(Activity activity, ArrayList<Produto> lista){
        this.activity = activity;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null) {
            view = inflater.inflate(R.layout.activity_produto_list_item, null);
        }

        Produto prod = (Produto)lista.get(i);

        final ImageButton btnEnviaCarrinho = (ImageButton) view.findViewById(R.id.btnEnviaCarrinho);
        btnEnviaCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto produto = (Produto)lista.get(i);
                App.carrinho.adicionaProduto(produto.getId());
                Toast.makeText(activity, "Produto Adicionado ao Carrinho", Toast.LENGTH_SHORT).show();
            }
        });


        TextView nome = (TextView) view.findViewById(R.id.textNome);
        TextView valor = (TextView) view.findViewById(R.id.textValor);
        TextView quantidade = (TextView) view.findViewById(R.id.textQuantidade);
        TextView descricao = (TextView) view.findViewById(R.id.textDescricao);

        nome.setText(prod.getNome());
        valor.setText("R$ " + String.format("%.2f", prod.getPreco()));
        quantidade.setText("Quantidade: " + prod.getQuantidadeEstoque());
        descricao.setText(prod.getDescricao());

        return view;
    }
}
