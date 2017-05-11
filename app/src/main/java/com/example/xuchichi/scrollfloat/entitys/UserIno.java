package com.example.xuchichi.scrollfloat.entitys;

/**
 * Created by xuchichi on 2017/4/19.
 */
public class UserIno {


    /**
     * data : {"account":{"address":"b71282557a98d7c737776e2a0be3dd04","createAt":1474183565000,"id":383,"piBalance":1.226062717E7,"piBalanceEntrustFreeze":0,"piBalanceFreeze":0,"piBalancePackageFreeze":0,"piLock":0,"updateAt":1492589737000,"usdBalance":10335.58,"usdBalanceEntrustFreeze":0,"usdBalanceFreeze":0,"usdBalancePackageFreeze":0},"appLoginToken":"e30262b7bbd66af845475d9c40dae7ea51c977954cf4ef7a5a79a1a5fe836e2b","ipArea":1,"user":{"address":"b71282557a98d7c737776e2a0be3dd04","contactWay":"{\"wechat\":\"uehrnen \"}","email":"","gender":1,"iOS":false,"id":81663,"loginFlag":1,"loginPassword":"seting","mobile":"1370105","nickname":"555","openMobileCode":1,"openTradePassword":1,"phoheCode":"86","toatlUsdAmount":0,"totalInvPiAmount":0,"tradePassword":"seting","username":"piaa5","vipLevel":0}}
     * state : success
     * status : success
     * success : true
     */

    public DataBean data;
    public String state;
    public String status;
    public boolean success;

    public static class DataBean {
        /**
         * account : {"address":"b71282557a98d7c737776e2a0be3dd04","createAt":1474183565000,"id":383,"piBalance":1.226062717E7,"piBalanceEntrustFreeze":0,"piBalanceFreeze":0,"piBalancePackageFreeze":0,"piLock":0,"updateAt":1492589737000,"usdBalance":10335.58,"usdBalanceEntrustFreeze":0,"usdBalanceFreeze":0,"usdBalancePackageFreeze":0}
         * appLoginToken : e30262b7bbd66af845475d9c40dae7ea51c977954cf4ef7a5a79a1a5fe836e2b
         * ipArea : 1
         * user : {"address":"b71282557a98d7c737776e2a0be3dd04","contactWay":"{\"wechat\":\"uehrnen \"}","email":"","gender":1,"iOS":false,"id":81663,"loginFlag":1,"loginPassword":"seting","mobile":"1370105","nickname":"555","openMobileCode":1,"openTradePassword":1,"phoheCode":"86","toatlUsdAmount":0,"totalInvPiAmount":0,"tradePassword":"seting","username":"piaa5","vipLevel":0}
         */

        public AccountBean account;
        public String appLoginToken;
        public int ipArea;
        public UserBean user;

        public static class AccountBean {
            /**
             * address : b71282557a98d7c737776e2a0be3dd04
             * createAt : 1474183565000
             * id : 383
             * piBalance : 1.226062717E7
             * piBalanceEntrustFreeze : 0.0
             * piBalanceFreeze : 0.0
             * piBalancePackageFreeze : 0.0
             * piLock : 0.0
             * updateAt : 1492589737000
             * usdBalance : 10335.58
             * usdBalanceEntrustFreeze : 0.0
             * usdBalanceFreeze : 0.0
             * usdBalancePackageFreeze : 0.0
             */

            public String address;
            public long createAt;
            public int id;
            public double piBalance;
            public double piBalanceEntrustFreeze;
            public double piBalanceFreeze;
            public double piBalancePackageFreeze;
            public double piLock;
            public long updateAt;
            public double usdBalance;
            public double usdBalanceEntrustFreeze;
            public double usdBalanceFreeze;
            public double usdBalancePackageFreeze;
        }

        public static class UserBean {
            /**
             * address : b71282557a98d7c737776e2a0be3dd04
             * contactWay : {"wechat":"uehrnen "}
             * email :
             * gender : 1
             * iOS : false
             * id : 81663
             * loginFlag : 1
             * loginPassword : seting
             * mobile : 1370105
             * nickname : 555
             * openMobileCode : 1
             * openTradePassword : 1
             * phoheCode : 86
             * toatlUsdAmount : 0
             * totalInvPiAmount : 0
             * tradePassword : seting
             * username : piaa5
             * vipLevel : 0
             */

            public String address;
            public String contactWay;
            public String email;
            public int gender;
            public boolean iOS;
            public int id;
            public int loginFlag;
            public String loginPassword;
            public String mobile;
            public String nickname;
            public int openMobileCode;
            public int openTradePassword;
            public String phoheCode;
            public int toatlUsdAmount;
            public int totalInvPiAmount;
            public String tradePassword;
            public String username;
            public int vipLevel;
        }
    }
}
