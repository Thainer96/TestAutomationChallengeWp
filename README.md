# Wompi API Test Automation

Framework de automatización de pruebas para las APIs de Wompi, implementado con **Serenity BDD** y el patrón **Screenplay**.

## Tecnologías

- Java 17
- Maven 3.9+
- Serenity BDD 4.2.12
- Cucumber 7.20.1
- Screenplay Pattern
- Rest Assured (integrado vía Serenity)

## Arquitectura

El proyecto sigue el patrón **Screenplay** con Serenity BDD:

```
src/test/java/com/wompi/test/
├── abilities/       → Capacidades del actor (CallWompiApi)
├── tasks/           → Acciones que el actor ejecuta (GetMerchant, CreateTransaction)
├── questions/       → Preguntas sobre el estado (ResponseStatusCode, MerchantData)
├── builders/        → Construcción de objetos de request (TransactionBuilder)
├── models/request/  → POJOs para los bodies de las peticiones
├── config/          → Configuración de ambientes y credenciales
├── utils/           → Utilidades (generación de firma SHA-256)
├── stepdefinitions/ → Definiciones de pasos Cucumber
├── hooks/           → Hooks de Cucumber (setup del Stage)
└── runner/          → Runner de Serenity + Cucumber
```

## Configuración

### Variables de entorno requeridas

Las credenciales se manejan mediante variables de entorno (nunca en el repositorio):

```bash
export WOMPI_PUBLIC_KEY=pub_stagtest_xxxxx
export WOMPI_PRIVATE_KEY=prv_stagtest_xxxxx
export WOMPI_EVENT_KEY=stagtest_events_xxxxx
export WOMPI_INTEGRITY_KEY=stagtest_integrity_xxxxx
```

### Ambientes

Los ambientes se configuran en `src/test/resources/serenity.conf`.

## Ejecución

### Ejecutar todos los tests

```bash
mvn clean verify
```

### Ejecutar por tag

```bash
mvn clean verify -Dcucumber.filter.tags="@Merchants"
mvn clean verify -Dcucumber.filter.tags="@Transactions"
mvn clean verify -Dcucumber.filter.tags="@NEQUI"
```

### Generar reporte Serenity

El reporte se genera automáticamente después de `mvn verify`. Se encuentra en:

```
target/site/serenity/index.html
```

## APIs automatizadas

| Método | Endpoint       | Descripción                          |
|--------|----------------|--------------------------------------|
| GET    | /merchants/{key} | Consulta información del merchant  |
| POST   | /transactions    | Crea una transacción               |

### Métodos de pago soportados

- NEQUI
- BANCOLOMBIA_QR
- BANCOLOMBIA_TRANSFER
