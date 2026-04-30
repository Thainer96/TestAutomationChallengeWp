# language: es
@Wompi
Característica: Consulta de merchants
  Como usuario de la API de Wompi
  Quiero consultar la información de un merchant
  Para obtener los tokens de aceptación necesarios para transacciones

  Antecedentes:
    Dado un usuario en ambiente de pruebas "UAT"

  @Merchants
  Escenario: Consultar merchant con llave pública válida
    Cuando consulta el servicio de merchants con su llave pública
    Entonces el servicio de merchants responde exitosamente
