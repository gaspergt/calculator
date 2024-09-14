
# Calculadora Frontend + API

Esta es una calculadora frontend desplegada en un bucket de **Amazon S3** que está conectada a una API servida a través de **AWS API Gateway**. Puedes utilizar esta calculadora para realizar operaciones básicas como suma, resta, multiplicación y división.

## URL del Frontend

El frontend de la calculadora está disponible en la siguiente URL:

**http://frontend-calculator-luislima.s3-website-us-east-1.amazonaws.com/**

> **Importante**: Asegúrate de acceder a la URL utilizando `http://` y no `https://`, ya que en algunos navegadores puede ocurrir una redirección automática a `https://`, lo cual no es soportado en este caso.

## Funcionamiento de la Calculadora

1. Ingresa la operación matemática utilizando los botones de la calculadora.
2. Cuando presiones el botón `=`, la calculadora enviará una solicitud a la API de backend para procesar la operación y devolver el resultado.
3. La respuesta aparecerá directamente en la pantalla de la calculadora.

## Detalles de la API

La API está desplegada en **AWS API Gateway** y puedes probarla directamente utilizando **Postman** o cualquier otro cliente HTTP.

### URL de la API

```
https://obgirtk09l.execute-api.us-east-1.amazonaws.com/dev/calculate
```

### Método: `POST`

### Body de la solicitud

El cuerpo de la solicitud debe ser un JSON con el siguiente formato:

```json
{
  "expression": "5+5"
}
```

- **expression**: Una cadena que contiene la operación matemática que deseas realizar. Puede ser una suma (`+`), resta (`-`), multiplicación (`*`), o división (`/`).

### Ejemplo de respuesta

Si la solicitud es exitosa, recibirás una respuesta como la siguiente:

```json
{
  "statusCode": 200,
  "body": "10.0"
}
```

- **statusCode**: El código de estado HTTP.
- **body**: El resultado de la operación matemática.

### Códigos de respuesta

- `200 OK`: La operación fue exitosa y la respuesta contiene el resultado.
- `400 Bad Request`: La solicitud no es válida, por ejemplo, si la expresión matemática es incorrecta.
- `500 Internal Server Error`: Ocurrió un error en el servidor mientras se procesaba la solicitud.

### Notas

- Asegúrate de que el formato de la expresión matemática sea válido antes de enviar la solicitud.
- La API actualmente admite solo una operación matemática por solicitud (por ejemplo, `5+5` o `10/2`).

---

¡Disfruta utilizando la calculadora!
