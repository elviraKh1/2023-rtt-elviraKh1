package files;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class ChannelDemoTwo {
    public static void main(String args[]) throws IOException {
        String fname = "sample.txt";
        FileInputStream file = new FileInputStream(fname);
        FileChannel fileChannel = file.getChannel();
        long filesize =  fileChannel.size();
        // intializing buffer,
        // ByteBuffer buffersize  =  ByteBuffer.allocate(200);
        ByteBuffer byteBuffer  =  ByteBuffer.allocate( (int) filesize);
        // read date from a channel into buffer
        while (fileChannel.read(byteBuffer) > 0) {
            // flip the buffer to prepare for get operation
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                //get() method used to read data from buffer and
                // read 1 byte at a time from buffer
                System.out.print((char) byteBuffer.get());
            }
        }
        file.close();
        fileChannel.close();
    }
}

