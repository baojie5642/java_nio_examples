package com.hust.grid.leesf.nio;

import io.netty.buffer.ByteBuf;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

/**
 * Created by LEESF on 2017/4/15.
 */
public class ChannelDemo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("F://test.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        FileChannel fileChannel1 = randomAccessFile.getChannel();

        System.out.println("fileChannel -- " + fileChannel.position());
        System.out.println("fileChannel1 -- " + fileChannel1.position());
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put("leesf".getBytes());
        byteBuffer.flip();
        fileChannel.write(byteBuffer);

        System.out.println(fileChannel.position());

        byteBuffer.clear();
        byteBuffer.put("LINDA".getBytes());
        byteBuffer.flip();

        fileChannel.write(byteBuffer, 3);

        randomAccessFile.seek(1000000);

        byteBuffer.clear();
        byteBuffer.put("LOVE".getBytes());
        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        System.out.println("fileChannel -- " + fileChannel.position());
        System.out.println("fileChannel1 -- " + fileChannel1.position());
    }
}
