package org.fer.grace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String PULSADO = "pulsado";
    private static final String TEXTO_INTRODUCIDO = "texto";

    private TextView textView;
    private EditText editText;
    private Button button;

    private boolean pulsado;
    private String textoIntroducido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        restaurarCampos (savedInstanceState);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = editText.getText().toString();
                if (!texto.isEmpty()){
                    textoIntroducido =
                editText.getText().toString();
                    pulsado = true;
                    mostrarTextView();
            }
            }
        });
        if (pulsado){
            mostrarTextView();
        }
    }

    private void mostrarTextView() {
        textView.setText(textoIntroducido);
        textView.setVisibility(View.VISIBLE);
    }

    private void restaurarCampos(Bundle savedInstanceState) {
        if (savedInstanceState !=null){
            if (savedInstanceState.getBoolean(PULSADO, false)){
                this.pulsado = savedInstanceState.getBoolean(PULSADO);
                this.textoIntroducido =
                        savedInstanceState.getString(TEXTO_INTRODUCIDO);
            }
        }
    }


}
