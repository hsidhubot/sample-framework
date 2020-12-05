package com.hs.driver;

import com.browserstack.local.Local;

import java.util.HashMap;

public class BrowserstackLocalInstance {

    private static ThreadLocal<Local> dr = new ThreadLocal<>();

    protected static void setupBrowserstackLocalInstance() throws Exception {
        Local bsLocal = new Local();
        HashMap<String, String> bsLocalArgs = new HashMap<>();
        bsLocalArgs.put("server", "hub-cloud.browserstack.com");
        bsLocalArgs.put("user", "harwindersidhu1");
        bsLocalArgs.put("key", "2C8GmCMdaWq63oztm8vf");
        bsLocal.start(bsLocalArgs);
        setBrowserStackLocalTesting(bsLocal);
    }

    public static void setBrowserStackLocalTesting(Local loc) {
        dr.set(loc);
    }

    public static Local getBrowserStackLocalTesting() {
        return dr.get();
    }

    protected static void quitBrowserStackLocalTesting() throws Exception {
        getBrowserStackLocalTesting().stop();
        dr.set(null);
    }
}