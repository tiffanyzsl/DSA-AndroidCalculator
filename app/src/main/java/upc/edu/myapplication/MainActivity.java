package upc.edu.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView pantalla;
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonsuma,buttonresta,buttonmult,buttondiv,buttondegrad,buttoncos,buttonsin,buttontan,buttonC,buttonigual;

    // Para calcular sin prioridad
    private double valorAcumulado = Double.NaN;
    private String operacionPendiente = "";
    private String numeroActual = "";
    private boolean esRadianes = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        pantalla = findViewById(R.id.pantalla);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonsuma = findViewById(R.id.buttonsuma);
        buttonresta = findViewById(R.id.buttonresta);
        buttonmult = findViewById(R.id.buttonmult);
        buttondiv = findViewById(R.id.buttondiv);
        buttondegrad = findViewById(R.id.buttondegrad);
        buttoncos = findViewById(R.id.buttoncos);
        buttonsin = findViewById(R.id.buttonsin);
        buttontan = findViewById(R.id.buttontan);
        buttonC = findViewById(R.id.buttonC);
        buttonigual = findViewById(R.id.buttonigual);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroActual +="0";
                pantalla.append("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroActual +="1";
                pantalla.append("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroActual +="2";
                pantalla.append("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroActual +="3";
                pantalla.append("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroActual +="4";
                pantalla.append("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroActual +="5";
                pantalla.append("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroActual +="6";
                pantalla.append("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroActual +="7";
                pantalla.append("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroActual +="8";
                pantalla.append("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroActual +="9";
                pantalla.append("9");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantalla.setText("");
                valorAcumulado = Double.NaN;
                operacionPendiente = "";
                numeroActual = "";            }
        });

        buttonsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPaso();
                operacionPendiente = "+";
                pantalla.append("+");
            }
        });

        buttonresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPaso();
                operacionPendiente = "-";
                pantalla.append("-");
            }
        });

        buttonmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPaso();
                operacionPendiente = "*";
                pantalla.append("x");
            }
        });

        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPaso();
                operacionPendiente = "/";
                pantalla.append("/");
            }
        });

        buttonigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPaso();
                pantalla.setText(String.valueOf(valorAcumulado));
                numeroActual = String.valueOf(valorAcumulado);
                operacionPendiente = "";
            }
        });

        buttondegrad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esRadianes = !esRadianes;
                if (esRadianes) {
                    buttondegrad.setText("RAD");
                } else {
                    buttondegrad.setText("DEG");
                }
            }
        });

        buttonsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = pantalla.getText().toString();
                if (!texto.isEmpty()) {
                    double valor = Double.parseDouble(texto);
                    if (!esRadianes) {
                        valor = Math.toRadians(valor);
                    }
                    double resultado = Math.sin(valor);
                    pantalla.setText(String.valueOf(resultado));
                    numeroActual = String.valueOf(resultado);
                }
            }
        });

        buttoncos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = pantalla.getText().toString();
                if (!texto.isEmpty()) {
                    double valor = Double.parseDouble(texto);
                    if (!esRadianes) {
                        valor = Math.toRadians(valor);
                    }
                    double resultado = Math.cos(valor);
                    pantalla.setText(String.valueOf(resultado));
                    numeroActual = String.valueOf(resultado);
                }
            }
        });

        buttontan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = pantalla.getText().toString();
                if (!texto.isEmpty()) {
                    double valor = Double.parseDouble(texto);
                    if (!esRadianes) {
                        valor = Math.toRadians(valor);
                    }
                    double resultado = Math.tan(valor);
                    pantalla.setText(String.valueOf(resultado));
                    numeroActual = String.valueOf(resultado);
                }
            }
        });
    }
    private void calcularPaso() {
        if (!numeroActual.isEmpty()) {
            double valor = Double.parseDouble(numeroActual);

            if (Double.isNaN(valorAcumulado)) {
                valorAcumulado = valor;
            } else {
                if (operacionPendiente.equals("+")) valorAcumulado += valor;
                else if (operacionPendiente.equals("-")) valorAcumulado -= valor;
                else if (operacionPendiente.equals("*")) valorAcumulado *= valor;
                else if (operacionPendiente.equals("/")) valorAcumulado /= valor;
            }
            numeroActual = "";
        }
    }
}