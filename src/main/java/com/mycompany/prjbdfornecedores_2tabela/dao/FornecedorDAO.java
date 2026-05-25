package com.mycompany.prjbdfornecedores_2tabela.dao;

import com.mycompany.prjbdfornecedores_2tabela.models.Fornecedor;
import com.mycompany.prjbdfornecedores_2tabela.models.Contato;
import com.mycompany.prjbdfornecedores_2tabela.util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    Connection conn;
    ContatoDAO cDAO;

    public FornecedorDAO() {
        conn = new Conexao().conectar();
        cDAO = new ContatoDAO();
    }

    public Fornecedor salvar(Fornecedor f) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO fornecedor(nome, cnpj) values (?,?)",
                Statement.RETURN_GENERATED_KEYS
            );

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCnpj());

            int verif = stmt.executeUpdate();

            if (verif > 0) {
                ResultSet rs_id = stmt.getGeneratedKeys();
                if (rs_id.next()) {
                    f.setId_fornecedor(rs_id.getInt(1));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    public List<Fornecedor> getFornecedores_Contatos() {
        List<Fornecedor> lstF = new ArrayList<>();
        ResultSet rs;

        try {
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM fornecedor LEFT JOIN contato ON fornecedor.id_fornecedor = contato.id_fornecedor"
            );

            rs = stmt.executeQuery();

            int ultimoId = -1;
            Fornecedor f = null;
            List<Contato> lstC = null;

            while (rs.next()) {

                int idFornecedor = rs.getInt("id_fornecedor");

                if (idFornecedor != ultimoId) {

                    f = getFornecedor(rs);
                    lstC = new ArrayList<>();

                    if (rs.getInt("id_contato") != 0) {
                        lstC.add(cDAO.getContato(rs, f));
                    }

                    f.setContatos(lstC);
                    lstF.add(f);
                    ultimoId = idFornecedor;

                } else {

                    if (rs.getInt("id_contato") != 0) {
                        lstC.add(cDAO.getContato(rs, f));
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lstF;
    }

    private Fornecedor getFornecedor(ResultSet rs) throws SQLException {
        Fornecedor f = new Fornecedor();

        f.setId_fornecedor(rs.getInt("id_fornecedor"));
        f.setNome(rs.getString("nome"));
        f.setCnpj(rs.getString("cnpj"));

        return f;
    }
}