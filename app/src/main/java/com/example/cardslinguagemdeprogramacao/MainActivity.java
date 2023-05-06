package com.example.cardslinguagemdeprogramacao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] listaLingProgramacao = {"JAVA", "PYTHON", "PHP", "RUBY", "JAVASCRIPT", "C", "C++", "C#"};

    // Os icones são as imagens, no caso, as imagens elas são do tipo inteiro, logo tem que declarar do tipo int.
    int[] listaIcones = {R.drawable.java2, R.drawable.python, R.drawable.php, R.drawable.ruby, R.drawable.javascript, R.drawable.lingc,
            R.drawable.cmaismais, R.drawable.csharp};

    String[] listaDescricao = {"Java é uma linguagem multiplataforma, orientada a objetos e centrada em rede que pode ser usada como uma plataforma em si. É uma linguagem de programação rápida, segura e confiável para codificar tudo, desde aplicações móveis e software empresarial até aplicações de big data e tecnologias do servidor.",
            "O Python é uma linguagem de programação amplamente usada em aplicações da Web, desenvolvimento de software, ciência de dados e machine learning (ML). Os desenvolvedores usam o Python porque é eficiente e fácil de aprender e pode ser executada em muitas plataformas diferentes.",
            "PHP é uma linguagem de script do tipo server-side com diversos propósitos. Porém, ela é principalmente utilizada para gerar conteúdos dinâmicos num site. Trata-se de uma linguagem altamente popular devido à sua natureza de código aberto e suas funcionalidades versáteis.",
            "é empregada principalmente no desenvolvimento de aplicações web, mas também pode ser utilizada em outras aplicações de software.O Ruby está disponível em Windows, Linux e muitos outros sistemas, sendo considerado multiplataforma.",
            "O JavaScript surgiu como uma tecnologia do lado do navegador para tornar as aplicações Web mais dinâmicas. Ao usar JavaScript, os navegadores passaram a ser capazes de responder a interações do usuário e alterar o layout do conteúdo na página.",
            "Considerada uma linguagem de alto nível genérica, a C pode ser usada em diversos tipos de projeto, como a criação de aplicativos, sistemas operacionais, drivers, entre outros.",
            "C++ é uma das linguagens mais versáteis que existem, permitindo desenvolver desde tarefas simples como aplicações na linha de comando ou web, até sistemas complexos de tempo real, muito usadas no mercado financeiro.",
            "C# é uma linguagem de programação orientada a objetos e orientada a componentes. C# fornece construções de linguagem para dar suporte diretamente a esses conceitos, tornando C# uma linguagem natural para criação e uso de componentes de software."};

    ListView minhaLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minhaLista = findViewById(R.id.minhaLista);

        final MeuAdaptador meuAdaptador = new MeuAdaptador(getApplicationContext(), R.layout.minha_celula);

        int i=0;
        for (String item:listaLingProgramacao){

            DadosLinguagemProgramacao dadosLinguagemProgramacao;
            dadosLinguagemProgramacao = new DadosLinguagemProgramacao(listaIcones[i],item, listaDescricao[i]);

            meuAdaptador.add(dadosLinguagemProgramacao);
            i++;
        }

        minhaLista.setAdapter(meuAdaptador);

        //Ação de evento de click na lista
        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DadosLinguagemProgramacao dadosLinguagemProgramacao;
                dadosLinguagemProgramacao = (DadosLinguagemProgramacao) meuAdaptador.getItem(position);

                criaAlerta(dadosLinguagemProgramacao);
            }
        });
    }

    // Criando um pop-up para informação
    public void criaAlerta(DadosLinguagemProgramacao dadosLinguagemProgramacao){
        AlertDialog.Builder meuAlerta;
        meuAlerta = new AlertDialog.Builder(MainActivity.this);

        meuAlerta.setTitle(dadosLinguagemProgramacao.getTitulo());
        meuAlerta.setMessage(dadosLinguagemProgramacao.getDescricao());

        // Essa função fecha o pop-up caso clique fora do mesmo
        meuAlerta.setCancelable(true);

        // Pode inserir um botão também
        meuAlerta.setPositiveButton("Sair", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "pop-up finalizado", Toast.LENGTH_SHORT).show();
            }
        });

        // inserindo um icone no pop-up
        meuAlerta.setIcon(dadosLinguagemProgramacao.getIcone());

        meuAlerta.create().show();
    }
}

class ViewLinguagemProgramacao{
    // Criando os atributos icone, titulo e descrição do componente ImageView e TextView da minha_celula.xml
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