package com.abbot.http.lib;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyClass {
    private OkHttpClient mClient = new OkHttpClient();

    private String run(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = mClient.newCall(request).execute();

            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        String content = myClass.run("http://www.imooc.com");
        System.out.println(content);
    }
}
