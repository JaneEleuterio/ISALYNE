package utils;

/**
 * Created by Thiago on 05/12/2016.
 */
public class ItemCarrinho {
    private int produtoId;
    private int quantidade;

    public ItemCarrinho (int produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public int getProdutoId() {
        return this.produtoId;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
