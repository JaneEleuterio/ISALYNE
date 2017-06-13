package android.core;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import eShop.App;
import utils.*;
import ufms.eshop.R;

/**
 * Created by thiag on 30/05/2017.
 */

public class CarrinhoAdapter extends BaseAdapter {

    Activity activity;
    LayoutInflater inflater;
    ArrayList<ItemCarrinho> carrinho;

    public CarrinhoAdapter (Activity activity, ArrayList<ItemCarrinho> carrinho) {
        this.activity = activity;
        this.carrinho = carrinho;
    }

    @Override
    public int getCount() {
        return carrinho.size();
    }

    @Override
    public Object getItem(int position) {
        return carrinho.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null) {
            view = inflater.inflate(R.layout.activity_carrinho_list_item, null);
        }

        ItemCarrinho item = carrinho.get(position);
        Produto produto = null;
        for (Produto produtoTemp : App.produtos)
        {
            if(produtoTemp.getId() == item.getProdutoId())
            {
                produto = produtoTemp;
            }
        }

        TextView txtProduto = (TextView) view.findViewById(R.id.txtProduto);
        TextView txtQuantidade = (TextView) view.findViewById(R.id.txtQuantidade);
        TextView txtValorTotal = (TextView) view.findViewById(R.id.txtValorTotal);

        ImageButton btnAdicionar = (ImageButton) view.findViewById(R.id.btnAdicionar);
        ImageButton btnRemover = (ImageButton) view.findViewById(R.id.btnRemover);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemCarrinho itemAdd = carrinho.get(position);
                int quantidadeItem = itemAdd.getQuantidade() + 1;
                Produto produto = null;
                for (Produto produtoTemp : App.produtos)
                {
                    if(produtoTemp.getId() == item.getProdutoId())
                    {
                        produto = produtoTemp;
                    }
                }

                if (produto!= null && quantidadeItem > produto.getQuantidadeEstoque())
                {
                    Toast.makeText(activity, "Quantidade excedida", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    itemAdd.setQuantidade(quantidadeItem);
                    String descricao = quantidadeItem > 1 ? " itens" : " item";
                    txtQuantidade.setText(quantidadeItem + descricao);
                }
            }
        });

        btnRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemCarrinho itemRem = carrinho.get(position);
                int quantidadeItem = itemRem.getQuantidade() - 1;

                if (quantidadeItem >= 0) {
                    itemRem.setQuantidade(quantidadeItem);

                    String descricao = quantidadeItem > 1 ? " itens" : " item";
                    txtQuantidade.setText(quantidadeItem + descricao);

                    Produto produto = null;
                    for (Produto produtoTemp : App.produtos) {
                        if (produtoTemp.getId() == item.getProdutoId()) {
                            produto = produtoTemp;
                        }
                    }
                }
                else
                {
                    Toast.makeText(activity, "A quantidade não pode ser negativa", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(produto != null)
        {
            txtProduto.setText(produto.getNome());
            int quantidade = item.getQuantidade();
            String descricao = quantidade > 1 ? " itens" : " item";
            txtQuantidade.setText(quantidade + descricao);

            float total = produto.getPreco(); // retirada a soma dos itens
            txtValorTotal.setText("R$ " + String.format("%.2f", total));
        }

        return view;
    }
}
