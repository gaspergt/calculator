package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Access-Control-Allow-Origin", "*");
		headers.put("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		headers.put("Access-Control-Allow-Headers",
				"Content-Type, X-Amz-Date, Authorization, X-Api-Key, X-Amz-Security-Token, X-Amz-User-Agent");

		if ("OPTIONS".equalsIgnoreCase((String) input.get("httpMethod"))) {
			return ApiGatewayResponse.builder()
					.setStatusCode(200)
					.setHeaders(headers)
					.build();
		}

		try {
			System.out.println("Input received: " + input);

			if (!input.containsKey("body")) {
				return ApiGatewayResponse.builder()
						.setStatusCode(400)
						.setObjectBody("Missing body in the request")
						.setHeaders(headers)
						.build();
			}

			String bodyString = (String) input.get("body");
			System.out.println("Body as string: " + bodyString);
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> body = objectMapper.readValue(bodyString, Map.class);
			System.out.println("Parsed body: " + body);

			// Obtenemos la expresión matemática
			String expression = (String) body.get("expression");

			// Sanitizamos la expresión
			String sanitizedExpression = expression.replace("×", "*").replace("÷", "/").replace("−", "-");

			// Evaluamos la expresión de manera segura
			double result = evaluateExpression(sanitizedExpression);

			Map<String, Object> responseBody = new HashMap<>();
			responseBody.put("result", result);

			return ApiGatewayResponse.builder()
					.setStatusCode(200)
					.setObjectBody(responseBody)
					.setHeaders(headers)
					.build();

		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
			e.printStackTrace();
			return ApiGatewayResponse.builder()
					.setStatusCode(500)
					.setObjectBody("Error processing request: " + e.getMessage())
					.setHeaders(headers)
					.build();
		}
	}

	// Método para evaluar la expresión de manera segura
	private double evaluateExpression(String expression) throws Exception {
		// Usamos la librería exp4j para evaluar la expresión
		Expression e = new ExpressionBuilder(expression).build();
		return e.evaluate();
	}
}