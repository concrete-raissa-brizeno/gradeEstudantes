package com.example.raissacostabrizeno.mdiaestudantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText txtNota1;
    private EditText txtNota2;

    private TextView txtMediaFinal;

    private TextView txtStatus;

    private Button btnCalcular;

    private double nota1;
    private double nota2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNota1 = findViewById(R.id.nota1);
        txtNota2 = findViewById(R.id.nota2);

        txtMediaFinal = (TextView) findViewById(R.id.media_final);
        txtStatus = (TextView) findViewById(R.id.status);

        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(txtNota1.getText().toString().isEmpty()){
                    txtNota1.setError("Campo invalido");
                } else if (txtNota2.getText().toString().isEmpty()){
                    txtNota2.setError("Campo invalido");
                } else {
                    nota1 = Double.parseDouble(txtNota1.getText().toString());
                    nota2 = Double.parseDouble(txtNota2.getText().toString());
                    Double media = calcularMedia(nota1, nota2);
                    txtMediaFinal.setText(media.toString());
                }


            }
        });

    }



    private double calcularMedia(double nota1, double nota2){

        double mediaFinal = (nota1 + nota2)/2;

        if(mediaFinal < 7){
            txtStatus.setText("Reprovado");
        } else {
            txtStatus.setText("Aprovado");
        }

        return mediaFinal;
    }


}
