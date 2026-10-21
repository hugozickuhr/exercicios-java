public class Cliente extends Pessoa{
    private int matricula;
    public Cliente(String nome,int matricula){
        super(nome);
        this.matricula = matricula;
    }
    public int getMatricula(){
        return matricula;
    }
    @Override
    public void apresentar(){
        System.out.println("Cliente: " + getNome() + " | Matrícula: " + getMatricula());
    }
}