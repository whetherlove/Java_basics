package nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio.buffer
 * @Description:
 * @date 16/03/2018 11:37 AM
 */
public class FileChannelExample {


    //A Java NIO FileChannel is a channel that is connected to a file.
    //Using a file channel you can read data from a file, and write data
    //to a file. The Java NIO FileChannel class is NIO's an alternative
    //to reading files with the standard Java IO API. A FileChannel cannot
    //be set into non-blocking mode. It always runs in blocking mode.

    public static void main(String[] args) throws IOException {

        //Before you can use a FileChannel you must open it. You cannot
        //open a FileChannel directly. You need to obtain a FileChannel
        //via an InputStream, OutputStream, or a RandomAccessFile.

        //e.g RandomAccessFile.
        RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();

        //Reading Data from a FileChannel
        ByteBuffer buf = ByteBuffer.allocate(48);
        while (channel.read(buf) != -1){
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
        }
        channel.close();
        aFile.close();


        //Writing Data to a FileChannel

        //e.g opens a channel with InputStream
        FileOutputStream fos = new FileOutputStream("nio-data.txt",true);
        FileChannel channel1 = fos.getChannel();

        String newData = "\r\nNew String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf1 = ByteBuffer.allocate(48);
        buf1.clear();
        buf1.put(newData.getBytes());

        buf1.flip();

        //the FileChannel.write() method is called inside a while-loop.
        //There is no guarantee of how many bytes the write() method writes
        //to the FileChannel. Therefore we repeat the write() call until
        //the Buffer has no further bytes to write.
        while(buf1.hasRemaining()) {
            channel1.write(buf1);
        }

        channel1.close();
        fos.close();


        //Other methods

        //FileChannel Position

        //When reading or writing to a FileChannel you do so at a specific position.
        //You can obtain the current position of the FileChannel object by calling
        //the position() method. You can also set the position of the FileChannel by
        //calling the position(long pos) method.

        //e.g.
        //long pos channel.position();
        //channel.position(pos +123);

        //If you set the position after the end of the file, and try to read from
        //the channel, you will get -1 - the end-of-file marker.
        //If you set the position after the end of the file, and write to the channel,
        //the file will be expanded to fit the position and written data. This may
        //result in a "file hole", where the physical file on the disk has gaps in
        //the written data.

        //FileChannel Size

        //The size() method of the FileChannel object returns the file size of the
        //file the channel is connected to.

        //FileChannel Truncate

        //You can truncate a file by calling the FileChannel.truncate() method.
        //When you truncate a file, you cut it off at a given length.

        //e.g.
        //channel.truncate(1024);

        //FileChannel Force

        //The FileChannel.force() method flushes all unwritten data from the channel
        //to the disk. An operating system may cache data in memory for performance
        //reasons, so you are not guaranteed that data written to the channel is
        //actually written to disk, until you call the force() method.
        //The force() method takes a boolean as parameter, telling whether the file
        //meta data (permission etc.) should be flushed too.
    }
}
