package eShop;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import ufms.eshop.R;
import utils.ActivityController;
import utils.ActivityControllerFactory;

public class MainActivity extends AppCompatActivity implements IInterfaceTags{

    private cosmapek.controller.prov.IManager controller;
    private cosmapek.controller.prov.IControllerManager controllerIContr;

    private MapeKCosmosThread backgroundCosmos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //to not use the asyn
        StrictMode.setThreadPolicy(policy);

        ActivityController mag = ActivityControllerFactory.createInstance();
        mag.setMainActivity(this);
        mag.setMainPackage(this.getPackageName());

        /*
        Button botao = (Button)findViewById(R.id.btIniciaThread);

        botao.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String effectorsPath = "eShop.zCosmapek_Configurations";

                File sdcard = Environment.getExternalStorageDirectory();
                File sdcard_config = new File(sdcard, "config.xml");
                File sdcard_variability = new File(sdcard, "variability.xml");

                backgroundCosmos = MapeKCosmosThreadFactory.createInstance(sdcard_variability.getPath(), sdcard_config.getPath(), effectorsPath);
                controller = cosmapek.controller.impl.ComponentFactory.createInstance();
                controllerIContr =
                        (cosmapek.controller.prov.IControllerManager) controller.getProvidedInterface(IControllerManagerTag);

                if(!backgroundCosmos.isAlive() && !MapeKCosmosThreadFactory.wasUsed()){
                    MapeKCosmosThreadFactory.used();
                    backgroundCosmos.start();
                }
            }
        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getTitle().equals("Produtos")) {
            Intent it = new Intent(MainActivity.this, ProdutoActivity.class);
            startActivity(it);
        } else if (item.getTitle().equals("Carrinho")) {
            Intent it = new Intent(MainActivity.this, CarrinhoActivity.class);
            startActivity(it);
        } else if (item.getTitle().equals("Pagamento")) {
            Intent it = new Intent(MainActivity.this, PagamentoActivity.class);
            it.putExtra("tipo", "");
            startActivity(it);
        }

        return true;
    }
}
