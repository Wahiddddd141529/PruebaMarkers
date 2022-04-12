#language:es
Característica: Prueba tecnica – Automatización

  @ManejoSelenium
  Escenario: Segundo escenario - Manejo de selenium
    Dada la siguiente url "https://somosmakers.co/"
    Cuando hacemos clic en el enlace de "CONTACTO"
    Entonces capturar el numero de celular de servicio al cliente
    Y llenar el formulario "dejanos un mensaje" y en el campo mensaje adjuntar el numero de celular capturado
    Y antes de hacer clic en el boton "enviar mensaje" tomar un pantallazo con la informacion diligenciada