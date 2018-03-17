package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio.buffer
 * @Description:
 * @date 15/03/2018 8:08 PM
 */
public class Channel {

    //Java NIO Channels are similar to streams with a few differences:
    //1. You can both read and write to a Channels. Streams are typically one-way (read or write).
    //2. Channels can be read and written asynchronously.
    //3. Channels always read to, or write from, a Buffer.

    //The most important Channel implementations in Java NIO:

    //FileChannel  The FileChannel reads data from and to files.
    //DatagramChannel  The DatagramChannel can read and write data over the network via UDP.
    //SocketChannel  The SocketChannel can read and write data over the network via TCP.
    //ServerSocketChannel    The ServerSocketChannel allows you to listen for incoming TCP
    //                       connections, like a web server does. For each incoming connection
    //                       a SocketChannel is created.

    public static void main(String[] args) throws IOException {

        //create basic channel
        RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();


        //transfer data directly from one channel to another

        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel      fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel      toChannel = toFile.getChannel();

        long position = 0;
        long count    = fromChannel.size();

        //transferFrom
        // position tells where in the destination file to start writing,
        // count tells how many bytes to transfer maximally
        toChannel.transferFrom(fromChannel, position, count);

        //transferTo
        // position tells where in the destination file to start writing,
        // count tells how many bytes to transfer maximally,
        fromChannel.transferTo(position, count, toChannel);
    }
}
