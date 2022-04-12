#language:es
Característica: Prueba técnica – Automatización

  Antecedentes: Definir los parametros previos
    Dados los siguientes parametros de entrada
      | fecha      | portafolio | nominal | precio | total     |
      | 15/05/2020 | OBL-MODER  | 123000  | 23.65  | 2908950   |
      | 15/05/2020 | OBL-MODER  | 10000   | 25.00  | 250000    |
      | 15/05/2020 | OBL-RIESGO | 1276987 | -10.20 | -13023267 |
      | 15/05/2020 | OBL-RIESGO | 123000  | 1.29   | 160670    |
    Entonces debo insertar los registros en la base datos

  @CruceInformacion
  Escenario: Primer escenario - Calculos y cruce informacion
    Dado los parametros de entrada previos
    Cuando debo calcular el valor total asi [nominal * precio]
    Pero si el portafolio es OBL-RIESGO se debe calcular el valor total asi [(nominal * precio) + '2000']
    Entonces validar que el valor total calculado sea igual al campo total de la base de dato