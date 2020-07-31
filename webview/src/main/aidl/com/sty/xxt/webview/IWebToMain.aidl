// IWebToMain.aidl
package com.sty.xxt.webview;

// Declare any non-default types here with import statements
import com.sty.xxt.webview.ICallbackFromMainToWeb;

interface IWebToMain {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void handleWebAction(String actionName, String jsonParams, in ICallbackFromMainToWeb callback);
}
