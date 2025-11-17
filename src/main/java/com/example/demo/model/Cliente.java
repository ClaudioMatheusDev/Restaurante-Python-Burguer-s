package com.example.demo.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Cliente {
    private int id;
    private String name;
    private String email;
    private String phone;

    public Cliente() {
    }

    public Cliente(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void persistirCliente(Conexao conexao) {
        String sql = "INSERT INTO clientes(name, email, phone) VALUES (?, ?, ?)";
        conexao.executarComando(sql, this.name, this.email, this.phone);
    }

    public static List<Cliente> buscarTodos(Conexao conexao) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, name, email, phone FROM clientes";
        
        PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setName(rs.getString("name"));
            cliente.setEmail(rs.getString("email"));
            cliente.setPhone(rs.getString("phone"));
            clientes.add(cliente);
        }

        rs.close();
        ps.close();

        return clientes;
    }

    public static Cliente buscarPorId(Conexao conexao, int id) throws SQLException {
        String sql = "SELECT id, name, email, phone FROM clientes WHERE id = ?";
        
        PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Cliente cliente = null;
        if (rs.next()) {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setName(rs.getString("name"));
            cliente.setEmail(rs.getString("email"));
            cliente.setPhone(rs.getString("phone"));
        }

        rs.close();
        ps.close();

        return cliente;
    }

}
