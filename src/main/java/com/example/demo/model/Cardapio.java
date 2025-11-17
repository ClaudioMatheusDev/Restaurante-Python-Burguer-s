package com.example.demo.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private int id;
    private String name;
    private String composicao;
    private double preco;

    public Cardapio() {
    }

    public Cardapio(String name, String composicao, double preco) {
        this.name = name;
        this.composicao = composicao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void persistirCardapio(Conexao conexao) {

        String sql = "INSERT INTO cardapios(name, composicao, preco) " +
                     "VALUES (?, ?, ?)";

        conexao.executarComando(sql,  this.name,
                                      this.composicao,
                                      this.preco);
             

    }

    public static List<Cardapio> buscarTodos(Conexao conexao) throws SQLException {
        List<Cardapio> lanches = new ArrayList<>();
        String sql = "SELECT id, name, composicao, preco FROM cardapios";
        
        PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Cardapio lanche = new Cardapio(); // Usa o construtor vazio
            lanche.setId(rs.getInt("id"));
            lanche.setName(rs.getString("name"));
            lanche.setComposicao(rs.getString("composicao"));
            lanche.setPreco(rs.getDouble("preco"));
            lanches.add(lanche);
        }

        rs.close();
        ps.close();

        return lanches;
    }
}
