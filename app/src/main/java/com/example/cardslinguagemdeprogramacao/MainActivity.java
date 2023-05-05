package com.example.cardslinguagemdeprogramacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] listaLingProgramacao = {"JAVA", "PYTHON", "PHP", "RUBY", "JAVASCRIPT", "C", "C++", "C#"};
    ListView minhaLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criando um objeto arrayAdapter
        ArrayAdapter<String> meuAdaptador = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, listaLingProgramacao);

        minhaLista = findViewById(R.id.minhaLista);

        minhaLista.setAdapter(meuAdaptador);

        //Ação de evento de click na lista
        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Sua linguagem favorita é: " + listaLingProgramacao[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}

class ViewLinguagemProgramacao{
    ImageView icone;
    TextView titulo, descricao;
}



class DadosLinguagemProgramacao{

    // Caminho da imagem (icone)
    private int icone;

    private String titulo;
    private String descricao;

    public DadosLinguagemProgramacao(int icone, String titulo, String descricao) {
        this.icone = icone;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

/* Anotações:
*
*Para criar uma lista é preciso três coisas:
*
* 1 - O componente ListView
* 2 - O array List
* 3 - ArrayAdapter (vai pegar o String e converter esse valor, inserindo num componente virtual, no caso o layout, um textView, por exemplo).
*
* A listaLingProgramacao vai ser inserida para dentro do listView através da Classe ArrayAdapter.
*
* Bom Saber:
* android.R.layout.simple_list_item_1 -> representa o campo de texto do layout
*
* Em layout:
* O atributo 'ScaleType' tem várias opções que definem formatos diferentes da imagem que você deseja colocar.
* */