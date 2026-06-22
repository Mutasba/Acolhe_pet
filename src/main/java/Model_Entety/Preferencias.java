package Model_Entety;

public class Preferencias {

    private int id;
    private int adotanteId;
    private String tipo;
    private String cor;
    private int idade;

    private char genero;

    private String raca;

    private boolean deficiencia;
    private boolean castrado;

    private float peso;

    private char porte;

    private boolean fiv;
    private boolean felv;

    public Preferencias() {
    }

    // GETTERS

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCor() {
        return cor;
    }

    public int getIdade() {
        return idade;
    }

    public char getGenero() {
        return genero;
    }

    public String getRaca() {
        return raca;
    }

    public boolean isDeficiencia() {
        return deficiencia;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public float getPeso() {
        return peso;
    }

    public char getPorte() {
        return porte;
    }

    public boolean isFIV() {
        return fiv;
    }

    public boolean isFELV() {
        return felv;
    }

    // SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setDeficiencia(boolean deficiencia) {
        this.deficiencia = deficiencia;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setPorte(char porte) {
        this.porte = porte;
    }

    public void setFIV(boolean fiv) {
        this.fiv = fiv;
    }

    public void setFELV(boolean felv) {
        this.felv = felv;
    }
    public int getAdotanteId() {
        return adotanteId;
    }

    public void setAdotanteId(int adotanteId) {
        this.adotanteId = adotanteId;
    }

}