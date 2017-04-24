package com.hust.grid.leesf.nio;

import java.nio.channels.SocketChannel;
import java.net.InetSocketAddress;

/**
 * Created by LEESF on 2017/4/16.
 */


public class ConnectAsync {
    public static void main (String [] argv) throws Exception {
        String host = "localhost";
        int port = 80;
        if (argv.length == 2) {
            host = argv [0];
            port = Integer.parseInt (argv [1]);
        }
        InetSocketAddress addr = new InetSocketAddress (host, port);
        SocketChannel sc = SocketChannel.open( );
        sc.configureBlocking (false);
        System.out.println ("initiating connection");
        sc.connect (addr);
        while ( ! sc.finishConnect( )) {
            doSomethingUseful( );
            Thread.sleep(1000);
        }
        System.out.println ("connection established");
        // Do something with the connected socket
        // The SocketChannel is still nonblocking
        sc.close( );
    }

    private static void doSomethingUseful( ) {
        System.out.println ("doing something useless");
    }
}
