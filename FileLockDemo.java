package com.hust.grid.leesf.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by LEESF on 2017/4/16.
 */
public class FileLockDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("F://test1.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        byte[] bytes = new byte[100];
        mappedByteBuffer.get(bytes, 0, mappedByteBuffer.remaining());
        System.out.println(new String(bytes));






        /*Thread thread1 = new Thread(new MyRunnalbe(fileChannel));
        Thread thread2 = new Thread(new MyRunnalbe(fileChannel));

        thread1.start();
        thread2.start();*/
    }

    static class MyRunnalbe implements Runnable {
        private FileChannel fileChannel;

        public MyRunnalbe(FileChannel fileChannel) {
            this.fileChannel = fileChannel;
        }

        @Override
        public void run() {
            try {
                FileLock fileLock= fileChannel.lock();
                System.out.println(fileLock.isValid());
                Thread.sleep(1000);
            } catch (Exception ex) {
                System.out.println(Thread.currentThread().getName() + " " + ex);
            }
        }
    }
}
