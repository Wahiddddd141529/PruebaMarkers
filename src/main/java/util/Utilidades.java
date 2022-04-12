package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Utilidades {

    //Prueba Conexión BD
    public ArrayList<String> get_datosNominal() {
        //HashMap<String, String> mapa = new HashMap <String, String> () ;
        ArrayList<String> mapa = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com/sql10484939?user=sql10484939&password=Dy1wkgwKuB");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(90);
            ResultSet resultSet = null;
            String selectSql = "select * from Planta_Nominal;";
            resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                mapa.add(resultSet.getString(3) + ";" + resultSet.getInt(4) + ";" + resultSet.getDouble(5) + ";" + resultSet.getInt(6));
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mapa;
    }

    public HashMap <String, String> get_datosPersona() {
        HashMap<String, String> mapa = new HashMap <String, String> () ;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com/sql10484939?user=sql10484939&password=Dy1wkgwKuB");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(90);
            ResultSet resultSet = null;
            String selectSql = "select * from Datos;";
            resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                mapa.put("Nombre", resultSet.getString(2));
                mapa.put("Apellido", resultSet.getString(3));
                mapa.put("Email", resultSet.getString(4));
                mapa.put("Telefono", resultSet.getString(5));
                mapa.put("Mensaje", resultSet.getString(6));
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mapa;
    }

    public void registrarDatos(String sql) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com/sql10484939?user=sql10484939&password=Dy1wkgwKuB");
            String insertar = sql;
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(90);
            int elementosInsertados = statement.executeUpdate(insertar);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarTabla() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com/sql10484939?user=sql10484939&password=Dy1wkgwKuB");
            String delete = "Drop Table Planta_Nominal";
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(90);
            statement.executeUpdate(delete);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearTabla() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com/sql10484939?user=sql10484939&password=Dy1wkgwKuB");
            String create = "CREATE TABLE `Planta_Nominal` (" +
                    "  `id_Nominal` int(11) NOT NULL primary key auto_increment," +
                    "  `Fecha` varchar(25) NOT NULL," +
                    "  `Portafolio` varchar(25) NOT NULL," +
                    "  `Nominal` int(11) NOT NULL," +
                    "  `Precio` float NOT NULL," +
                    "  `Total` int(11) NOT NULL" +
                    ")";
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(90);
            statement.executeUpdate(create);
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

