package com.hust.grid.leesf.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Pipe;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by LEESF on 2017/4/16.
 */

public class PipeDemo {
    public static void main (String [] argv) throws Exception {
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sinkChannel = pipe.sink();
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        System.out.println("writing data: " + newData);
        buf.put(newData.getBytes());
        buf.flip();
        while (buf.hasRemaining()) {
            sinkChannel.write(buf);
        }

        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        sourceChannel.read(byteBuffer);
        byteBuffer.flip();
        String strs = getString(byteBuffer);
        System.out.println("reading data: " + strs);
    }

    public static String getString(ByteBuffer buffer) {
        Charset charset;
        CharsetDecoder decoder;
        CharBuffer charBuffer;
        try {
            charset = Charset.forName("UTF-8");
            decoder = charset.newDecoder();
            charBuffer = decoder.decode(buffer.asReadOnlyBuffer());
            return charBuffer.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
