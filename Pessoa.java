package ProjetoModulo01;

public class Pessoa {
    public enum TipoPessoa{
        pessoa_fisica,
        pessoa_juridica
    }
    private TipoPessoa tipoPessoa;
    private String nome;

    public String getNome() {
        return nome;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Pessoa(TipoPessoa tipoPessoa, String nome){
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
    }
}
