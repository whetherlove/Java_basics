package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio
 * @Description:
 * @date 16/03/2018 7:45 PM
 */
public class DatagramChannelExample {

    //A Java NIO DatagramChannel is a channel that can send and receive UDP packets.
    //Since UDP is a connection-less network protocol, you cannot just by default
    //read and write to a DatagramChannel like you do from other channels. Instead
    //you send and receive packets of data.

    public static void main(String[] args) throws IOException {

        //Opening a DatagramChannel
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));

        //Receiving Data
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        channel.receive(buf);
        //The receive() method will copy the content of a received packet of data
        //into the given Buffer. If the received packet contains more data than
        //the Buffer can contain, the remaining data is discarded silently.

        //Sending Data
        String newData = "New String to write to file..."
                + System.currentTimeMillis();

        ByteBuffer buf1 = ByteBuffer.allocate(48);
        buf1.clear();
        buf1.put(newData.getBytes());
        buf1.flip();
        int bytesSent = channel.send(buf, new InetSocketAddress("jenkov.com", 80));
        //This example sends the string to the "jenkov.com" server on UDP port 80.
        //You will not be notified of whether the send packet was received or not,
        //since UDP does not make any guarantees about delivery of data.

        //Locks your DatagramChannel so you can only send and receive data packets from
        //one specific address.
        channel.connect(new InetSocketAddress("jenkov.com", 80));

        //When connected you can also use the read() and write() method, as if you were
        //using a traditional channel. You just don't have any guarantees about delivery
        //of the sent data.
        int bytesRead = channel.read(buf);
        int bytesWritten = channel.write(buf);
    }
}
