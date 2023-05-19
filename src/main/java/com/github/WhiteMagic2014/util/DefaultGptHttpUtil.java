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
            if (connection.getResponseCode() == 200) {
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
            } else {
                try (InputStream errorStream = connection.getErrorStream();
                     InputStreamReader inputStreamReader = new InputStreamReader(errorStream, StandardCharsets.UTF_8);
                     BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                throw new RuntimeException(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
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
        OutputStream os = null;
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

            os = connection.getOutputStream();
            os.write(jsonParam.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();

            StringBuilder sb = new StringBuilder();
            if (connection.getResponseCode() == 200) {
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
            } else {
                try (InputStream errorStream = connection.getErrorStream();
                     InputStreamReader inputStreamReader = new InputStreamReader(errorStream, StandardCharsets.UTF_8);
                     BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                throw new RuntimeException(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
    }


    @Override
    public String post(String path, String key, String org, JSONObject jsonParam, OutputStream outputStream) {
        URL url = null;
        try {
            url = new URL(path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        HttpURLConnection connection = null;
        OutputStream os = null;
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

            os = connection.getOutputStream();
            os.write(jsonParam.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();

            if (connection.getResponseCode() == 200) {
                try (InputStream inputStream = connection.getInputStream();) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                return "success, the data will be output to the provided OutputStream.";
            } else {
                StringBuilder sb = new StringBuilder();
                try (InputStream errorStream = connection.getErrorStream();
                     InputStreamReader inputStreamReader = new InputStreamReader(errorStream, StandardCharsets.UTF_8);
                     BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                throw new RuntimeException(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
        OutputStream os = null;
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

            os = connection.getOutputStream();
            for (String mapKey : param.keySet()) {
                Object data = param.get(mapKey);
                os.write((dash + boundary + newLine).getBytes(StandardCharsets.UTF_8));
                if (data instanceof File) {
                    String fileHeader = "Content-Disposition: form-data; name=\"" + mapKey + "\"; filename=\"" + ((File) data).getName() + "\"" + newLine +
                            "Content-Type:" + getContentType((File) data) + newLine +
                            newLine;
                    os.write(fileHeader.getBytes(StandardCharsets.UTF_8));
                    ins = new FileInputStream((File) data);
                    int b = -1;
                    byte[] bufferOut = new byte[1024];
                    while ((b = ins.read(bufferOut)) != -1) {
                        os.write(bufferOut, 0, b);
                    }
                    os.write(newLine.getBytes(StandardCharsets.UTF_8));
                } else {
                    String formData = "Content-Disposition: form-data; name=\"" + mapKey + "\"" + newLine +
                            newLine +
                            data.toString() + newLine;
                    os.write(formData.getBytes(StandardCharsets.UTF_8));
                }
            }
            os.write((dash + boundary + dash + newLine).getBytes(StandardCharsets.UTF_8));
            os.flush();
            StringBuilder sb = new StringBuilder();
            if (connection.getResponseCode() == 200) {
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
            } else {
                try (InputStream errorStream = connection.getErrorStream();
                     InputStreamReader inputStreamReader = new InputStreamReader(errorStream, StandardCharsets.UTF_8);
                     BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                throw new RuntimeException(sb.toString());
            }
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
            if (connection.getResponseCode() == 200) {
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
            } else {
                try (InputStream errorStream = connection.getErrorStream();
                     InputStreamReader inputStreamReader = new InputStreamReader(errorStream, StandardCharsets.UTF_8);
                     BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                throw new RuntimeException(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
