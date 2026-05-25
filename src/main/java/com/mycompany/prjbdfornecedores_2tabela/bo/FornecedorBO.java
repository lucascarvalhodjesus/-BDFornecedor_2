/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjbdfornecedores_2tabela.bo;

import com.mycompany.prjbdfornecedores_2tabela.dao.ContatoDAO;
import com.mycompany.prjbdfornecedores_2tabela.dao.FornecedorDAO;
import com.mycompany.prjbdfornecedores_2tabela.models.Contato;
import com.mycompany.prjbdfornecedores_2tabela.models.Fornecedor;
import java.util.List;

public class FornecedorBO {

    FornecedorDAO fDAO;
    ContatoDAO cDAO;

    public FornecedorBO() {
        fDAO = new FornecedorDAO();
        cDAO = new ContatoDAO();

    }

    public void salvarFornecedor(Fornecedor f) {
        if (f.getContatos() != null && !f.getContatos().isEmpty()) {
            fDAO.salvar(f);
            for (Contato c : f.getContatos()) {
                cDAO.salvar(c);
            }
        } else {
            fDAO.salvar(f);
        }
    }

    public void mostrarFornecedores() {
        List<Fornecedor> lstF = fDAO.getFornecedores_Contatos();
        mostrarFornecedores(lstF);
    }

    private void mostrarFornecedores(List<Fornecedor> fornecedores) {
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println("ID: " + fornecedor.getId_fornecedor());
            System.out.println("Nome: " + fornecedor.getNome());
            System.out.println("CNPJ: " + fornecedor.getCnpj());
            if (fornecedor.getContatos() != null) {
                System.out.println("\n");
                mostrarContatos(fornecedor.getContatos());

            }
            System.out.println("\n");
            System.out.println("-0-0--0-0-0-0-0-0-00-0-0---0-0--0-0-0-0-0-0");
            System.out.println("\n");

        }
    }
    private void mostrarContatos(List<Contato> contatos)
    {
        for(Contato contato : contatos){
            System.out.println("ID: "+ contato.getId_contato());
            System.out.println("Tipo: "+ contato.getTipo_contato());
            System.out.println("Contato: "+ contato.getContato());
            System.out.println("ID Fornecedor: "+ contato.getFornecedor().getId_fornecedor());
            System.out.println("\n");
        }
    }

}
