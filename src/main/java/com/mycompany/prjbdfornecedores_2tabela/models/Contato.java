
package com.mycompany.prjbdfornecedores_2tabela.models;

public class Contato {
    private int id_contato;
    private String tipo_contato;
    private String contato;
    private Fornecedor fornecedor; // apenas um fornecedor

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public String getTipo_contato() {
        return tipo_contato;
    }

    public void setTipo_contato(String tipo_contato) {
        this.tipo_contato = tipo_contato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
