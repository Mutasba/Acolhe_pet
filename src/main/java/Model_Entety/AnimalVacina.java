package Model_Entety;

import java.time.LocalDate;

public class AnimalVacina {
    

    private int id;

    private int animalId;

    private int vacinaId;

    private LocalDate dataAplicacao;

    private LocalDate dataReforco;
   

    public AnimalVacina() {
    }

    public int getId() {
        return id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getVacinaId() {
        return vacinaId;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public LocalDate getDataReforco() {
       
        return this.dataReforco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public void setVacinaId(int vacinaId) {
        this.vacinaId = vacinaId;
    }

    public void setDataAplicacao(
            LocalDate dataAplicacao
    ) {
        this.dataAplicacao = dataAplicacao;
    }

    public void setDataReforco(LocalDate dataReforco) {
        this.dataReforco = dataReforco;
    }
    public void setDataReforco(int tempoReforco) {
        this.dataReforco = dataAplicacao.plusYears(tempoReforco);
    }

    public Object getVacina() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}