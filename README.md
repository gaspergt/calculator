# Calculadora

Este proyecto es una calculadora web que utiliza **React** como frontend y un servicio backend en **Java** que se ejecuta en **AWS Lambda**. El frontend está basado en **Vite**, mientras que el backend se expone mediante un **API Gateway** en AWS, aceptando solicitudes mediante el método POST.

## Requerimientos

Antes de comenzar, asegúrate de tener instalados los siguientes requisitos en tu entorno de desarrollo:

- **Maven** (para construir el servicio backend en Java)
- **JDK** (Java Development Kit)
- **Node.js** (para el frontend basado en Vite)
- **Cuenta de AWS** (para implementar la función Lambda y el API Gateway)

## Estructura del proyecto

El proyecto está dividido en dos componentes principales:

1. **Frontend (React con Vite)**: Proporciona la interfaz gráfica para interactuar con la calculadora.
2. **Backend (Java)**: Se ejecuta como una función **AWS Lambda** y maneja las operaciones matemáticas de la calculadora. La Lambda está expuesta mediante un endpoint de **API Gateway**, permitiendo interacciones HTTP.

## Instalación

### 1. Clonar el repositorio

Clona el repositorio en tu máquina local:

```bash
git clone https://github.com/gaspergt/calculator.git
cd calculator
```

### 2. Branch del Frontend (React con Vite)

En la rama `frontend` encontraremos el código para levantar el proyecto React. Para trabajar con el frontend, cambia a esa rama con el siguiente comando:

```bash
git checkout frontend
```

Luego, sigue estos pasos para levantar el proyecto:

1. **Instalar las dependencias del frontend**:
    ```bash
    npm install
    ```

2. **Ejecutar el frontend en modo desarrollo**:
    ```bash
    npm run dev
    ```

    Esto lanzará el servidor de desarrollo de Vite y la interfaz gráfica estará disponible en `http://localhost:3000`.

> [!IMPORTANT]
> - Para levantar el proyecto React y conectarlo correctamente con AWS, asegúrate de tener una cuenta de AWS y tener configurado el **AWS CLI** en tu entorno. Puedes seguir las instrucciones oficiales de AWS para configurar el CLI [aquí](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-quickstart.html).

### 3. Configuración del Backend (Java)

El servicio backend se ejecuta como una función Lambda en AWS. Para configurarlo, sigue los siguientes pasos:

1. **Compilar el backend** con Maven:
    ```bash
    cd backend
    mvn clean install
    ```

2. **Implementar en AWS Lambda**:
    Utiliza AWS CLI o una herramienta como **Serverless Framework** para implementar la función Lambda. Asegúrate de que la función esté conectada a un **API Gateway** que acepte solicitudes POST.

### 4. Configurar las variables de entorno

Crea un archivo `.env` en la raíz del proyecto `frontend` y añade el siguiente contenido:

```bash
VITE_API_URL=https://<tu-endpoint-de-api-gateway>
```

Reemplaza `<tu-endpoint-de-api-gateway>` con el endpoint de tu API Gateway en AWS.

## Alojar el frontend en un bucket de AWS S3

Si deseas alojar el frontend en un bucket de **AWS S3** y usar **CloudFront** para distribuirlo, sigue estos pasos:

### Prerrequisitos:

- Asegúrate de tener configurada una cuenta en AWS.
- Tener **AWS CLI** configurado en tu entorno.

### Pasos para alojar en S3:

1. **Construir el proyecto para producción**:
    ```bash
    npm run build
    ```

    Esto generará los archivos de producción en la carpeta `dist`.

2. **Crear un bucket de S3**:

    Ejecuta el siguiente comando para crear un bucket de S3 donde alojarás el frontend:
    
    ```bash
    aws s3 mb s3://nombre-del-bucket --region us-east-1
    ```

    Asegúrate de reemplazar `nombre-del-bucket` con un nombre único para tu bucket.

3. **Subir los archivos generados al bucket**:

    Una vez que hayas generado los archivos de producción, súbelos al bucket con este comando:

    ```bash
    aws s3 sync ./dist s3://nombre-del-bucket
    ```

4. **Hacer el bucket de S3 público**:

    Si deseas que los archivos sean accesibles públicamente, tendrás que habilitar el acceso público a los archivos del bucket. Primero, ve a la consola de AWS y cambia las configuraciones de acceso público del bucket.

    Luego, puedes aplicar la siguiente política de bucket para permitir acceso público a los objetos:

    ```json
    {
        "Version": "2012-10-17",
        "Statement": [
            {
                "Sid": "PublicReadGetObject",
                "Effect": "Allow",
                "Principal": "*",
                "Action": "s3:GetObject",
                "Resource": "arn:aws:s3:::nombre-del-bucket/*"
            }
        ]
    }
    ```

    No olvides reemplazar `nombre-del-bucket` con el nombre de tu bucket.

5. **Configurar el bucket para alojamiento de sitios web**:

    En la consola de AWS, en la configuración del bucket, habilita la opción de "Static Website Hosting". Asegúrate de definir un archivo de entrada (como `index.html`).

6. **Opcional: Configurar CloudFront**:

    Si deseas mejorar la distribución de tu aplicación, puedes configurar **CloudFront** para distribuir los archivos del bucket S3 de manera más rápida y globalmente.

    Para hacer esto, ve a la consola de AWS CloudFront y crea una nueva distribución, seleccionando tu bucket de S3 como origen.

## Uso

- Una vez que el frontend y el backend estén configurados y corriendo, puedes acceder a la interfaz gráfica de la calculadora.
- Ingresa las operaciones matemáticas en la calculadora y envía la solicitud, que será procesada por la función Lambda en AWS.

## Despliegue

Para desplegar el proyecto en un entorno de producción, puedes seguir estos pasos:

1. **Frontend**: Puedes construir el frontend para producción con:
    ```bash
    npm run build
    ```
    Luego, sube los archivos generados en la carpeta `dist` a un servicio de hosting estático como **AWS S3** o **Netlify**.

2. **Backend**: Asegúrate de que tu función Lambda y API Gateway estén correctamente configurados en tu cuenta de AWS para manejar las solicitudes.

## Contribuciones

Las contribuciones son bienvenidas. Siéntete libre de abrir un **issue** o un **pull request** con tus sugerencias o mejoras.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
