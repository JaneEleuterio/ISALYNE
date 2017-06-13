package eShop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import ufms.eshop.R;
import android.core.CarrinhoAdapter;
import android.widget.Toast;

import utils.Carrinho;
import utils.ItemCarrinho;
import utils.Produto;

public class CarrinhoActivity extends AppCompatActivity implements OnItemClickListener {

    ListView listView;
    CarrinhoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        Button btnRecalcular = (Button) findViewById(R.id.btnRecalcular);
        btnRecalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });

        Button btnPagar = (Button) findViewById(R.id.btnPagar);
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CarrinhoActivity.this, PagamentoActivity.class);
                it.putExtra("tipo", "");
                startActivity(it);
            }
        });

        this.refresh();
    }

    public void refresh() {
        this.listView = (ListView) findViewById(R.id.listViewCarrinho);

        this.adapter = new CarrinhoAdapter(this, App.carrinho.getProdutos());
        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(this);
        registerForContextMenu(this.listView);

        float valorTotal = 0;
        for(ItemCarrinho item : App.carrinho.getProdutos())
        {
            for(Produto produto : App.produtos)
            {
                if(item.getProdutoId() == produto.getId())
                {
                    valorTotal += item.getQuantidade() * produto.getPreco();
                }
            }
        }

        TextView txtTotal = (TextView) findViewById(R.id.txtTotal);
        txtTotal.setText("Total: R$ " + String.format("%.2f", valorTotal));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("O que deseja fazer?");

        menu.add(Menu.NONE, 0, 0, "Remover do Carrinho");
        menu.add(Menu.NONE, 1, 0, "Cancelar");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Produto produto = (Produto) this.listView.getItemAtPosition(menuInfo.position);

        switch (item.getItemId()){
            case 0:
                ((App)getApplicationContext()).carrinho.removeProduto(produto.getId());
                Toast.makeText(CarrinhoActivity.this, "Produto Removido do Carrinho", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return true;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
