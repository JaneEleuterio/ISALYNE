package utils;

import java.util.ArrayList;

/**
 * Created by Thiago on 05/12/2016.
 */
public class Carrinho {
    ArrayList<ItemCarrinho> produtos;

    public Carrinho () {
        this.produtos = new ArrayList<ItemCarrinho>();
    }

    public void adicionaProduto (int produtoId) {
        ItemCarrinho produtoExistente = null;

        for (int i=0;i<produtos.size();i++) {

            ItemCarrinho produto = produtos.get(i);

            if (produto.getProdutoId() == produtoId) {
                produtoExistente = produtos.get(i);
                produtoExistente.setQuantidade(produtoExistente.getQuantidade() + 1);

                produtos.set(i, produtoExistente);
            }
        }

        if (produtoExistente == null) {
            this.produtos.add(
                    new ItemCarrinho(produtoId, 1)
            );
        }
    }

    public void removeProduto (int produtoId) {
        for (int i=0;i<produtos.size();i++) {

            ItemCarrinho produto = produtos.get(i);

            if (produto.getProdutoId() == produtoId) {
                int quantidade = produto.getQuantidade();

                if(quantidade == 1) {
                    produtos.remove(i);
                } else {
                    produto.setQuantidade(produto.getQuantidade() - 1);
                    produtos.set(i, produto);
                }
            }
        }
    }

    public ArrayList<ItemCarrinho> getProdutos () {
        return this.produtos;
    }
}
