public class Locador extends Pessoa{
    public Locador(String nome){
        super(nome);
    }
    @Override
    public void apresentar(){
        System.out.println("Locador: " + getNome());
    }
}