package eShop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import controller.prov.IControllerManager;
import ufms.eshop.R;
import utils.ItemCarrinho;
import utils.Produto;

public class PagamentoActivity extends AppCompatActivity {

    private float ValorTotal;
    private IControllerManager i_IControllerManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this.i_IControllerManager = this.initController();
        this.i_IControllerManager = ((App)getApplicationContext()).getController();

        Intent thisIntent = getIntent();
        String tipo = thisIntent.getStringExtra("tipo");

        switch (tipo) {
            case "D":
                setContentView(R.layout.activity_pagamento_dinheiro);
                this.Total();
                this.Dinheiro();
                break;
            case "C":
                setContentView(R.layout.activity_pagamento_cartao);
                this.Total();
                this.Cartao();
                break;
            case "B":
                setContentView(R.layout.activity_pagamento_boleto);
                this.Total();
                this.Boleto();
                break;
            case "T":
                setContentView(R.layout.activity_pagamento_transferencia);
                this.Total();
                this.Transferencia();
                break;
            default:
                setContentView(R.layout.activity_pagamento);
                this.Pagamento();
                break;
        }
    }

    private void Pagamento() {
        Button btnDinheiro = (Button) this.findViewById(R.id.btnDinheiro);
        Button btnCartao = (Button) this.findViewById(R.id.btnCartao);
        Button btnBoleto = (Button) this.findViewById(R.id.btnBoleto);
        Button btnTransf = (Button) this.findViewById(R.id.btnTransf);

        btnDinheiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PagamentoActivity.this, PagamentoActivity.class);
                it.putExtra("tipo", "D");
                startActivity(it);
            }
        });

        btnCartao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PagamentoActivity.this, PagamentoActivity.class);
                it.putExtra("tipo", "C");
                startActivity(it);
            }
        });

        btnBoleto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PagamentoActivity.this, PagamentoActivity.class);
                it.putExtra("tipo", "B");
                startActivity(it);
            }
        });

        btnTransf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PagamentoActivity.this, PagamentoActivity.class);
                it.putExtra("tipo", "T");
                startActivity(it);
            }
        });
    }

    private void Total() {
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
        this.ValorTotal = valorTotal;
    }

    private void Dinheiro() {
        TextView txtTroco = (TextView) findViewById(R.id.txtTroco);
        txtTroco.setText("Troco: R$ " + String.format("%.2f", 0f));

        EditText edValorPago = (EditText) findViewById(R.id.edValorPago);

        Button btnTroco = (Button) findViewById(R.id.btnTroco);
        btnTroco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float valorPago;
                try {
                    valorPago = Float.parseFloat(edValorPago.getText().toString());
                } catch (NumberFormatException ex) {
                    valorPago = 0f;
                }

                float troco = valorPago - ValorTotal;
                if (troco > 0) {
                    txtTroco.setText("Troco: R$ " + String.format("%.2f", troco));
                } else {
                    Toast.makeText(PagamentoActivity.this, "Valor pago menor que o total", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Cartao() {
        Button btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tipoCartao = 1;

                RadioGroup rgCartao = (RadioGroup) findViewById(R.id.rgCartao);
                switch (rgCartao.getCheckedRadioButtonId())
                {
                    case R.id.rbMaster:
                        tipoCartao = 1;
                        break;
                    case R.id.rbVisa:
                        tipoCartao = 2;
                        break;
                    default:
                        break;
                }

                EditText edNome = (EditText) findViewById(R.id.edNome);
                EditText edNumero = (EditText) findViewById(R.id.edNumero);
                EditText edCodigo = (EditText) findViewById(R.id.edCodigo);
                EditText edValidade = (EditText) findViewById(R.id.edValidade);
                EditText edParcelas = (EditText) findViewById(R.id.edParcelas);

                String nome = String.valueOf(edNome.getText());
                String numero = String.valueOf(edNumero.getText());
                String codigo = String.valueOf(edCodigo.getText());
                String validade = String.valueOf(edValidade.getText());
                int parcelas = Integer.parseInt(edParcelas.getText().toString());

                String retorno = i_IControllerManager.pagarComCartaoDeCreditoController (
                                                        tipoCartao,
                                                        ValorTotal,
                                                        nome,
                                                        numero,
                                                        validade,
                                                        codigo,
                                                        parcelas
                                                     );

                if(!retorno.isEmpty()) {
                    Toast.makeText(PagamentoActivity.this, retorno, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Boleto() {

    }

    private void Transferencia() {
        TextView lbBanco = (TextView) this.findViewById(R.id.lbBanco);
        TextView lbTitular = (TextView) this.findViewById(R.id.lbTitular);
        TextView lbConta = (TextView) this.findViewById(R.id.lbConta);
        TextView lbAgencia = (TextView) this.findViewById(R.id.lbAgencia);
        TextView lbDoc = (TextView) this.findViewById(R.id.lbDoc);

        lbBanco.setText("4356");
        lbTitular.setText("José Augusto");
        lbConta.setText("142567-60");
        lbAgencia.setText("4356");
        lbDoc.setText("648.489.389-50");
    }

    private IControllerManager initController() {
        controller.prov.IControllerManager i_IControllerManager;
        controller.prov.IManager comp_Controller;
        comp_Controller = controller.impl.ComponentFactory.createInstance();
        String IControllerManagerTag = "IControllerManager";

        i_IControllerManager = (controller.prov.IControllerManager) comp_Controller.getProvidedInterface(IControllerManagerTag);

        return i_IControllerManager;
    }
}
