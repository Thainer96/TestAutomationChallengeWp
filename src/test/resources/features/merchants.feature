# language: en
@Wompi
Feature: Consulta de merchants
  Como usuario de la API de Wompi
  Quiero consultar la información de un merchant
  Para obtener los tokens de aceptación necesarios para transacciones

  Background:
    Given un usuario en ambiente de pruebas "UAT"

  @Merchants
  Scenario: Consultar merchant con llave pública válida
    When consulta el servicio de merchants con su llave pública
    Then el servicio de merchants responde exitosamente
