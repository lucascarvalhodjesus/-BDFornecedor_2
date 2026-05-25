package com.mycompany.prjbdfornecedores_2tabela;

import com.mycompany.prjbdfornecedores_2tabela.bo.FornecedorBO;
import com.mycompany.prjbdfornecedores_2tabela.models.Contato;
import com.mycompany.prjbdfornecedores_2tabela.models.Fornecedor;
import java.util.ArrayList;
import java.util.List;

public class PrjBDFornecedores_2Tabela {

    public static void main(String[] args) {

        // Criando fornecedor
        Fornecedor f2 = new Fornecedor();
        f2.setNome("Fornecedor Teste");
        f2.setCnpj("123456789");

        // Criando contatos
        Contato c1 = new Contato();
        Contato c2 = new Contato();

        c1.setTipo_contato("E-mail");
        c1.setContato("teste@teste.com");

        c2.setTipo_contato("Celular");
        c2.setContato("90000-0000");

        // Lista de contatos
        List<Contato> lstC = new ArrayList<>();
        lstC.add(c1);
        lstC.add(c2);

        // Relacionamento
        f2.setContatos(lstC);
        c1.setFornecedor(f2);
        c2.setFornecedor(f2);

        // BO
        FornecedorBO fBO = new FornecedorBO();

        // Salvar
        fBO.salvarFornecedor(f2);

        // Mostrar
        fBO.mostrarFornecedores();
    }
}