package ru.sofia.market;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Reader {
    public Double[] getCurr(String filename, String path) {
        Double k[] = new Double[3];
        try {
            File file = new File(path, filename);
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                String nextLine = scanner.nextLine();
                Scanner num = new Scanner(nextLine);
                k[0] = num.nextDouble();
                k[1] = num.nextDouble();
                k[2] = num.nextDouble();
            } else {
                URL url = new URL("https://forex.1forge.com/1.0.3/quotes?pairs=USDRUB,EURUSD&api_key=2DEw6Q2jlPSy250zGBQp1rIJ" +
                        "hC3ZlHXx");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                if (connection.getResponseCode() == 200) {
                    BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String s;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((s = inputStream.readLine()) != null) {
                        stringBuilder.append(s);
                    }
                    System.out.println(stringBuilder);
                    JSONParser jsonParser = new JSONParser();
                    JSONArray jsonArray = (JSONArray)  jsonParser.parse(stringBuilder.toString());
                    System.out.println(jsonArray);

                    JSONObject USDRUB = (JSONObject) jsonArray.get(0);
                    JSONObject EURUSD = (JSONObject) jsonArray.get(1);
                    Double usdrub = (Double) USDRUB.get("price");
                    System.out.println(usdrub);
                    Double erusd = (Double) EURUSD.get("price");
                    System.out.println(erusd);
                    FileWriter fileWriter = new FileWriter(path + filename);
                    fileWriter.write("1 " + usdrub.toString().replace(".", ",") + " " + erusd.toString().replace(".", ","));
                    fileWriter.close();

                    k[0] = 1.;
                    k[1] = usdrub;
                    k[2] = erusd;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return k;
    }
}
