package model;

import android.util.Log;

import com.google.gson.Gson;

import java.util.HashMap;

import bean.LoginBean;
import contract.ContractInterFace;
import url.URl;
import util.RetrofitUtil;

/**
 * Project name：WeiDuMovie
 * Time: 2019/5/10 18:22
 * Author: 高海波
 */
public class MyModel implements ContractInterFace.IModel {
    SetLogin setLogin;
    @Override
    public void login(String phone, String pwd, final SetLogin setLogin) {
        this.setLogin = setLogin;
        HashMap<String,String> hashMap= new HashMap<>();
        hashMap.put("phone",phone);
        hashMap.put("pwd",pwd);
        /*for (java.util.Map.Entry<String,String> kk : hashMap.entrySet()){
            Log.e("tag",kk.getKey()+"     " +kk.getValue());dsadasdasdasd
        }*/
        RetrofitUtil.GetInstance().doPost(URl.URL_LOGIN, 0, null, hashMap, new RetrofitUtil.HttpListener() {
            @Override
            public void Succeed(String s) {
                LoginBean loginBean = new Gson().fromJson(s, LoginBean.class);
                setLogin.Succeed(loginBean);
            }

            @Override
            public void Error(String s) {
                Log.e("tag","Error  : " + s);

            }
        });

    }

    @Override
    public void register() {

    }
    public interface SetLogin{
        void Succeed(LoginBean loginBean);
    }

}
