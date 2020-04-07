package com.stonybrook.politech.avro;


import com.stonybrook.politech.model.GeometricDetailsGenerated;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.ArrayList;
//@RunWith(JUnit4.class)
@Ignore
public class CompressTest {

//    @Before
//    void setUp() {
//    }
//
//    @After
//    void tearDown() {
//    }
    @Test
    public void serealizeAvroHttpRequestJSON() throws IOException {
//        GeometricDetailsGenerated g1 = new GeometricDetailsGenerated("1234","just a dummy json",
//                "1",20000, 1000, 19000);
//        GeometricDetailsGenerated g2 = new GeometricDetailsGenerated("1235","just a dummy json",
//                "1",20000, 1000, 19000);
//        GeometricDetailsGenerated g3 = new GeometricDetailsGenerated("1236","just a dummy json",
//                "1",20000, 1000, 19000);
//        GeometricDetailsGenerated g4 = new GeometricDetailsGenerated("1237","just a dummy json",
//                "1",20000, 1000, 19000);
//        GeometricDetailsGenerated g5 = new GeometricDetailsGenerated("1238","just a dummy json",
//                "1",20000, 1000, 19000);
//        GeometricDetailsGenerated g6 = new GeometricDetailsGenerated("1239","just a dummy json",
//                "1",20000, 1000, 19000);
//        GeometricDetailsGenerated g7 = new GeometricDetailsGenerated("1240","just a dummy json",
//                "1",20000, 1000, 19000);
        ArrayList<GeometricDetailsGenerated> lst = new ArrayList<>();
//        lst.add(g1);
//        lst.add(g2);
//        lst.add(g3);lst.add(g4);lst.add(g5);lst.add(g6);lst.add(g7);
        for (int i = 0; i < 10000; i ++){
            GeometricDetailsGenerated g1 = new GeometricDetailsGenerated(String.valueOf(i),"just a dummy json",
                    "1",20000, 1000, 19000);
            lst.add(g1);
        }
        Compress comp = new Compress();
        System.out.println(comp.serealizeAvroHttpRequestJSON(lst).length);
    }
}