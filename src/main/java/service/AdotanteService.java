package service;

import Dao.AdotanteDAO;
import Dao.PreferenciasDAO;

import Model_Entety.Adotante;
import Model_Entety.Preferencias;
import java.sql.Connection; 
import java.sql.SQLException;
import java.util.List;

public class AdotanteService {

    private AdotanteDAO adotanteDAO;

    private PreferenciasDAO preferenciasDAO;

    public AdotanteService(Connection conn)
            throws SQLException {

        adotanteDAO
                = new AdotanteDAO(conn);

        preferenciasDAO
                = new PreferenciasDAO(conn);

    }

    public Adotante buscarPorCpf(String cpf) throws SQLException {

        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF não informado.");
        }

        return adotanteDAO.buscarPorCpf(cpf);
    }

    public void salvar(
            Adotante adotante,
            Preferencias preferencias
    ) throws SQLException {

        adotanteDAO.salvar(adotante);

        if (preferencias != null) {

            preferencias.setId(
                    adotante.getId()
            );

            preferenciasDAO.salvar(
                    preferencias
            );
        }
    }

    public List<Adotante> listar()
            throws SQLException {

        return adotanteDAO.listar();

    }

    public Adotante buscarPorId(int id)
            throws SQLException {

        return adotanteDAO.buscarPorId(id);

    }

    public Preferencias buscarPreferencias(
            int adotanteId
    ) throws SQLException {

        return preferenciasDAO
                .buscarPorId(adotanteId);

    }

    public void atualizar(
            Adotante adotante,
            Preferencias preferencias
    ) throws SQLException {

        adotanteDAO.atualizar(adotante);

        if (preferencias != null) {

            preferenciasDAO.atualizar(
                    preferencias
            );
        }
    }
    
    

    public void deletar(int id)
            throws SQLException {

        preferenciasDAO.deletar(id);

        adotanteDAO.deletar(id);

    }
}
