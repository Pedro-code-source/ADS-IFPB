package br.edu.ifpb.dao;

import br.edu.ifpb.entities.Cliente;
import br.edu.ifpb.Connection.ConnectionFactory;
import br.edu.ifpb.entities.Pedido;
import br.edu.ifpb.interfaces.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements DAO<Cliente> {

    @Override
    public void save(Cliente cliente) {
        String sql = "insert into cliente (nome, telefone, endereco) values (?,?,?)";
        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getTelefone());
            ps.setString(3, cliente.getEndereco());
            ps.executeUpdate();

            try(ResultSet rs = ps.getGeneratedKeys()){
                if (rs.next()){
                    int idGerado = rs.getInt(1);
                    cliente.setId(idGerado);
                }
            }
            System.out.println("Cliente inserido com sucesso!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cliente cliente){
        String sql = "update cliente set nome = ?, telefone = ?, endereco = ? where id = ?";

        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getTelefone());
            ps.setString(3,cliente.getEndereco());
            ps.setInt(4, cliente.getId());
            ps.executeUpdate();

            System.out.println("Informações atualizadas!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cliente> listAll(){
        List<Cliente> lista = new ArrayList<Cliente>();
        String sql = "select * from cliente";

        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getInt("telefone"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lista.forEach(e->
                System.out.println(e.getId()));
        return lista;
    }

    @Override
    public void delete(int id){
        String sql = "delete from cliente where id = ?";
        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

