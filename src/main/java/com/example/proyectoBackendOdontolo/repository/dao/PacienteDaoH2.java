package com.example.proyectoBackendOdontolo.repository.dao;

import com.example.proyectoBackendOdontolo.entities.Paciente;
import com.example.proyectoBackendOdontolo.repository.dao.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {
    @Override
    public Paciente guardar(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscar(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return null;
    }
  /*  private static Connection getConection() throws Exception{
        Class.forName("org.h2.Driver").getNestHost();
        return DriverManager.getConnection("jdbc:h2:~/prueba","sa","sa" );
    }
    @Override
    public Paciente guardar(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscar(Integer id) {

        Paciente paciente = null;
        Connection connection = null;

        try {
            connection = getConection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Paciente where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                paciente = new Paciente(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate());


            }}catch(Exception e){
                e.printStackTrace();
            }
        finally{
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }




        return paciente;
    }

        @Override
        public void eliminar (Integer id){

        }

        @Override
        public List<Paciente> buscarTodos () {
            Connection connection = null;
            List<Paciente> listaPaciente = new ArrayList<>();

            try {
                connection = getConection();

                PreparedStatement preparedStatement = connection.prepareStatement("select * from Paciente");
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {

                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException ex) {

                    ex.printStackTrace();
                }

            }
            return null;
        }



    @Override
    public Paciente actualizar(Paciente paciente) {
        return null;
    }*/
}
