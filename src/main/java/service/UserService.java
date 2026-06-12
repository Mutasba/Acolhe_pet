package service;

import Dao.UserDAO;
import Model_Entety.User;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDAO dao;

    public UserService(Connection conn)
            throws SQLException {

        dao = new UserDAO();

    }

    public void salvar(User user)
            throws SQLException {

        String senhaHash =
                BCrypt.hashpw(
                        user.getSenhaHash(),
                        BCrypt.gensalt()
                );

        user.setSenhaHash(
                senhaHash
        );

        dao.salvar(user);

    }

    public User login(
            String email,
            String senha
    ) throws SQLException {

        User user =
                dao.login(email);

        if(user == null){

            return null;

        }

        boolean senhaCorreta =
                BCrypt.checkpw(
                        senha,
                        user.getSenhaHash()
                );

        if(senhaCorreta){

            return user;

        }

        return null;
    }

    public List<User> listar()
            throws SQLException {

        return dao.listar();

    }

    public User buscarPorId(int id)
            throws SQLException {

        return dao.buscarPorId(id);

    }

    public void atualizar(User user)
            throws SQLException {

        dao.atualizar(user);

    }

    public void atualizarSenha(
            int id,
            String novaSenha
    ) throws SQLException {

        String hash =
                BCrypt.hashpw(
                        novaSenha,
                        BCrypt.gensalt()
                );

        dao.atualizarSenha(
                id,
                hash
        );

    }

    public void deletar(int id)
            throws SQLException {

        dao.deletar(id);

    }
}