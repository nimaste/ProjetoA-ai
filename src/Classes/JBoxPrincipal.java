package Classes;
// Essa classe serve para conseguir colocar o dados de um produto de um Jbox de Uma maneira boa
// This classe will be use to give some datas of product in a Jbox

public class JBoxPrincipal {
    String nome;
    int id;
    public void ComboItem (String nome, int id){
        // nessa funçao eu recebo o nome e o id Produto que serão futuramete extraidos do banco de dados
        // In this function i recive the name and id Wich Product, and i will get this datas of a data base
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
