package org.jabref.logic.importer.fileformat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jabref.logic.importer.Importer;
import org.jabref.logic.importer.ParserResult;
import org.jabref.logic.util.FileExtensions;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.FieldName;


public class CSVImporter extends Importer {

    @Override
    public boolean isRecognizedFormat(BufferedReader input) throws IOException {
        while (input.readLine() != null) {
            return true;
        }
        return false;
    }

    @Override
    public ParserResult importDatabase(BufferedReader input) throws IOException {
        List<BibEntry> bibitems = new ArrayList<>();

        String line = input.readLine();
        while (line != null) {
            if (!line.trim().isEmpty()) {
                String[] fields = line.split(",");
                BibEntry be = new BibEntry();
                be.setType(fields[0]);
                be.setField(FieldName.YEAR, fields[10]);
                be.setField(FieldName.AUTHOR, fields[3]);
                be.setField(FieldName.TITLE, fields[4]);
                be.setField(FieldName.JOURNAL, fields[5]);
                bibitems.add(be);
                line = input.readLine();
            }
        }
        return new ParserResult(bibitems);
    }

    @Override
    public String getName() {
        return "CSV Importer";
    }

    @Override
    public FileExtensions getExtensions() {
        return FileExtensions.CSV;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Import CSVI File to Jabref";
    }

}
