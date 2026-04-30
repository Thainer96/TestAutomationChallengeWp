# language: en
@Wompi
Feature: Creación de transacciones
  Como usuario de la API de Wompi
  Quiero crear transacciones con diferentes métodos de pago
  Para validar el procesamiento correcto de cada tipo

  Background:
    Given un usuario en ambiente de pruebas "UAT"
    When consulta el servicio de merchants con su llave pública
    Then el servicio de merchants responde exitosamente
    And obtiene los tokens de aceptación

  @Transactions @NEQUI
  Scenario: Crear transacción con método de pago NEQUI
    When crea una transacción con los siguientes datos:
      | amount_in_cents | currency | customer_email           | reference     | type  | phone_number | payment_description | sandbox_status | user_type |
      | 2500000         | COP      | pepito_perez@example.com | 23422er32y314 | NEQUI | 3107654321   | pago wompi test     | APPROVED       | PERSON    |
    Then la transacción se crea exitosamente

  @Transactions @BancolombiaQR
  Scenario: Crear transacción con método de pago BANCOLOMBIA_QR
    When crea una transacción con los siguientes datos:
      | amount_in_cents | currency | customer_email           | reference     | type           | phone_number | payment_description | sandbox_status | user_type |
      | 2500000         | COP      | pepito_perez@example.com | 23225r32u4yd8 | BANCOLOMBIA_QR | 3107654321   | pago wompi test     | APPROVED       | PERSON    |
    Then la transacción se crea exitosamente

  @Transactions @PCOL
  Scenario: Crear transacción con método de pago PCOL
    When crea una transacción con los siguientes datos:
      | amount_in_cents | currency | customer_email           | reference      | type | phone_number | payment_description | sandbox_status       | user_type |
      | 2500000         | COP      | pepito_perez@example.com | 22er1323v34td8 | PCOL | 3107654321   | pago wompi test     | APPROVED_ONLY_POINTS | PERSON    |
    Then la transacción se crea exitosamente

  @Transactions @BancolombiaTransfer
  Scenario: Crear transacción con método de pago BANCOLOMBIA_TRANSFER
    When crea una transacción con los siguientes datos:
      | amount_in_cents | currency | customer_email           | reference      | type                 | phone_number | payment_description | sandbox_status       | user_type |
      | 2500000         | COP      | pepito_perez@example.com | 23672er3b233d8 | BANCOLOMBIA_TRANSFER | 3107654321   | pago wompi test     | APPROVED_ONLY_POINTS | PERSON    |
    Then la transacción se crea exitosamente
