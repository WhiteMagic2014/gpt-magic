package com.github.WhiteMagic2014.util;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @Description: GptHttpUtil Implemented HttpURLConnection
 * Default implemented HttpURLConnection to make this project more universal
 * @author: magic chen
 * @date: 2023/2/22 15:48
 **/
public class DefaultGptHttpUtil implements GptHttpUtil {

    boolean useCaches = false;
    int connectTimeOut = 10000;// default 10s
    int readTimeout = 30000;// default 30s


    public DefaultGptHttpUtil() {
    }

    public DefaultGptHttpUtil(boolean useCaches, int connectTimeOut, int readTimeout) {
        this.useCaches = useCaches;
        this.connectTimeOut = connectTimeOut;
        this.readTimeout = readTimeout;
    }

    @Override
    public String get(String path, String key, String org) {
        URL url = null;
        try {
            url = new URL(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(false);
            connection.setDoInput(true);
            connection.setUseCaches(useCaches);
            connection.setConnectTimeout(connectTimeOut);
            connection.setReadTimeout(readTimeout);
            connection.setRequestMethod("GET");
            if (key != null) {
                connection.setRequestProperty("Authorization", "Bearer " + key);
            }
            if (org != null) {
                connection.setRequestProperty("OpenAI-Organization", org);
            }
            connection.connect();
            StringBuilder sb = new StringBuilder();
            try (InputStream inputStream = connection.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }


    @Override
    public String post(String path, String key, String org, JSONObject jsonParam) {
        URL url = null;
        try {
            url = new URL(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        HttpURLConnection connection = null;
        DataOutputStream os = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(useCaches);
            connection.setConnectTimeout(connectTimeOut);
            connection.setReadTimeout(readTimeout);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "application/json");
            if (key != null) {
                connection.setRequestProperty("Authorization", "Bearer " + key);
            }
            if (org != null) {
                connection.setRequestProperty("OpenAI-Organization", org);
            }
            connection.connect();

            os = new DataOutputStream(connection.getOutputStream());
            os.writeBytes(jsonParam.toString());
            os.flush();

            StringBuilder sb = new StringBuilder();
            try (InputStream inputStream = connection.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    /**
     * Boundary character
     */
    private static final String dash = "--";
    private static final String boundary = "ThisIsMagicDefaultGptHttpUtil";
    private static final String newLine = "\r\n";

    @Override
    public String post(String path, String key, String org, Map<String, Object> param) {
        URL url = null;
        try {
            url = new URL(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        HttpURLConnection connection = null;
        DataOutputStream os = null;
        FileInputStream ins = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(useCaches);
            connection.setConnectTimeout(connectTimeOut);
            connection.setReadTimeout(readTimeout);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (key != null) {
                connection.setRequestProperty("Authorization", "Bearer " + key);
            }
            if (org != null) {
                connection.setRequestProperty("OpenAI-Organization", org);
            }
            connection.connect();

            os = new DataOutputStream(connection.getOutputStream());
            for (String mapKey : param.keySet()) {
                Object data = param.get(mapKey);
                os.writeBytes(dash + boundary + newLine);
                if (data instanceof File) {
                    String fileHeader = "Content-Disposition: form-data; name=\"" + mapKey + "\"; filename=\"" + ((File) data).getName() + "\"" + newLine +
                            "Content-Type:" + getContentType((File) data) + newLine +
                            newLine;
                    os.writeBytes(fileHeader);
                    ins = new FileInputStream((File) data);
                    int b = -1;
                    byte[] bufferOut = new byte[1024];
                    while ((b = ins.read(bufferOut)) != -1) {
                        os.write(bufferOut, 0, b);
                    }
                    os.writeBytes(newLine);
                } else {
                    String formData = "Content-Disposition: form-data; name=\"" + mapKey + "\"" + newLine +
                            newLine +
                            data.toString() + newLine;
                    os.writeBytes(formData);
                }
            }
            os.writeBytes(dash + boundary + dash + newLine);
            os.flush();
            StringBuilder sb = new StringBuilder();
            try (InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (ins != null) {
                    ins.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public String delete(String path, String key, String org) {
        URL url = null;
        try {
            url = new URL(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(false);
            connection.setDoInput(true);
            connection.setUseCaches(useCaches);
            connection.setConnectTimeout(connectTimeOut);
            connection.setReadTimeout(readTimeout);
            connection.setRequestMethod("DELETE");
            if (key != null) {
                connection.setRequestProperty("Authorization", "Bearer " + key);
            }
            if (org != null) {
                connection.setRequestProperty("OpenAI-Organization", org);
            }
            connection.connect();
            StringBuilder sb = new StringBuilder();
            try (InputStream inputStream = connection.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

}
