package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio
 * @Description:
 * @date 16/03/2018 2:18 PM
 */
public class SocketChannelExample {

    //A Java NIO SocketChannel is a channel that is connected to a TCP network socket.
    //It is Java NIO's equivalent of Java Networking's Sockets.

    public static void main(String[] args) throws IOException {

        //There are two ways a SocketChannel can be created:
        //1. You open a SocketChannel and connect to a server somewhere on the internet.
        //2. A SocketChannel can be created when an incoming connection arrives at a
        //ServerSocketChannel.
        //e.g.
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

        //operations on a SocketChannel (read write close) are the same as on a FileChannel

        //Non-blocking Mode
        //You can set a SocketChannel into non-blocking mode. When you do so, you can
        //call connect(), read() and write() in asynchronous mode.

        //connect()
        //If the SocketChannel is in non-blocking mode, and you call connect(), the method
        //may return before a connection is established. To determine whether the connection
        //is established, you can call the finishConnect() method, like this:

        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

        while(! socketChannel.finishConnect() ){
            //wait, or do something else...
        }

        socketChannel.close();

        //write()
        //In non-blocking mode the write() method may return without having written anything.
        //Therefore you need to call the write() method in a loop.

        //read()
        //In non-blocking mode the read() method may return without having read any data at
        //all. Therefore you need to pay attention to the returned int, which tells how many
        //bytes were read.
    }
}
