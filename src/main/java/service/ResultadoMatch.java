package service;
import java.sql.Connection; 
import Model_Entety.Animal;

public class ResultadoMatch {

    private Animal animal;

    private int pontos;

    public ResultadoMatch() {
    }

    public ResultadoMatch(
            Animal animal,
            int pontos
    ) {

        this.animal = animal;
        this.pontos = pontos;
    }

    public Animal getAnimal() {
        return animal;
    }

    public int getPontos() {
        return pontos;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}