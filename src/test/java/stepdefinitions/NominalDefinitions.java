package stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Dados;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import nominal.models.Nominal;
import nominal.step.NominalStep;

import java.sql.SQLException;
import java.util.List;

public class NominalDefinitions {

    @Steps
    NominalStep objNominalStep;

    @Dados("^los siguientes parametros de entrada$")
    public void losSiguientesParametrosDeEntrada(List <Nominal> datosNominal) throws Exception {
        objNominalStep.insertNominal(datosNominal);
    }

    @Entonces("^debo insertar los registros en la base datos$")
    public void deboInsertarLosRegistrosEnLaBaseDatos() {

    }

    @Dado("^los parametros de entrada previos$")
    public void los_parametros_de_entrada_previos() throws Exception {

    }

    @Cuando("^debo calcular el valor total asi \\[nominal \\* precio\\]$")
    public void deboCalcularElValorTotalAsiNominalPrecio() throws Exception {
        objNominalStep.calculoNominal();
    }

    @Cuando("^si el portafolio es OBL-RIESGO se debe calcular el valor total asi \\[\\(nominal \\* precio\\) \\+ '(\\d+)'\\]$")
    public void siElPortafolioEsOBLRIESGOSeDebeCalcularElValorTotalAsiNominalPrecio(int arg1) {

    }

    @Entonces("^validar que el valor total calculado sea igual al campo total de la base de dato$")
    public void validar_que_el_valor_total_calculado_sea_igual_al_campo_total_de_la_base_de_dato() throws SQLException {
        objNominalStep.deleteTable();
        objNominalStep.createTable();
    }

}
