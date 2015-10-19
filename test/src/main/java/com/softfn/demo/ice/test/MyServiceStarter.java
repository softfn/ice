package com.softfn.demo.ice.test;

import IceInternal.PropertyNames;

/**
 * Created by willben on 10/18/15.
 */
public class MyServiceStarter {
    public static void main(String[] args) {
        int status = 0;
        Ice.Communicator ic = null;

        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("MyServiceAdapter", "default -p 10000");
            MyServiceImpl servant = new MyServiceImpl();
            adapter.add(servant, Ice.Util.stringToIdentity("MyService"));
            adapter.activate();
            System.out.println("server started");
            ic.waitForShutdown();
        } catch (Exception e) {
            e.printStackTrace();
            status = 1;
        } finally {
            if (ic != null) {
                ic.destroy();
            }
        }
        System.exit(status);

    }
}
