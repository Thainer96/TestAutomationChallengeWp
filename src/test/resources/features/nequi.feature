# language: es
@Wompi @NEQUI
Característica: Transacciones con método de pago NEQUI
  Como usuario de la API de Wompi
  Quiero crear transacciones con NEQUI usando diferentes números de teléfono
  Para validar que la API acepta la creación independientemente del estado final

  Antecedentes:
    Dado comprador en ambiente de pruebas "UAT"
    Cuando consulta el servicio de merchants con su llave pública
    Entonces el servicio de merchants responde exitosamente
    Y obtiene los tokens de aceptación

  @Transactions
  Esquema del escenario: Crear transacción NEQUI con número <phone_number>
    Cuando crea una transacción con los siguientes datos:
      | amount_in_cents   | currency   | customer_email   | reference   | type   | phone_number   |
      | <amount_in_cents> | <currency> | <customer_email> | <reference> | <type> | <phone_number> |
    Entonces la transacción se crea exitosamente

    Ejemplos:
      | amount_in_cents | currency | customer_email           | reference       | type  | phone_number |
      | 2500000         | COP      | pepito_perez@example.com | nequiapproved01 | NEQUI | 3991111111   |
      | 1500000         | COP      | pepito_perez@example.com | nequideclined01 | NEQUI | 3992222222   |
      | 3000000         | COP      | pepito_perez@example.com | nequierror01    | NEQUI | 3107654321   |
