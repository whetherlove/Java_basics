package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: nio
 * @Description:
 * @date 16/03/2018 2:26 PM
 */
public class SelectorExample {

    //A Selector is a Java NIO component which can examine one or more NIO
    //Channel's, and determine which channels are ready for e.g. reading or
    //writing. This way a single thread can manage multiple channels, and
    //thus multiple network connections.

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

        //Creating a Selector
        Selector selector = Selector.open();

        //Registering Channels with the Selector
        //In order to use a Channel with a Selector you must register the Channel
        //with the Selector. This is done using the SelectableChannel.register()
        //method, like this:
        //Note: The Channel must be in non-blocking mode to be used with a Selector.
        socketChannel.configureBlocking(false);
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);

        //A channel that "fires an event" is also said to be "ready" for that event.
        //A channel that has connected successfully to another server is "connect ready".
        //SelectionKey.OP_CONNECT = 1 << 3 = 1000;
        //A server socket channel which accepts an incoming connection is "accept" ready.
        //SelectionKey.OP_ACCEPT = 1 << 4 = 10000;
        //A channel that has data ready to be read is "read" ready.
        //SelectionKey.OP_READ = 1 << 0 = 1;
        //A channel that is ready for you to write data to it, is "write" ready.
        //SelectionKey.OP_WRITE = 1 << 2 = 100;
        //If you are interested in more than one event, use OR to link the constants together.
        //e.g.
        //int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        //interestSet = 101

        //SelectionKey's
        //When you register a Channel with a Selector the register() method
        //returns a SelectionKey objects. This SelectionKey object contains
        //a few interesting properties:
        //1. The interest set
        //2. The ready set
        //3. The Channel
        //4. The Selector
        //5.An attached object (optional)

        //1. The interest set
        //The interest set is the set of events you are interested in "selecting"
        //AND the interest set with the given SelectionKey constant to find out
        //if a certain event is in the interest set.
        //e.g.
        int interestSet = key.interestOps();
        boolean isInterestedInAccept = (interestSet & SelectionKey.OP_ACCEPT) != 0;
        boolean isInterestedInConnect = (interestSet & SelectionKey.OP_CONNECT) != 0;
        boolean isInterestedInRead = (interestSet & SelectionKey.OP_READ) != 0;
        boolean isInterestedInWrite = (interestSet & SelectionKey.OP_WRITE) != 0;

        //2. Ready Set
        //The ready set is the set of operations the channel is ready for. You
        //will primarily be accessing the ready set after a selection. Selection
        //is explained in a later section. You access the ready set like this:

        int readySet = key.readyOps();
        //You can test in the same way as with the interest set, what events / operations
        //the channel is ready for. But, you can also use these four methods instead,
        //which all return a boolean:
        key.isAcceptable();
        key.isConnectable();
        key.isReadable();
        key.isWritable();

        //3&4. Accessing the channel + selector from the SelectionKey
        SelectableChannel keyChannel = key.channel();
        Selector keySelector = key.selector();

        //Attaching Objects
        //You can attach an object to a SelectionKey this is a handy way of recognizing
        //a given channel, or attaching further information to the channel. For instance,
        //you may attach the Buffer you are using with the channel, or an object containing
        //more aggregate data. Here is how you attach objects:
        //e.g.
        Object anObject = new Object();
        key.attach(anObject);
        Object attachedObj = key.attachment();
        //You can also attach an object already while registering the Channel with the Selector, in the register() method. Here is how that looks:
        SelectionKey aKey = socketChannel.register(selector, SelectionKey.OP_READ, anObject);

        //Selecting Channels via a Selector
        //Once you have register one or more channels with a Selector you can call one
        //of the select() methods. These methods return the channels that are "ready"
        //for the events you are interested in (connect, accept, read or write).
        //select()
        //Blocks until at least one channel is ready for the events you registered for.
        //select(long timeout)
        //Does the same as select() except it blocks for a maximum of timeout milliseconds
        //selectNow()
        //doesn't block at all. It returns immediately with whatever channels are ready.
        //e.g.
        int numOfSelected = selector.select();
        //The int returned by the select() methods tells how many channels that became
        //ready since last time you called select().

        //selectedKeys()
        //Once you have called one of the select() methods and its return value has
        //indicated that one or more channels are ready, you can access the ready
        //channels via the "selected key set", by calling the selectors selectedKeys()
        //method.
        //e.g.
        Set<SelectionKey> selectedKeys = selector.selectedKeys();

        //Iterate this selected key set to access the ready channels.

        Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
        while (keyIterator.hasNext()) {
            SelectionKey selectedKey = keyIterator.next();
            if (selectedKey.isAcceptable()) {
                // a connection was accepted by a ServerSocketChannel.
            } else if (selectedKey.isConnectable()) {
                // a connection was established with a remote server.
            } else if (selectedKey.isReadable()) {
                // a channel is ready for reading
            } else if (selectedKey.isWritable()) {
                // a channel is ready for writing
            }
            keyIterator.remove();
        }
        //note: The channel returned by the SelectionKey.channel() method should
        //be cast to the channel you need to work with.

        //wakeUp()
        //A thread that has called the select() method which is blocked, can be
        //made to leave the select() method, even if no channels are yet ready.
        //This is done by having a different thread call the Selector.wakeup()
        //method on the Selector which the first thread has called select() on.
        //The thread waiting inside select() will then return immediately.
        //If a different thread calls wakeup() and no thread is currently blocked
        //inside select(), the next thread that calls select() will "wake up" immediately.

        //close()
        //When you are finished with the Selector you call its close() method. This
        //closes the Selector and invalidates all SelectionKey instances registered
        //with this Selector. The channels themselves are not closed.
        selector.close();


    }

}
