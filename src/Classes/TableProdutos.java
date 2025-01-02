package Classes;

public class TableProdutos {
	int id;
	int quantidade;
	double preco;
	String nome;
	
	public void TableProduto(int id,int qnt,String nome,double preco){
		this.id = id;
		this.nome = nome;
		this.quantidade = qnt;
		this.preco = preco;
	}
		
	// Nome
	public String getNome(){
		return nome;
	}
	public void setNome(String nome) {
        this.nome = nome;
    }
	
	//ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	//Quantidade
	public int getQuantidade(){
		return quantidade;
	}
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	
	
	//Preço
	public double getPreco(){
		return preco;
	}
	public void setPreco(double preco){
		this.preco = preco;
	}
	
}
