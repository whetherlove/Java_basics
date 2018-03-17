package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio
 * @Description:
 * @date 16/03/2018 7:52 PM
 */
public class PipeExample {

    //A Java NIO Pipe is a one-way data connection between two threads.
    //A Pipe has a source channel and a sink channel. You write data to
    //the sink channel. This data can then be read from the source channel.

    public static void main(String[] args) throws IOException {

        //Creating a Pipe
        Pipe pipe = Pipe.open();

        //Writing to a Pipe
        //To write to a Pipe you need to access the sink channel.
        Pipe.SinkChannel sinkChannel = pipe.sink();
        //Write to a SinkChannel by calling it's write() method.
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        while(buf.hasRemaining()) {
            sinkChannel.write(buf);
        }

        //Reading from a Pipe
        //To read from a Pipe you need to access the source channel.
        Pipe.SourceChannel sourceChannel = pipe.source();
        //To read from the source channel you call its read() method.
        ByteBuffer buf1 = ByteBuffer.allocate(48);

        int bytesRead = sourceChannel.read(buf);

    }
}
