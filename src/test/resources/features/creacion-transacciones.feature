# language: es
@Wompi
Característica: Creación de transacciones
  Como usuario de la API de Wompi
  Quiero crear transacciones con diferentes métodos de pago
  Para validar el procesamiento correcto de cada tipo

  Antecedentes:
    Dado comprador en ambiente de pruebas "UAT"
    Cuando consulta el servicio de merchants con su llave pública
    Entonces el servicio de merchants responde exitosamente
    Y obtiene los tokens de aceptación

  @Transactions @NEQUI
  Escenario: Crear transacción con método de pago NEQUI
    Cuando crea una transacción con los siguientes datos:
      | amount_in_cents | currency | customer_email           | reference     | type  | phone_number |
      | 2500000         | COP      | pepito_perez@example.com | 23422er32y314 | NEQUI | 3991111111   |
    Entonces la transacción se crea exitosamente

  @Transactions @BancolombiaQR
  Escenario: Crear transacción con método de pago BANCOLOMBIA_QR
    Cuando crea una transacción con los siguientes datos:
      | amount_in_cents | currency | customer_email           | reference     | type           | payment_description | sandbox_status |
      | 2500000         | COP      | pepito_perez@example.com | 23225r32u4yd8 | BANCOLOMBIA_QR | Pago a Tienda Wompi | APPROVED       |
    Entonces la transacción se crea exitosamente

  @Transactions @BancolombiaTransfer
  Escenario: Crear transacción con método de pago BANCOLOMBIA_TRANSFER
    Cuando crea una transacción con los siguientes datos:
      | amount_in_cents | currency | customer_email           | reference      | type                 | payment_description | user_type |
      | 2500000         | COP      | pepito_perez@example.com | 23672er3b233d8 | BANCOLOMBIA_TRANSFER | Pago a Tienda Wompi | PERSON    |
    Entonces la transacción se crea exitosamente
