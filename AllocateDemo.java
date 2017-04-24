package com.hust.grid.leesf.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;

/**
 * Created by LEESF on 2017/4/13.
 */
public class AllocateDemo {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate (8);
        buffer.put('L');
        buffer.put('E');
        buffer.put('E');
        buffer.put('S');
        buffer.put('F');
        buffer.position (3).limit (6).mark( ).position (5);
        CharBuffer dupeBuffer = buffer.duplicate( );
        buffer.clear( );
        dupeBuffer.flip();
        System.out.println(dupeBuffer.position());
        System.out.println(dupeBuffer.limit());
        System.out.println(dupeBuffer.get());

        buffer.put('Y');
        buffer.put('D');
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.get());

        System.out.println(dupeBuffer.get());


        /*CharBuffer buffer = CharBuffer.allocate(5);
        buffer.put('H');
        buffer.put('E');
        buffer.put('L');
        buffer.put('L');
        buffer.put('O');

        char[] chars_ = new char[100];
        buffer.get(chars_);

        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }

        System.out.println(buffer.remaining());
        buffer.limit(3);
        System.out.println(buffer.remaining());
        System.out.println(buffer.position());


        CharBuffer charBuffer = CharBuffer.allocate(100);
        System.out.println(charBuffer.hasArray());
        System.out.println(charBuffer.array().length);

        char[] chars = new char[100];
        charBuffer = CharBuffer.wrap(chars, 1, 10);
        charBuffer.put('l');
        charBuffer.put('o');

        System.out.println(charBuffer.position());
        System.out.println(charBuffer.hasArray());
        System.out.println(charBuffer.array().length);

        Channels.newChannel(System.in);*/

    }
}
