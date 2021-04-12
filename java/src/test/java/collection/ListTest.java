package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    @Test
    public void test001() {
        List<String> list = new ArrayList<String>(){
            {
                add("1");
            }
        };
    }

    @Test
    public void test002() {
        List<String> list = new ArrayList<>();
        list.add("1");
    }

    @Test
    public void test003() {
        new ArrayList<String>(){
            {
                add("1");
            }
        };
    }

    @Test
    public void test004() {
        /*ArrayList<String> list = new ArrayList<String>() {
            "1"
        };*/

    }
}
