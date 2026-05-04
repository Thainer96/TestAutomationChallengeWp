# Wompi API Test Automation

Pruebas automatizadas de integración para las APIs de Wompi usando Serenity BDD con el patrón Screenplay.

## Stack

- Java 17
- Serenity BDD 4.2.12 + Screenplay
- Cucumber 7.20.1 (Gherkin en español)
- Maven + Failsafe

## Cómo ejecutar

Copiar `.env.example` a `.env` y completar con las credenciales del sandbox:

```bash
cp .env.example .env
```

Ejecutar los tests:

```bash
mvn clean verify
```

Ejecutar por tag:

```bash
mvn clean verify "-Dcucumber.filter.tags=@Merchants"
mvn clean verify "-Dcucumber.filter.tags=@Transactions"
```

El reporte Serenity se genera en `target/site/serenity/index.html`.

## Estructura del proyecto

```
src/test/java/com/wompi/test/
├── abilities/         Capacidades del actor
├── builders/          Construcción de requests
├── config/            Ambientes, endpoints, credenciales
├── hooks/             Setup de Cucumber
├── models/request/    POJOs con Lombok
├── questions/         Extracción de datos de respuesta
├── runner/            Runner Serenity + Cucumber
├── stepdefinitions/   Pasos Cucumber en español
├── tasks/             Acciones HTTP del actor
└── utils/             Firma SHA-256
```

## Escenarios cubiertos

**Merchants (GET)**
- Consulta exitosa con llave pública válida
- Consulta con llave inválida (422)
- Consulta con llave vacía (401)

**Transacciones (POST)**
- Creación exitosa con NEQUI, BANCOLOMBIA_QR, BANCOLOMBIA_TRANSFER
- Esquema del escenario con variaciones de NEQUI (aprobado, declinado, error)
- Rechazo por moneda no soportada (422)
- Rechazo por monto cero (422)
- Rechazo por email inválido (422)
