package Model_Entety;

public class Estatistica {

    private int animaisAdotados;

    private int animaisNaoAdotados;

    private int animaisEmProcesso;

    private int totalAdocoes;

    private int totalAnimais;

    private int totalAdotantes;
    
    private int animaisCadastrados;

    public Estatistica() {
    }

    public int getAnimaisAdotados() {
        return animaisAdotados;
    }

    public int getAnimaisNaoAdotados() {
        return animaisNaoAdotados;
    }

    public int getAnimaisEmProcesso() {
        return animaisEmProcesso;
    }

    public int getTotalAdocoes() {
        return totalAdocoes;
    }

    public int getTotalAnimais() {
        return totalAnimais;
    }

    public int getTotalAdotantes() {
        return totalAdotantes;
    }

    public void setAnimaisAdotados(
            int animaisAdotados
    ) {

        this.animaisAdotados =
                animaisAdotados;

    }

    public void setAnimaisNaoAdotados(
            int animaisNaoAdotados
    ) {

        this.animaisNaoAdotados =
                animaisNaoAdotados;

    }

    public void setAnimaisEmProcesso(
            int animaisEmProcesso
    ) {

        this.animaisEmProcesso =
                animaisEmProcesso;

    }

    public void setTotalAdocoes(
            int totalAdocoes
    ) {

        this.totalAdocoes =
                totalAdocoes;

    }

    public void setTotalAnimais(
            int totalAnimais
    ) {

        this.totalAnimais =
                totalAnimais;

    }

    public void setTotalAdotantes(
            int totalAdotantes
    ) {

        this.totalAdotantes =
                totalAdotantes;

    }
   

    public void setAnimaisCadastrados(int n) {
        this.animaisCadastrados = n; }
    public int getAnimaisCadastrados() { 
        return animaisCadastrados; }
}