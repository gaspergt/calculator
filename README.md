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
