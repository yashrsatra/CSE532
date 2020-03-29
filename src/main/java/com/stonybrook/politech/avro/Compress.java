package com.stonybrook.politech.avro;

import com.stonybrook.politech.model.GeometricDetails;
import com.stonybrook.politech.model.GeometricDetailsGenerated;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.*;
import java.util.ArrayList;

public class Compress {

    public byte[] serealizeAvroHttpRequestJSON(
            ArrayList<GeometricDetailsGenerated> request) throws IOException {

        DatumWriter<GeometricDetailsGenerated> writer = new SpecificDatumWriter<>(SchemaGenerator.getSchema());
        byte[] data = new byte[7];
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Encoder jsonEncoder = null;
        try {
            jsonEncoder = EncoderFactory.get().binaryEncoder(stream, null);
//            jsonEncoder = EncoderFactory.get().jsonEncoder(SchemaGenerator.getSchema(),stream);
            for (GeometricDetailsGenerated req : request) {
//                System.out.println(req.getID());
//                System.out.println(jsonEncoder);
//                System.out.println(writer);
                writer.write(req, jsonEncoder);
            }
            jsonEncoder.flush();
            data = stream.toByteArray();
        } catch (IOException e) {
            System.out.println("Serialization error:" + e.getMessage());
        }
        OutputStream outputStream = new FileOutputStream("thefilename");
        stream.writeTo(outputStream);
        outputStream.close();
        return data;
    }
}
