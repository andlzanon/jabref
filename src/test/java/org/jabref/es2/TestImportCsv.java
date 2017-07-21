package org.jabref.es2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.jabref.Globals;
import org.jabref.logic.importer.fileformat.BibtexImporterTest;
import org.jabref.logic.importer.fileformat.CSVImporter;
import org.jabref.logic.util.FileExtensions;
import org.jabref.model.entry.BibEntry;
import org.jabref.preferences.JabRefPreferences;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestImportCsv {

    private CSVImporter importer;

    @Before
    public void setUp() {
        Globals.prefs = JabRefPreferences.getInstance();
        importer = new CSVImporter();
    }

    @Test
    public void testImportEntries() throws IOException, URISyntaxException {
        Path file = Paths.get(BibtexImporterTest.class.getResource("testeCsv.csv").toURI());

        List<BibEntry> bibEntries = importer.importDatabase(file, Globals.prefs.getDefaultEncoding()).getDatabase().getEntries();

        assertEquals(3, bibEntries.size());

        /*for (BibEntry entrada : bibEntries) {
        
            if (entrada.getCiteKeyOptional().get().equals("artigocsv")) {
                assertEquals(Optional.of("Titulo do artigo"), entrada.getField("title"));
                assertEquals(Optional.of("Autor do artigo"), entrada.getField("author"));
                assertEquals(Optional.of("2017"), entrada.getField("year"));
                assertEquals(Optional.of("Journal do artigo"), entrada.getField("journal"));
        
            } else if (entrada.getCiteKeyOptional().get().equals("keylivrocsv")) {
        
                assertEquals(Optional.of("Livro do csv"), entrada.getField("title"));
                assertEquals(Optional.of("Autor do livro csv"), entrada.getField("author"));
                assertEquals(Optional.of("2000"), entrada.getField("year"));
                assertEquals(Optional.of("Plubicador do livro csv"), entrada.getField("publisher"));
                assertEquals(Optional.of("Editor do livro csv"), entrada.getField("editor"));
        
            }
        }*/

    }

    @Test
    public void verificaFormatoExtensao() {
        assertEquals(FileExtensions.CSV, importer.getExtensions());
    }
}