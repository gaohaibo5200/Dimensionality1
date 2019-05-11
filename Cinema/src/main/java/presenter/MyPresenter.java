package presenter;

import bean.LoginBean;
import contract.ContractInterFace;
import model.MyModel;

/**
 * Project name：WeiDuMovie
 * Time: 2019/5/10 18:37
 * Author: 高海波
 */
public class MyPresenter<T> implements ContractInterFace.IPresenter {

    T t;
    private final ContractInterFace.IModel iModel;

    public MyPresenter(T t) {
        this.t = t;
        iModel = new MyModel();
    }

    @Override
    public void login(String phone,String pwd) {

        iModel.login(phone, pwd, new MyModel.SetLogin() {
            @Override
            public void Succeed(LoginBean loginBean) {
                ContractInterFace.ILogin iLogin = (ContractInterFace.ILogin) t;
                iLogin.login(loginBean);
            }
        });
    }

    @Override
    public void register() {

    }
}
