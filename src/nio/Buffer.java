package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio.buffer
 * @Description: Buffer is an abstract class. A buffer is a linear,
 * finite sequence of elements of a specific primitive type
 * Direct Known Subclasses are ByteBuffer, CharBuffer, DoubleBuffer,
 * FloatBuffer, IntBuffer, LongBuffer, ShortBuffer
 * @date 15/03/2018 3:24 PM
 */
public class Buffer {

    /* A Buffer has three properties
    Capacity
        Being a memory block, a Buffer has a certain fixed size,
    also called its "capacity". You can only write capacity bytes,
    longs, chars etc. into the Buffer. Once the Buffer is full,
    you need to empty it (read the data, or clear it) before you
    can write more data into it.

    Position
        When you write data into the Buffer, you do so at a certain
    position. Initially the position is 0. When a byte, long etc.has
    been written into the Buffer the position is advanced to point
    to the next cell in the buffer to insert data into.Position can
    maximally become capacity - 1.

        When you read data from a Buffer you also do so from a given
    position. When you flip a Buffer from writing mode to reading mode,
    the position is reset back to 0. As you read data from the Buffer
    you do so from position, and position is advanced to next position
    to read.

    Limit
        In write mode the limit of a Buffer is the limit of how much
    data you can write into the buffer. In write mode the limit is equal
    to the capacity of the Buffer.

        When flipping the Buffer into read mode, limit means the limit
    of how much data you can read from the data. Therefore, when flipping
    a Buffer into read mode, limit is set to write position of the write
    mode. In other words, you can read as many bytes as were written (limit
    is set to the number of bytes written, which is marked by position).
    */

    /*
    Using a Buffer to read and write data typically follows this little 4-step process:
    1. Write data into the Buffer
    2. Call buffer.flip()
    3. Read data out of the Buffer
    4. Call buffer.clear() or buffer.compact()   */

    public static void main(String[] args) throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);

        //there are two ways to write data into a Buffer:
        //1. Write data from a Channel into a Buffer
        //2. Write data into the Buffer yourself, via the buffer's put() methods.
        //e.g. int bytesRead = inChannel.read(buf);
        //e.g. buf.put(127);
        int bytesRead = inChannel.read(buf);

        while (bytesRead != -1) {
            //When you write data into a buffer, the buffer keeps
            // track of how much data you have written. Once you
            // need to read the data, you need to switch the buffer
            // from writing mode into reading mode using the flip()
            // method call. In reading mode the buffer lets you read
            // all the data written into the buffer
            buf.flip();

            //There are two ways you can read data from a Buffer.
            //Read data from the buffer into a channel.
            //Read data from the buffer yourself, using one of the get() methods.
            //e.g. int bytesWritten = inChannel.write(buf);
            //e.g. byte aByte = buf.get();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get()); // read 1 byte at a time
            }

            //Once you have read all the data, you need to clear the buffer,
            // to make it ready for writing again. You can do this in two
            // ways: By calling clear() or by calling compact(). The clear()
            // method clears the whole buffer. The compact() method only
            // clears the data which you have already read. Any unread data
            // is moved to the beginning of the buffer, and data will now be
            // written into the buffer after the unread data.
            buf.clear(); //make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }
        aFile.close();


        //Other methods

        //The Buffer.rewind() sets the position back to 0, so you can reread
        //all the data in the buffer. The limit remains untouched, thus still
        //marking how many elements (bytes, chars etc.) that can be read from
        //the Buffer.

        //You can mark a given position in a Buffer by calling the Buffer.mark()
        //method. You can then later reset the position back to the marked position
        //by calling the Buffer.reset() method.
        //e.g.
        //buffer.mark();
        //call buffer.get() a couple of times
        //buffer.reset();

    }

}
