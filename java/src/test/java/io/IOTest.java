package io;

import com.google.common.primitives.Chars;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Map;

import static java.lang.System.*;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/10 6:27 下午
 */
public class IOTest {

    private final static String PATH = "./src/test/java/io/IOTest.java";

    @Test
    public void test001() throws IOException, FileNotFoundException {
        FileInputStream fis = new FileInputStream("./src/test/java/io/IOTest.java");
        byte[] bbuf = new byte[1024];
        int hasRead = 0;
        while ((hasRead = fis.read(bbuf)) > 0) {
            System.out.println(new String(bbuf, 0, hasRead));
        }
        fis.close();
    }

    @Test
    public void test002() throws IOException {
        FileInputStream fis = new FileInputStream("./src/test/java/io/IOTest.java");
        byte[] bbuf = new byte[1024];
        int hasRead = 0;
        fis.read();
        fis.close();
    }

    @Test
    public void test003() {
        CharBuffer buff = CharBuffer.allocate(8);
        out.println("capacity:" + buff.capacity());
        out.println("limit:" + buff.limit());
        out.println(("position:" + buff.position()));
        out.println("-----------------------");

        buff.put("a");
        buff.put('b');
        buff.put("c");
        out.println("capacity:" + buff.capacity());
        out.println("limit:" + buff.limit());
        out.println(("position:" + buff.position()));
        out.println("-----------------------");

        buff.flip();
        out.println("capacity:" + buff.capacity());
        out.println("limit:" + buff.limit());
        out.println(("position:" + buff.position()));
        out.println(buff.get());
        out.println("capacity:" + buff.capacity());
        out.println("limit:" + buff.limit());
        out.println(("position:" + buff.position()));
        out.println("-----------------------");

        buff.clear();
        out.println("capacity:" + buff.capacity());
        out.println("limit:" + buff.limit());
        out.println(buff.get(2));
        out.println(("position:" + buff.position()));
        out.println("-----------------------");
    }

    @Test
    public void test004() throws IOException {
        File file = new File(PATH);
        try (
                FileChannel inChannel = new FileInputStream(file).getChannel();
                FileChannel outChannel = new FileOutputStream("a.txt").getChannel()) {
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            Charset charset = Charset.forName("GBK");
            outChannel.write(buffer);
            buffer.clear();
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = charset.decode(buffer);
            out.println(charBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test005() throws IOException {
        File file = new File("a.txt");
        try (
                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                FileChannel randomChannel = raf.getChannel()
                ){
            ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            randomChannel.position(file.length());
            randomChannel.write(buffer);
        }
    }

    @Test
    public void test006() throws IOException{
        try (
                FileInputStream fis = new FileInputStream(PATH);
                FileChannel channel = fis.getChannel();
                ){
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (channel.read(buffer) != -1) {
                // 锁定 buffer 的空白区
                buffer.flip();
                Charset charset = Charset.forName("UTF8");
                CharsetDecoder decoder = charset.newDecoder();
                CharBuffer charBuffer = charset.decode(buffer);
                out.println(charBuffer);
                buffer.clear();
            }
        }
    }

    @Test
    public void test007() {
        out.println(System.getProperties().get("file.encoding"));
        Map<String, Charset> map = Charset.availableCharsets();
        for (String key : map.keySet()) {
            out.println(map.get(key));
        }
    }

    @Test
    public void test008() {

    }


}
