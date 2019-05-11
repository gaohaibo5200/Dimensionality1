package contract;

import bean.LoginBean;
import model.MyModel;

/**
 * Project name：WeiDuMovie
 * Time: 2019/5/10 18:22
 * Author: 高海波
 */
public interface ContractInterFace {

    //p层
    public interface  IPresenter{
        void login(String phone, String pwd);
        void register();
    }
    //p层
    public interface  IModel{
        void login(String phone, String pwd, final MyModel.SetLogin setLogin);
        void register();
    }
    public  interface  ILogin{
        void login(LoginBean loginBean);
    }
    public  interface  IRegister{
        void register();
    }
}
