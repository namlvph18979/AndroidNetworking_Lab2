package com.example.lab2_androidnetworking;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Get_Http extends AsyncTask<String,Void,String> {

    TextView tv;
    Context context;

    public Get_Http(TextView tv, Context context) {
        this.tv = tv;
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String noiDung = "";
            try {
                // Tạo ra đối tượng URL
                URL url = new URL( strings[0] );

                //2. Mở kết nối
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //3. Tạo đối tượng đọc luồng dữ liệu
                InputStream inputStream = conn.getInputStream();
                //4. Tạo bộ đệm đọc dữ liệu
                BufferedReader reader= new BufferedReader( new InputStreamReader( inputStream) );

                //5. Tạo biến ghép nối kết quả đọc
                StringBuilder builder = new StringBuilder();
                String dong;
                while (   (dong = reader.readLine())  != null     ){
                    builder.append(dong)
                            .append("\n");
                }
                // kết thúc vòng lặp là đọc hết nội dung
                reader.close();
                inputStream.close();
                conn.disconnect();
                noiDung = builder.toString();  // hoàn thiện dữ liệu vào nội dung.
                Log.e("Tag","noi dung"+noiDung);

            }catch (Exception e) {
                e.printStackTrace();
            }

            return noiDung;
        }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tv.setText(s);
        Log.e("TAG", "onPostExecute: "+s );
    }
}
