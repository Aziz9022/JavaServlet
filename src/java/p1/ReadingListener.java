/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.*;
import java.util.*;
import javax.servlet.*;


/**
 *
 * @author kanoo
 */
public class ReadingListener implements ReadListener
{
    private ServletInputStream input = null;
    private AsyncContext ac = null;
    
    ReadingListener(ServletInputStream in, AsyncContext c) {
        input = in;
        ac = c;
    }
    
    @Override
    public void onDataAvailable() throws IOException {
    }
    
    @Override
    public void onAllDataRead() throws IOException {
        ac.complete();
    }
    
    @Override
    public void onError(final Throwable t) {
        ac.complete();
        t.printStackTrace();
    }
}

