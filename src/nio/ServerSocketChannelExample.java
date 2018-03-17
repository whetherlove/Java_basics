package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio
 * @Description:
 * @date 16/03/2018 2:39 PM
 */
public class ServerSocketChannelExample {

    //A Java NIO ServerSocketChannel is a channel that can listen for incoming TCP connections

    public static void main(String[] args) throws IOException {

        //Opening a ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(9999));

        //Listening for incoming connections is done by calling the ServerSocketChannel.accept()
        //method. When the accept() method returns, it returns a SocketChannel with an incoming
        //connection. Thus, the accept() method blocks until an incoming connection arrives.
        while(true){
            SocketChannel socketChannel =
                    serverSocketChannel.accept();

            //do something with socketChannel...
        }

        //Non-blocking Mode
        //In non-blocking mode the accept() method returns immediately, and may thus
        //return null, if no incoming connection had arrived. Therefore you will have
        //to check if the returned SocketChannel is null.
        //e.g.
//        serverSocketChannel.configureBlocking(false);
//        while(true){
//            SocketChannel socketChannel =
//                    serverSocketChannel.accept();
//
//            if(socketChannel != null){
//                //do something with socketChannel...
//            }
//        }
    }
}
