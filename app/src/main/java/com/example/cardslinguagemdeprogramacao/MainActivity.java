package com.example.cardslinguagemdeprogramacao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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

class MeuAdaptador extends ArrayAdapter{

    // Através do generate vamos criar o construtor e três métodos obrigatórios, são eles (1)add (2) getCount (3) getView

    // Tras as funcionalidades do ArrayAdapter
    public MeuAdaptador(@NonNull Context context, int resource) {
        super(context, resource);
    }

    //


    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    /*Este método retorna activity criada, no caso, os objetos são visualizados no layout da minha_celula.xml. Serão pegos os objetos da classe
    DadosLinguagemProgramacao e do modelo da célula criada na classe ViewLinguagemProgramacao e devolver na função getView da classe MeuAdapter e
    quando o adaptador for executado vai percorrer o array de dados convertendo todos em objeto do tipo View. */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View minhaView;
        minhaView = convertView;

        ViewLinguagemProgramacao viewLinguagemProgramacao;

        // Se não existir, então vai ser criada o layout
        if(convertView == null){
            // Trás o layout minha_celula.xml
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            minhaView = inflater.inflate(R.layout.minha_celula, parent, false);

            // Criar os objetos que serão devolvidos ao layout
            viewLinguagemProgramacao = new ViewLinguagemProgramacao();
            viewLinguagemProgramacao.icone = (ImageView) minhaView.findViewById(R.id.imageJava);
            viewLinguagemProgramacao.titulo = (TextView) minhaView.findViewById(R.id.textTitulo);
            viewLinguagemProgramacao.descricao = (TextView) minhaView.findViewById(R.id.textDescricao);

            //registrar na minha_celula com os itens da lista
            minhaView.setTag(viewLinguagemProgramacao);

        }else{
            // Se existir o layout vai pegar da célula que já existe
            viewLinguagemProgramacao = (ViewLinguagemProgramacao) minhaView.getTag();
        }

        DadosLinguagemProgramacao dadosLinguagemProgramacao;

        // Para cada objeto criado é obtido a posição atual da célula
        dadosLinguagemProgramacao = (DadosLinguagemProgramacao)this.getItem(position);

        viewLinguagemProgramacao.icone.setImageResource(dadosLinguagemProgramacao.getIcone());
        viewLinguagemProgramacao.titulo.setText(dadosLinguagemProgramacao.getTitulo());
        viewLinguagemProgramacao.descricao.setText(dadosLinguagemProgramacao.getDescricao());

        return minhaView;
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