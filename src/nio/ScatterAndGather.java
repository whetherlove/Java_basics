package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio.buffer
 * @Description:
 * @date 15/03/2018 8:02 PM
 */
public class ScatterAndGather {

    //Java NIO comes with built-in scatter / gather support. Scatter / gather
    //are concepts used in reading from, and writing to channels. For instance,
    //if a message consists of a header and a body, you might keep the header
    //and body in separate buffers. Doing so may make it easier for you to work
    //with header and body separately.

    public static void main(String[] args) throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();

        //A "scattering read" reads data from a single channel into multiple buffers
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = { header, body };

        channel.read(bufferArray);

        //A "gathering write" writes data from multiple buffers into a single channel
        ByteBuffer header1 = ByteBuffer.allocate(128);
        ByteBuffer body1   = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray1 = { header1, body1 };

        channel.write(bufferArray1);
    }
}
