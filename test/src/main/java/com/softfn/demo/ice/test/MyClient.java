package com.softfn.demo.ice.test;

import Ice.ObjectPrx;

/**
 * Created by willben on 10/18/15.
 */
public class MyClient {
    public static void main(String[] args) {
        int status = 0;
        Ice.Communicator ic = null;

        try {
            ic = Ice.Util.initialize(args);
            ObjectPrx base = ic.stringToProxy("MyService:default -p 10000");
            MyServicePrx proxy = MyServicePrxHelper.checkedCast(base);
            if (proxy == null) {
                throw new Error("Invalid proxy");
            }
            String rt = proxy.hellow();
            System.out.println(rt);
        } catch (Error error) {
            error.printStackTrace();
            status = 1;
        } finally {
            if (ic != null) {
                ic.destroy();
            }
        }
        System.exit(status);
    }
}
