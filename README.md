
# Calculadora Frontend + API

Esta es una calculadora frontend desplegada en un bucket de **Amazon S3** que está conectada a una API servida a través de **AWS API Gateway**. Puedes utilizar esta calculadora para realizar operaciones básicas como suma, resta, multiplicación y división.

## URL del Frontend

El frontend de la calculadora está disponible en la siguiente URL:

**http://frontend-calculator-luislima.s3-website-us-east-1.amazonaws.com/**

> [!IMPORTANT]
> Asegúrate de acceder a la URL utilizando `http://` y no `https://`, ya que en algunos navegadores puede ocurrir una redirección automática a `https://`, lo cual no es soportado en este caso.

## Funcionamiento de la Calculadora

1. Ingresa la operación matemática utilizando los botones de la calculadora.
2. Cuando presiones el botón `=`, la calculadora enviará una solicitud a la API de backend para procesar la operación y devolver el resultado.
3. La respuesta aparecerá directamente en la pantalla de la calculadora.



¡Disfruta utilizando la calculadora!

