package Teste;

import Controller.SistemaController;

import Model_Entety.*;

import java.time.LocalDate;

import java.util.List;

public class TesteCarga {

    private static SistemaController controller;

    public static void main(String[] args) {

        try {

            controller =
                    new SistemaController();

            inserirUsuarios();

            inserirAdotantes();

            inserirAnimais();

            inserirVacinas();

            inserirAnimalVacina();

            inserirAdocoes();

            inserirHistorico();

            testarSelects();

            System.out.println(
                    "\nDADOS INSERIDOS COM SUCESSO"
            );

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public static void inserirUsuarios()
            throws Exception {

        for(int i = 1; i <= 5; i++){

            User u =
                    new User();

            u.setNome(
                    "Usuario " + i
            );

            u.setEmail(
                    "user" + i
                    + "@gmail.com"
            );

            u.setSenhaHash(
                    "123456"
            );

            controller.salvarUsuario(u);

            System.out.println(
                    "Usuario "
                    + i
                    + " salvo"
            );
        }
    }

    public static void inserirAdotantes()
            throws Exception {

        for(int i = 1; i <= 5; i++){

            Adotante a =
                    new Adotante();

            a.setNome(
                    "Adotante " + i
            );

            a.setCpf(
                    "0000000000" + i
            );

            a.setEmail(
                    "adotante"
                    + i
                    + "@gmail.com"
            );

            a.setTelefone(
                    "6799999999" + i
            );

            a.setEndereco(
                    "Rua " + i
            );

            Preferencias p =
                    new Preferencias();

            if(i % 2 == 0){

                p.setTipo(
                        "Cachorro"
                );

            }else{

                p.setTipo(
                        "Gato"
                );
            }

            p.setCor(
                    "Preto"
            );

            p.setGenero(
                    'M'
            );

            p.setCastrado(
                    true
            );

            p.setPorte(
                    'P'
            );

            controller.salvarAdotante(
                    a,
                    p
            );

            System.out.println(
                    "Adotante "
                    + i
                    + " salvo"
            );
        }
    }

    public static void inserirAnimais()
            throws Exception {

        for(int i = 1; i <= 5; i++){

            Animal a =
                    new Animal();

            a.setNome(
                    "Animal " + i
            );

            if(i % 2 == 0){

                a.setTipo(
                        "Cachorro"
                );

            }else{

                a.setTipo(
                        "Gato"
                );
            }

            a.setCor(
                    "Preto"
            );

            a.setGenero(
                    'M'
            );

            a.setIdade(i);

            a.setRaca(
                    "Raca " + i
            );

            a.setDeficiencia(
                    false
            );

            a.setCastrado(
                    true
            );

            a.setPeso(
                    2.5f + i
            );

            a.setPorte(
                    'P'
            );

            a.setFIV(
                    false
            );

            a.setFELV(
                    false
            );

            a.setEstado(
                    "NAO_ADOTADO"
            );

//            controller.salvarAnimalComFoto(a);

            System.out.println(
                    "Animal "
                    + i
                    + " salvo"
            );
        }
    }

    public static void inserirVacinas()
            throws Exception {

        for(int i = 1; i <= 5; i++){

            Vacina v =
                    new Vacina();

            v.setNome(
                    "Vacina " + i
            );

            controller.salvarVacina(
                    v
            );

            System.out.println(
                    "Vacina "
                    + i
                    + " salva"
            );
        }
    }

    public static void inserirAnimalVacina()
            throws Exception {

        List<Animal> animais =
                controller
                        .listarAnimais();

        List<Vacina> vacinas =
                controller
                        .listarVacinas();

        for(int i = 0; i < 5; i++){

            AnimalVacina av =
                    new AnimalVacina();

            av.setAnimalId(
                    animais.get(i)
                            .getId()
            );

            av.setVacinaId(
                    vacinas.get(i)
                            .getId()
            );

            av.setDataAplicacao(
                    LocalDate.now()
            );

            av.setDataReforco(
                    LocalDate.now()
                            .plusDays(10)
            );

            controller.salvarAnimalVacina(
                    av
            );

            System.out.println(
                    "Relacao animal vacina "
                    + (i + 1)
                    + " salva"
            );
        }
    }

    public static void inserirAdocoes()
            throws Exception {

        List<Animal> animais =
                controller
                        .listarAnimais();

        List<Adotante> adotantes =
                controller
                        .listarAdotantes();

        for(int i = 0; i < 5; i++){

            Adocao a =
                    new Adocao();

            a.setAnimalId(
                    animais.get(i)
                            .getId()
            );

            a.setAdotanteId(
                    adotantes.get(i)
                            .getId()
            );

            a.setStatus(
                    "EM_PROCESSO"
            );

            controller.salvarAdocao(
                    a
            );

            System.out.println(
                    "Adocao "
                    + (i + 1)
                    + " salva"
            );
        }
    }

    public static void inserirHistorico()
            throws Exception {

        List<User> usuarios =
                controller
                        .ListaUsuario();

        List<Animal> animais =
                controller
                        .listarAnimais();

        List<Adotante> adotantes =
                controller
                        .listarAdotantes();

        for(int i = 0; i < 5; i++){

            Historico h =
                    new Historico();

            h.setUsuarioId(
                    usuarios.get(i)
                            .getId()
            );

            h.setAnimalId(
                    animais.get(i)
                            .getId()
            );

            h.setAdotanteId(
                    adotantes.get(i)
                            .getId()
            );

            h.setAcao(
                    "Acao " + i
            );

            controller.salvarHistorico(
                    h
            );

            System.out.println(
                    "Historico "
                    + (i + 1)
                    + " salvo"
            );
        }
    }

    public static void testarSelects()
            throws Exception {

        System.out.println(
                "\n===== TESTE SELECT ====="
        );

        System.out.println(
                controller
                        .listarAnimais()
                        .size()
        );

        System.out.println(
                controller
                        .listarAdotantes()
                        .size()
        );

        System.out.println(
                controller
                        .listarVacinas()
                        .size()
        );

        System.out.println(
                controller
                        .listarHistorico()
                        .size()
        );

        System.out.println(
                controller
                        .listarAdocoes()
                        .size()
        );

        System.out.println(
                controller
                        .listarNotificacoes()
                        .size()
        );
    }
}