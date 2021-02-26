package com.java.learn.thread.pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道通信的应⽤场景：
 * 这个很好理解。使⽤管道多半与I/O流相关。当我们⼀个线程需要先另⼀个线程发
 * 送⼀个信息（⽐如字符串）或者⽂件等等时，就需要使⽤管道通信了。
 *
 * 这个示例代码的执⾏流程：
 * 1. 线程ReaderThread开始执⾏，
 * 2. 线程ReaderThread使⽤管道reader.read()进⼊”阻塞“，
 * 3. 线程WriterThread开始执⾏，
 * 4. 线程WriterThread⽤writer.write("test")往管道写⼊字符串，
 * 5. 线程WriterThread使⽤writer.close()结束管道写⼊，并执⾏完毕，
 * 6. 线程ReaderThread接受到管道输出的字符串并打印，
 * 7. 线程ReaderThread执⾏完毕。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/2/26 15:39
 */
public class PipeDemo {

    static class ReaderThread implements Runnable {

        private final PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("this is reader");
            int receive;
            try {
                while ((receive = reader.read()) != -1){
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriterThread implements Runnable {

        private final PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("this is writer");
            try {
                writer.write("test");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        // 这⾥注意⼀定要连接，才能通信
        writer.connect(reader);
        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(1000);
        new Thread(new WriterThread(writer)).start();
    }
}
