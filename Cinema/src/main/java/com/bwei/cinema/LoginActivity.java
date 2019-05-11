package com.bwei.cinema;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import bean.LoginBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import contract.ContractInterFace;
import presenter.MyPresenter;

public class LoginActivity extends AppCompatActivity implements ContractInterFace.ILogin {

    @BindView(R.id.phone_id)
    EditText phoneId;
    @BindView(R.id.pwd_id)
    EditText pwdId;
    @BindView(R.id.jzpwd_id)
    CheckBox jzpwdId;
    @BindView(R.id.quickly_id)
    TextView quicklyId;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.wxLogin)
    ImageView wxLogin;
    private ContractInterFace.IPresenter iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        iPresenter = new MyPresenter<>(this);
    }

    @Override
    public void login(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        iPresenter.login(phoneId.getText().toString(),pwdId.getText().toString());

    }
}
