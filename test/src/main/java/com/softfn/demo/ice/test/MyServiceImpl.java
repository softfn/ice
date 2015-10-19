package com.softfn.demo.ice.test;

import Ice.Current;

/**
 * Created by willben on 10/18/15.
 */
public class MyServiceImpl extends _MyServiceDisp {
    public String hellow(Current __current) {
        return "hellow word";
    }
}
