package org.jabref.es2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.jabref.logic.importer.ImportFormatPreferences;
import org.jabref.logic.importer.fileformat.BibtexImporter;
import org.jabref.logic.importer.fileformat.BibtexImporterTest;
import org.jabref.model.entry.BibEntry;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class TestImport {

    private BibtexImporter importer;

    @Before
    public void setUp() {
        importer = new BibtexImporter(mock(ImportFormatPreferences.class, Answers.RETURNS_DEEP_STUBS));
    }

    @Test
    public void testImportEntries() throws IOException, URISyntaxException {
        Path file = Paths.get(BibtexImporterTest.class.getResource("testeImport.bib").toURI());
        List<BibEntry> bibEntries = importer.importDatabase(file, StandardCharsets.UTF_8).getDatabase().getEntries();

        assertEquals(4, bibEntries.size());

        for (BibEntry entrada : bibEntries) {

            if (entrada.getCiteKeyOptional().get().equals("book1")) {
                assertEquals(Optional.of("Engenharia de Software - Uma Abordagem Profissional"), entrada.getField("title"));
                assertEquals(Optional.of("Roger S. Pressman"), entrada.getField("author"));
                assertEquals(Optional.of("2016"), entrada.getField("year"));
                assertEquals(Optional.of("Amgh Editora"), entrada.getField("publisher"));
                assertEquals(Optional.of("Amgh Editora"), entrada.getField("editor"));

            } else if (entrada.getCiteKeyOptional().get().equals("book2")) {

                assertEquals(Optional.of("C++: como programar"), entrada.getField("title"));
                assertEquals(Optional.of("H.M. Deitel"), entrada.getField("author"));
                assertEquals(Optional.of("2001"), entrada.getField("year"));
                assertEquals(Optional.of("ARTMED EDITORA LTDA"), entrada.getField("publisher"));
                assertEquals(Optional.of("ARTMED EDITORA LTDA"), entrada.getField("editor"));

            } else if (entrada.getCiteKeyOptional().get().equals("book3")) {

                assertEquals(Optional.of("Calculo 1"), entrada.getField("title"));
                assertEquals(Optional.of("James Stewart"), entrada.getField("author"));
                assertEquals(Optional.of("2011"), entrada.getField("year"));
                assertEquals(Optional.of("CENGAGE Learning"), entrada.getField("publisher"));
                assertEquals(Optional.of("CENGAGE Learning"), entrada.getField("editor"));

            } else if (entrada.getCiteKeyOptional().get().equals("book4")) {

                assertEquals(Optional.of("Computer Organization Design"), entrada.getField("title"));
                assertEquals(Optional.of("David A. Patterson"), entrada.getField("author"));
                assertEquals(Optional.of("2005"), entrada.getField("year"));
                assertEquals(Optional.of("Elsevier"), entrada.getField("publisher"));
                assertEquals(Optional.of("Elsevier"), entrada.getField("editor"));

            } else if (entrada.getCiteKeyOptional().get().equals("book5")) {

                assertEquals(Optional.of("Imagens da Organizacao"), entrada.getField("title"));
                assertEquals(Optional.of("Gareth Morgan"), entrada.getField("author"));
                assertEquals(Optional.of("2006"), entrada.getField("year"));
                assertEquals(Optional.of("atlas"), entrada.getField("publisher"));
                assertEquals(Optional.of("atlas"), entrada.getField("editor"));

            }
        }
    }
}