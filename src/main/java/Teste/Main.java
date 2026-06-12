package Teste;

import Controller.MatchController;
import Controller.SistemaController;
import Database.DB;

import Model_Entety.*;
import View.AnimaisCompativeis;

import java.time.LocalDate;

import java.util.List;
import service.ResultadoMatch;

public class Main {

    private static SistemaController controller;
    private static MatchController mathC;
    

    public static void main(String[] args) {

        try {

            controller
                    = new SistemaController();
            mathC = new MatchController(DB.conectar());

            //   testeInsert();
            testeSelect();
            /**
             * testeUpdate();
             *
             * testeRelacoes();
             *
             * testeDelete();
             *
             */
            testeMatch();
            Adotante a = new Adotante();
            a.setId(3);
            AnimaisCompativeis ac = new AnimaisCompativeis(a);
            ac.setVisible(true);
            System.out.println(
                    "\nTESTES FINALIZADOS"
            );

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public static void testeInsert()
            throws Exception {

        System.out.println(
                "\n========== TESTE INSERT =========="
        );

        User user
                = new User();

        user.setNome(
                "Admin"
        );

        user.setEmail(
                "admin@gmail.com"
        );

        user.setSenhaHash(
                "123456"
        );

        controller.salvarUsuario(
                user
        );

        System.out.println(
                "Usuario salvo"
        );

        Adotante adotante
                = new Adotante();

        adotante.setNome(
                "Maria"
        );

        adotante.setCpf(
                "12345678900"
        );

        adotante.setEmail(
                "maria@gmail.com"
        );

        adotante.setTelefone(
                "679999999"
        );

        adotante.setEndereco(
                "Rua A"
        );

        Preferencias pref
                = new Preferencias();

        pref.setTipo(
                "Gato"
        );

        pref.setCor(
                "Preto"
        );

        pref.setGenero(
                'M'
        );

        pref.setCastrado(
                true
        );

        controller.salvarAdotante(
                adotante,
                pref
        );

        System.out.println(
                "Adotante salvo"
        );

        Animal animal
                = new Animal();

        animal.setNome(
                "Thor"
        );

        animal.setTipo(
                "Gato"
        );

        animal.setCor(
                "Preto"
        );

        animal.setGenero(
                'M'
        );

        animal.setIdade(
                2
        );

        animal.setCastrado(
                true
        );

        animal.setEstado(
                "NAO_ADOTADO"
        );

//        controller.salvarAnimalComFoto(
//                animal
//        );
        System.out.println(
                "Animal salvo"
        );

        Vacina vacina
                = new Vacina();

        vacina.setNome(
                "V4"
        );

        controller.salvarVacina(
                vacina
        );

        System.out.println(
                "Vacina salva"
        );

        List<Vacina> vacinas
                = controller
                        .listarVacinas();

        AnimalVacina av
                = new AnimalVacina();

        av.setAnimalId(
                1
        );

        av.setVacinaId(
                vacinas.get(0)
                        .getId()
        );

        av.setDataAplicacao(
                LocalDate.now()
        );

        av.setDataReforco(
                LocalDate.now()
                        .plusDays(5)
        );

        controller.salvarAnimalVacina(
                av
        );

        System.out.println(
                "Relacao animal vacina salva"
        );

        Adocao adocao
                = new Adocao();

        adocao.setAdotanteId(
                adotante.getId()
        );

        adocao.setAnimalId(
                1
        );

        adocao.setStatus(
                "EM_PROCESSO"
        );

        controller.salvarAdocao(
                adocao
        );

        System.out.println(
                "Adocao salva"
        );

        Historico historico
                = new Historico();

        historico.setUsuarioId(
                1
        //user.getId()
        );

        historico.setAnimalId(
                1
        // animal.getId()
        );

        historico.setAdotanteId(
                1
        // adotante.getId()
        );

        historico.setAcao(
                "Adocao criada"
        );

        controller.salvarHistorico(
                historico
        );

        System.out.println(
                "Historico salvo"
        );
    }

    public static void testeSelect()
            throws Exception {

        System.out.println(
                "\n========== TESTE SELECT =========="
        );

        List<Animal> animais
                = controller
                        .listarAnimais();

        for (Animal a : animais) {

            System.out.println(
                    a.getId()
                    + " - "
                    + a.getNome()
                    + " - "
                    + a.getEstado()
            );
        }

        List<Adotante> adotantes
                = controller
                        .listarAdotantes();

        for (Adotante a : adotantes) {

            System.out.println(
                    a.getId()
                    + " - "
                    + a.getNome()
                    + " - "
                    + a.getCpf()
            );
        }

        List<Vacina> vacinas
                = controller
                        .listarVacinas();

        for (Vacina v : vacinas) {

            System.out.println(
                    v.getNome()
            );
        }

        List<Historico> historicos
                = controller
                        .listarHistorico();

        for (Historico h : historicos) {

            System.out.println(
                    h.getAcao()
            );
        }

        List<Notificacao> notificacoes
                = controller
                        .listarNotificacoes();

        for (Notificacao n : notificacoes) {

            System.out.println(
                    n.getMensagem()
            );
        }

        Estatistica e
                = controller
                        .buscarEstatisticas();

        System.out.println(
                "Adotados: "
                + e.getAnimaisAdotados()
        );
    }

    public static void testeUpdate()
            throws Exception {

        System.out.println(
                "\n========== TESTE UPDATE =========="
        );

        Animal animal
                = controller
                        .BuscarAnimalPorId(1);

        if (animal != null) {

            animal.setNome(
                    "Thor Atualizado"
            );

            animal.setEstado(
                    "EM_PROCESSO"
            );

            controller.atualizarAnimal(
                    animal
            );

            System.out.println(
                    "Animal atualizado"
            );
        }
    }

    public static void testeDelete()
            throws Exception {

        System.out.println(
                "\n========== TESTE DELETE =========="
        );

        controller.deletarAnimal(1);

        System.out.println(
                "Animal deletado"
        );
    }

    public static void testeRelacoes()
            throws Exception {

        System.out.println(
                "\n========== TESTE RELACOES =========="
        );

        List<AnimalVacina> lista
                = controller
                        .listarAnimalVacina(1);
        List<Animal> listaA
                = controller
                        .listarAnimais();

        Preferencias listap
                = controller
                        .buscarPreferencias(1);
        for (AnimalVacina av : lista) {

            System.out.println(
                    "Animal "
                    + av.getAnimalId()
                    + " tomou vacina "
                    + av.getVacinaId()
            );
        }

        controller.verificarVacinas();

        System.out.println(
                "Notificacao vacina ok"
        );

        controller.gerarMatchesAutomaticos();

        System.out.println(
                "Match automatico ok"
        );

        controller.gerarPdfEstatistica(
                "estatistica.pdf"
        );

        controller.gerarPdfHistorico(
                "historico.pdf"
        );

        System.out.println(
                "PDF gerado"
        );
    }

    public static void testeMatch()
            throws Exception {
        List<ResultadoMatch> r;
        System.out.println(
                "\n===== TESTE MATCH ====="
        );

        List<Adotante> adotantes
                = controller
                        .listarAdotantes();

        for (Adotante adotante : adotantes) {

            System.out.println(
                    "\nAdotante: "
                    + adotante.getNome()
            );

            Preferencias pref
                    = controller
                            .buscarPreferencias(
                                    adotante.getId()
                            );
            r = mathC.buscarAnimaisCompativeis(pref);

            for (ResultadoMatch rr : r) {
                System.out.println(
                        rr.getAnimal().getNome()
                        + " -> "
                        + rr.getPontos()
                        + " pontos"
                );
            }
        }
    }
}
