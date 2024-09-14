
# Calculadora API

Esta API te permite realizar operaciones matemáticas básicas (suma, resta, multiplicación, división) mediante solicitudes **POST**. La API está servida a través de **AWS API Gateway** y puedes probarla utilizando **Postman** o cualquier otro cliente HTTP.

## URL Base de la API

```
https://obgirtk09l.execute-api.us-east-1.amazonaws.com/dev/calculate
```

## Método: `POST`

### Body de la solicitud

El cuerpo de la solicitud debe ser un JSON con el siguiente formato:

```json
{
  "expression": "5+5"
}
```

- **expression**: Una cadena que contiene la operación matemática que deseas realizar. Puede ser una suma (`+`), resta (`-`), multiplicación (`*`), o división (`/`).

### Ejemplo de solicitud

Puedes probar la API utilizando **Postman** siguiendo los pasos a continuación:

1. Abre **Postman** y crea una nueva solicitud.
2. Selecciona el método **POST**.
3. En la URL de la solicitud, ingresa la siguiente dirección:
   ```
   https://obgirtk09l.execute-api.us-east-1.amazonaws.com/dev/calculate
   ```
4. En la pestaña **Body**, selecciona la opción **raw** y luego **JSON** como el tipo de contenido.
5. Ingresa el siguiente JSON como cuerpo de la solicitud:

   ```json
   {
     "expression": "5+5"
   }
   ```

6. Haz clic en **Send** para enviar la solicitud.

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

¡Feliz cálculo!
