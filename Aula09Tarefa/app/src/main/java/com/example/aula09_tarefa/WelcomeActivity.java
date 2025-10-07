    package com.example.aula09_tarefa;



    import androidx.appcompat.app.AppCompatActivity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;

    import com.example.aula09_tarefa.R;

    public class WelcomeActivity extends AppCompatActivity {

        private Button btnComecar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);

            btnComecar = findViewById(R.id.btnComecar);

            btnComecar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Abre a tela do formulário
                    Intent intent = new Intent(WelcomeActivity .this, FormActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
