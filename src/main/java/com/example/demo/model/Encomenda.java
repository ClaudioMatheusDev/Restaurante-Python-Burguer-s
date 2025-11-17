package com.example.demo.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Encomenda {
    private int id;
    private int clienteId;
    private int cardapioId;
    private int quantidade;
    private String observacoes;
    private String status;
    private Timestamp dataEncomenda;

    // Para exibição
    private String nomeCliente;
    private String nomeLanche;
    private double precoUnitario;

    public Encomenda() {
    }

    public Encomenda(int clienteId, int cardapioId, int quantidade, String observacoes) {
        this.clienteId = clienteId;
        this.cardapioId = cardapioId;
        this.quantidade = quantidade;
        this.observacoes = observacoes;
        this.status = "Pendente";
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getCardapioId() {
        return cardapioId;
    }

    public void setCardapioId(int cardapioId) {
        this.cardapioId = cardapioId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDataEncomenda() {
        return dataEncomenda;
    }

    public void setDataEncomenda(Timestamp dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeLanche() {
        return nomeLanche;
    }

    public void setNomeLanche(String nomeLanche) {
        this.nomeLanche = nomeLanche;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getValorTotal() {
        return precoUnitario * quantidade;
    }

    public void persistirEncomenda(Conexao conexao) {
        String sql = "INSERT INTO encomendas(cliente_id, cardapio_id, quantidade, observacoes, status) VALUES (?, ?, ?, ?, ?)";
        conexao.executarComando(sql, this.clienteId, this.cardapioId, this.quantidade, this.observacoes, this.status);
    }

    public static List<Encomenda> buscarTodas(Conexao conexao) throws SQLException {
        List<Encomenda> encomendas = new ArrayList<>();
        String sql = "SELECT e.id, e.cliente_id, e.cardapio_id, e.quantidade, e.observacoes, e.status, e.data_encomenda, " +
                     "c.name as nome_cliente, ca.name as nome_lanche, ca.preco " +
                     "FROM encomendas e " +
                     "INNER JOIN clientes c ON e.cliente_id = c.id " +
                     "INNER JOIN cardapios ca ON e.cardapio_id = ca.id " +
                     "ORDER BY e.data_encomenda DESC";
        
        PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Encomenda encomenda = new Encomenda();
            encomenda.setId(rs.getInt("id"));
            encomenda.setClienteId(rs.getInt("cliente_id"));
            encomenda.setCardapioId(rs.getInt("cardapio_id"));
            encomenda.setQuantidade(rs.getInt("quantidade"));
            encomenda.setObservacoes(rs.getString("observacoes"));
            encomenda.setStatus(rs.getString("status"));
            encomenda.setDataEncomenda(rs.getTimestamp("data_encomenda"));
            encomenda.setNomeCliente(rs.getString("nome_cliente"));
            encomenda.setNomeLanche(rs.getString("nome_lanche"));
            encomenda.setPrecoUnitario(rs.getDouble("preco"));
            encomendas.add(encomenda);
        }

        rs.close();
        ps.close();

        return encomendas;
    }
}
