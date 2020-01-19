package com.example.naslednik.factorizador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button boton;
    TextView resultado;
    EditText numeros;
    int num;
    ArrayList<Integer>factores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    public void clickFactorizar(View vista){
        if (numeros.getText().length()!=0) {
           num = Integer.parseInt(numeros.getText().toString());
           mostrarFactores();
        }else{
            resultado.setText("");
        }
    }

    private void mostrarFactores() {
        calcularFactores();
        printThem();
    }
    private void printThem() {
        resultado = (TextView) findViewById(R.id.texto_result);
        StringBuilder datos = new StringBuilder();
        for (int i=0; i<factores.size(); i++){
            datos.append("");
            if (i==0){
                if(0 == (factores.size()-1)){
                    datos.append(factores.get(i)+".");
                }else {
                    datos.append(""+factores.get(i));
                }
            }if(i>0) {
                if(i == factores.size()-1){
                    datos.append(", "+factores.get(i)+".");
                }else{
                    datos.append(", "+factores.get(i));
                }
            }
           // if(i%6==0){
             //   datos.append("\n");
            //}
        }
        resultado.setText(datos.toString());
        factores = new ArrayList<>();
    }

    private void calcularFactores() {
        if (num>0){
            while (num!=1){
                for (int i = 2; i<= num; i++){
                    if (num%i==0){
                        num = num/i;
                        factores.add(i);
                        break;
                    }

                }
            }
        }else if (num ==1){
            factores.add(1);
        }else{factores.add(0);}
    }

    private void inicializar() {

        boton = (Button) findViewById(R.id.btn_factorizar);

        resultado = (TextView) findViewById(R.id.texto_result);

        numeros = (EditText) findViewById(R.id.entrada_numero);

        factores = new ArrayList<>();
    }
}
