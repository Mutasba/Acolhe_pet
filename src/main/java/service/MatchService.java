package service;

import Dao.AnimalDAO;
import Model_Entety.Animal;
import Model_Entety.FiltroAnimal;
import Model_Entety.Preferencias;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatchService {

    private AnimalDAO animalDAO;

    public MatchService(Connection conn) throws SQLException {

        animalDAO = new AnimalDAO(conn);

    }

    public List<ResultadoMatch> buscarAnimaisCompativeis(
            Preferencias pref
    ) throws SQLException {

        List<Animal> animais
                = animalDAO.listar();

        List<ResultadoMatch> resultado
                = new ArrayList<>();

        for (Animal animal : animais) {

            if (!animal.getEstado()
                    .equalsIgnoreCase("NAO_ADOTADO")) {

                continue;

            }
            int pontos = 0;

            if (animal.getTipo()
                    .equalsIgnoreCase(
                            pref.getTipo()
                    )) {

                pontos++;
            }

            if (animal.getCor()
                    .equalsIgnoreCase(
                            pref.getCor()
                    )) {

                pontos++;
            }

            if (animal.getRaca()
                    .equalsIgnoreCase(
                            pref.getRaca()
                    )) {

                pontos++;
            }

            if (animal.getGenero()
                    == pref.getGenero()) {

                pontos++;
            }

            if (animal.getPorte()
                    == pref.getPorte()) {

                pontos++;
            }
            if (animal.isCastrado()
                    == pref.isCastrado()) {

                pontos++;

            }

            if (animal.isDeficiencia()
                    == pref.isDeficiencia()) {

                pontos++;
            }

            if (animal.isFIV()
                    == pref.isFIV()) {

                pontos++;
            }

            // FELV
            if (animal.isFELV()
                    == pref.isFELV()) {

                pontos++;
            }

            if (animal.getIdade()
                    == pref.getIdade()) {

                pontos++;
            }

            if (animal.getPeso()
                    == pref.getPeso()) {

                pontos++;
            }

            if (pontos > 0) {

                ResultadoMatch r
                        = new ResultadoMatch(
                                animal,
                                pontos
                        );

                resultado.add(r);
            }
        }

        resultado.sort(
                Comparator.comparing(
                        ResultadoMatch::getPontos
                ).reversed()
        );

        return resultado;
    }

    public List<Animal> filtrarAnimais(
            FiltroAnimal filtro
    ) throws SQLException {

        List<Animal> animais = animalDAO.listar();

        List<Animal> resultado
                = new ArrayList<>();

        for (Animal animal : animais) {

            if (!animal.getEstado()
                    .equalsIgnoreCase("NAO_ADOTADO")) {

                continue;
            }

            boolean valido = true;

            // Tipo
            if (filtro.getTipo() != null
                    && !animal.getTipo()
                            .equalsIgnoreCase(
                                    filtro.getTipo())) {

                valido = false;
            }

            // Cor
            if (filtro.getCor() != null
                    && !animal.getCor()
                            .equalsIgnoreCase(
                                    filtro.getCor())) {

                valido = false;
            }

            // Raça
            if (filtro.getRaca() != null
                    && !animal.getRaca()
                            .equalsIgnoreCase(
                                    filtro.getRaca())) {

                valido = false;
            }

            if (filtro.getGenero() != '\0'
                    && animal.getGenero() != filtro.getGenero()) {

                valido = false;
            }

            // Porte
            if (filtro.getPorte() != '\0'
                    && animal.getPorte()
                    != filtro.getPorte()) {

                valido = false;
            }

            // Castrado
            if (filtro.getCastrado() != null
                    && animal.isCastrado()
                    != filtro.getCastrado()) {

                valido = false;
            }

            // Deficiência
            if (filtro.getDeficiencia() != null
                    && animal.isDeficiencia()
                    != filtro.getDeficiencia()) {

                valido = false;
            }

            // FIV
            if (filtro.getFiv() != null
                    && animal.isFIV()
                    != filtro.getFiv()) {

                valido = false;
            }

            // FELV
            if (filtro.getFelv() != null
                    && animal.isFELV()
                    != filtro.getFelv()) {

                valido = false;
            }

            // Peso
            if (filtro.getPeso() != null
                    && animal.getPeso()
                    != filtro.getPeso()) {

                valido = false;
            }

            if (valido) {

                resultado.add(animal);

            }
        }

        return resultado;
    }
}
