package com.example.douyincheck;

import android.util.Log;

import com.baidu.aip.contentcensor.AipContentCensor;
import com.baidu.aip.contentcensor.EImgType;

import org.json.JSONException;
import org.json.JSONObject;


public class baiduYunCheck {
    static AipContentCensor client;
    //设置APPID/AK/SK
    public static final String APP_ID = "22860053";
    public static final String API_KEY = "na1bnGErbF3U0PIei5vnlkox";
    public static final String SECRET_KEY = "6IqOPzaUGSqpCPNQR43P4n79xOUfGulZ";

    public baiduYunCheck() {
        // 初始化一个AipContentCensor
        client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
            /*client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
            client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理*/
        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
        // 调用接口
    }

    public String getResult(String url) {
        //String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1603367708&di=ef1ed491d851ad6e410e7277dd785933&src=http://pic.feizl.com/upload/allimg/170614/1QR95224-5.jpg";
        JSONObject response = client.imageCensorUserDefined(url, EImgType.FILE, null);
        Log.d("MSG", response.toString());
        return response.toString();
    }
}
