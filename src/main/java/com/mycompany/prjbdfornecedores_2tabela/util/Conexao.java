/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjbdfornecedores_2tabela.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
        final private String driver  = "com.mysql.cj.jdbc.Driver";
    final private String url     = "jdbc:mysql://localhost:3306/bd_fornecedor2";
    final private String usuario = "root";
    final private String senha   = "iftm";

    public Connection conectar() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
