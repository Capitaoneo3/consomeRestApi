package com.capitaneo3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class CarroController {
    static String apiBaseUrl = "http://127.0.0.1:8080/";

    static void getAllCarros() {
        try {
            // URL da API que você deseja consumir
            String apiUrl = apiBaseUrl + "carro";

            // Criação da conexão
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Definir o método HTTP (GET, POST, etc.)
            connection.setRequestMethod("GET");

            // Obter a resposta da API
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Tratar a resposta da API
                System.out.println(response.toString());
            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void saveCarro(String marca, String modelo, Integer ano) {
        try {
            // URL da API para enviar o objeto carro
            String apiUrl = apiBaseUrl + "carro";

            // Criar um objeto Carro
            Carro carro = new Carro(marca, modelo, ano);

            // Converter o objeto Carro para JSON
            Gson gson = new Gson();
            String jsonCarro = gson.toJson(carro);

            // Criar a conexão
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Definir o método HTTP como POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            // Habilitar o envio de dados
            connection.setDoOutput(true);

            // Enviar o objeto Carro como payload
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonCarro.getBytes());
            outputStream.flush();

            // Obter a resposta da API
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Objeto Carro enviado com sucesso!");
            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void getCarroPorId(Integer id) {
        try {
            // URL da API que você deseja consumir
            String apiUrl = apiBaseUrl + "carro/" + id;

            // Criação da conexão
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Definir o método HTTP (GET, POST, etc.)
            connection.setRequestMethod("GET");

            // Obter a resposta da API
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Tratar a resposta da API
                System.out.println(response.toString());
            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteCarroPorId(Integer id) {
        try {
            // URL da API que você deseja consumir
            String apiUrl = apiBaseUrl + "carro/" + id;

            // Criação da conexão
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Definir o método HTTP (GET, POST, etc.)
            connection.setRequestMethod("DELETE");

            // Obter a resposta da API
            int responseCode = connection.getResponseCode();
            if (responseCode == 200 || responseCode == 202) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Tratar a resposta da API
                System.out.println(response.toString());
            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteTodosOsCarros() {
        try {
            // URL da API que você deseja consumir
            String apiUrl = apiBaseUrl + "deletarTodosOsCarros";

            // Criação da conexão
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Definir o método HTTP (GET, POST, etc.)
            connection.setRequestMethod("DELETE");

            // Obter a resposta da API
            int responseCode = connection.getResponseCode();
            if (responseCode == 200 || responseCode == 202) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Tratar a resposta da API
                System.out.println(response.toString());
            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
