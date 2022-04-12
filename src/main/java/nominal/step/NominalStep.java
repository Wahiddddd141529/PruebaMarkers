package nominal.step;

import net.thucydides.core.annotations.Step;
import nominal.models.Nominal;
import util.Utilidades;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import nominal.models.Nominal;

public class NominalStep {

    Utilidades util = new Utilidades();

    public static String Fecha;
    public static String Portafolio;
    public static int Nominal;
    public static double Precio;
    public static int Total;
    int calculo;

    @Step
    public void insertNominal(List <Nominal> datosNominal)throws Exception{
        try {
            int i = 0;
            while (i < 4){
                Fecha = datosNominal.get(i).getFecha();
                Portafolio = datosNominal.get(i).getPortafolio();
                Nominal = datosNominal.get(i).getNominal();
                Precio = Double.parseDouble(datosNominal.get(i).getPrecio());
                Total = datosNominal.get(i).getTotal();
                String sql = "INSERT INTO Planta_Nominal (Fecha, Portafolio, Nominal, Precio, Total) Values " +
                        "('"+Fecha+"','"+Portafolio+"',"+Nominal+","+Precio+", "+Total+")";
                util.registrarDatos(sql);
                i++;
            }
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    @Step
    public void calculoNominal() throws Exception {
        try {
            ArrayList<String>mapas = util.get_datosNominal();
            if (mapas.size() > 0) {
                for (int i=0;i < mapas.size(); i++) {
                    String[] map = mapas.get(i).split(";");
                    Portafolio = map[0];
                    Nominal = Integer.parseInt(map[1]);
                    Precio = Double.parseDouble(String.valueOf(Double.parseDouble(map[2])));
                    Total = Integer.parseInt(map[3]);
                    if (Portafolio.equalsIgnoreCase("OBL-MODER")) {
                        calculo = (int) (Nominal * Precio);
                        System.out.println("El calculo es: " + calculo);
                        if (calculo == Total) {
                            System.out.println("Son iguales");
                        } else {
                            System.out.println("Validar calculo OBL-MODER");
                        }
                    } else if (Portafolio.equalsIgnoreCase("OBL-RIESGO")) {
                        calculo = (int) (Nominal * Precio + 2000);
                        System.out.println("El calculo es: " + calculo);
                        if (calculo == Total) {
                            System.out.println("Son iguales");
                        } else {
                            System.out.println("Validar calculo OBL-RIESGO");
                        }
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Step
    public void deleteTable() throws SQLException {
        //Por si se quiere hacer la prueba en caliente, dejo un borrar tabla para usar cuanta veces se necesite - INI
        util.borrarTabla();
        //Por si se quiere hacer la prueba en caliente, dejo un borrar tabla para usar cuanta veces se necesite - FIN
    }

    @Step
    public void createTable() throws SQLException {
        //Crear Tabla - INI
        util.crearTabla();
        //Crear Tabla - FIN
    }
}
