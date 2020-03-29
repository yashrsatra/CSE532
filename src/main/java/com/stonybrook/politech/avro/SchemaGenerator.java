package com.stonybrook.politech.avro;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

public class SchemaGenerator {

    public static Schema getSchema(){
        Schema schemaIdentifier = SchemaBuilder.record("GeometricDetailsGenerated")
                .namespace("com.stonybrook.politech.model")
                .fields().requiredString("ID").requiredString("geometryJSON").requiredString("originalDistrictID")
                .requiredInt("population").requiredInt("gop_vote").requiredInt("dem_vote")
                .endRecord();
        return schemaIdentifier;
    }
}
