# language: es
@Wompi
Característica: Consulta de merchants
  Como usuario de la API de Wompi
  Quiero consultar la información de un merchant
  Para obtener los tokens de aceptación necesarios para transacciones

  Antecedentes:
    Dado comercio en ambiente de pruebas "UAT"

  @Merchants
  Escenario: Consultar merchant con llave pública válida
    Cuando consulta el servicio de merchants con su llave pública
    Entonces el servicio de merchants responde exitosamente

  @Merchants @Alterno
  Escenario: Consultar merchant con llave pública inválida
    Cuando consulta el servicio de merchants con llave pública "pub_invalid_key_12345"
    Entonces el servicio de merchants responde con código 422

  @Merchants @Alterno
  Escenario: Consultar merchant con llave pública vacía
    Cuando consulta el servicio de merchants con llave pública ""
    Entonces el servicio de merchants responde con código 401
