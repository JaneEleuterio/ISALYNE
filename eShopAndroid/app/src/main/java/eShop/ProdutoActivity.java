package eShop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import android.core.ProdutoAdapter;
import utils.Produto;
import ufms.eshop.R;

public class ProdutoActivity extends AppCompatActivity implements OnItemClickListener {

    ListView listView;
    ProdutoAdapter adapter;
    ArrayList<Produto> lista;
    ArrayList<Produto> listaFiltrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        final EditText edProduto = (EditText) this.findViewById(R.id.editProduto);
        final Button btnBuscar = (Button) this.findViewById(R.id.btnBuscar);
        final Button btnLimpar = (Button) this.findViewById(R.id.btnLimpar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String busca = edProduto.getText().toString().toUpperCase();
                if(busca != "") {
                    ArrayList<Produto> novaLista = new ArrayList<>();
                    for(int i = 0; i<lista.size();i++){
                        Produto produto = lista.get(i);

                        if(produto.getNome().toUpperCase().contains(busca) || String.valueOf(produto.getId()) == busca)
                        {
                            novaLista.add(produto);
                        }
                    }

                    if(novaLista.size()>0){
                        listaFiltrada = novaLista;
                        refresh();
                    }
                } else {
                    listaFiltrada = null;
                    refresh();
                }
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                edProduto.setText("");
                listaFiltrada = null;
                refresh();
            }
        });

        this.lista = App.produtos;
        this.refresh();
    }

    public void refresh() {
        this.listView = (ListView) findViewById(R.id.listViewProdutos);

        if (listaFiltrada != null) {
            this.adapter = new ProdutoAdapter(this, listaFiltrada);
        } else if (lista != null) {
            this.adapter = new ProdutoAdapter(this, lista);
        }

        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(this);
        registerForContextMenu(this.listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("O que deseja fazer?");

        menu.add(Menu.NONE, 0, 0, "Adicionar ao Carrinho");
        menu.add(Menu.NONE, 1, 0, "Cancelar");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Produto produto = (Produto) this.listView.getItemAtPosition(menuInfo.position);

        switch (item.getItemId()){
            case 0:
                ((App)getApplicationContext()).carrinho.adicionaProduto(produto.getId());
                Toast.makeText(ProdutoActivity.this, "Produto Adicionado ao Carrinho", Toast.LENGTH_SHORT).show();
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
