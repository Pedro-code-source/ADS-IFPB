package br.edu.ifpb.dao;

import br.edu.ifpb.Connection.ConnectionFactory;
import br.edu.ifpb.entities.Pedido;
import br.edu.ifpb.interfaces.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements DAO<Pedido> {

    @Override
    public void save(Pedido obj) {
        String sql = "insert into pedido (formadepagamento, status, valorfinal) values (?,?,?)";
        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){

            ps.setString(1, obj.getFormaDePagamento());
            ps.setString(2, obj.getStatus());
            ps.setDouble(3, obj.getValorFinal());
            ps.executeUpdate();

            try(ResultSet rs = ps.getGeneratedKeys()){
                if (rs.next()){
                    int idGerado = rs.getInt(1);
                    obj.setId(idGerado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Pedido obj) {
        String sql = "update pedido set formadepagamento = ?, status = ?, valorfinal = ? where id = ?";
        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){

            ps.setString(1, obj.getFormaDePagamento());
            ps.setString(2, obj.getStatus());
            ps.setDouble(3, obj.getValorFinal());
            ps.setInt(4, obj.getId());
            ps.executeUpdate();

            System.out.println("Informação atualizada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Pedido> listAll(){
        String sql = "select * from pedido";
        List<Pedido> lista = new ArrayList<>();
        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setFormaDePagamento(rs.getString("formadepagamento"));
                pedido.setStatus(rs.getString("status"));
                pedido.setValorFinal(rs.getDouble("valorfinal"));
                lista.add(pedido);
            }


        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        lista.forEach(e -> {
            System.out.println(e.getId());
        });
        return lista;
    }

    @Override
    public void delete(int index) {
        String sql = "delete from pedido where id = ?";
        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, index);
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();}
    }
}
