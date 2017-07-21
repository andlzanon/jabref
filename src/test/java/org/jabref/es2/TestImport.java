package org.jabref.es2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

import org.jabref.Globals;
import org.jabref.logic.importer.ImportFormatReader;
import org.jabref.logic.importer.ParserResult;
import org.jabref.logic.importer.fileformat.BibtexImporter;
import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.preferences.JabRefPreferences;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestImport {

    BibtexImporter importer;

    @Before
    public void setUp() throws Exception {
        Globals.prefs = JabRefPreferences.getInstance();
        importer = new BibtexImporter(Globals.prefs.getImportFormatPreferences());
    }

    @Test
    public void testeImportArquivo() throws IOException {
        //        Cria uma nova database
        BibDatabase database = new BibDatabase();
        //        Prepara o arquivo para importar
        InputStream stream = TestImport.class.getResourceAsStream("testjabref.bib");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, Globals.prefs.getDefaultEncoding()));
        //        Importa o arquivo para a database
        ParserResult pr = importer.importDatabase(reader);
        ImportFormatReader.UnknownFormatImport importResult = new ImportFormatReader.UnknownFormatImport(importer.getName(), pr);
        ParserResult pares = importResult.parserResult;
        database = pares.getDatabase();
        //        Pega a lista de entradas da database
        List<BibEntry> entries = database.getEntries();

        //        Verificação rápida se há apenas duas entradas (como consta no arquivo importado)
        assertEquals(2, entries.size());

        //        Verifica as duas entradas do arquivo importado estão de acordo após a importação
        for (BibEntry entrada : entries) {
            if (entrada.getCiteKey().equals("Aziz2009256-ChannelNeuralRecordingandDeltaCompressionMicrosystemWith3DElectrodesIEEEJOURNALOFSOLID-STATECIRCUITS")) {

                assertEquals(Optional.of("256-Channel Neural Recording and Delta Compression Microsystem With\r\n" + " 3D Electrodes And @ Symbol"), entrada.getField("Title"));
                assertEquals(Optional.of("Aziz, Joseph N. Y. and Abdelhalim, Karim and Shulyzki, Ruslana and\r\n" + " Genov, Roman and Bardakjian, Berj L. and Derchansky, Miron and Serletis,\r\n" + " Demitre and Carlen, Peter L."), entrada.getField("Author"));
                assertEquals(Optional.of("IEEE JOURNAL OF SOLID-STATE CIRCUITS"), entrada.getField("Journal"));
                assertEquals(Optional.of("2009"), entrada.getField("Year"));
                assertEquals(Optional.of("MAR"), entrada.getField("Month"));
                assertEquals(Optional.of("3"), entrada.getField("Number"));
                assertEquals(Optional.of("995-1005"), entrada.getField("Pages"));
                assertEquals(Optional.of("44"), entrada.getField("Volume"));

            } else if (entrada.getCiteKey().equals("BBalakrisnan2009PatterningPDMSusingacombinationofwetanddryetchingJournalofMicromechanicsandMicroengineering")) {

                assertEquals(Optional.of("Patterning PDMS using a combination of wet and dry etching"), entrada.getField("Title"));
                assertEquals(Optional.of("B Balakrisnan , S Patil and E Smela"), entrada.getField("Author"));
                assertEquals(Optional.of("Journal of Micromechanics and Microengineering"), entrada.getField("Journal"));
                assertEquals(Optional.of("2009"), entrada.getField("Year"));
                assertEquals(Optional.of("4"), entrada.getField("Number"));
                assertEquals(Optional.of("047002"), entrada.getField("Pages"));
                assertEquals(Optional.of("19"), entrada.getField("Volume"));

            } else if (entrada.getCiteKey().equals("Baccus1998Synapticfacilitationbyreflectedactionpotentials--enhancementoftransmissionwhennerveimpulsesreversedirectionataxonbranchpoints.ProcNatlAcadSciUSA")) {

                assertEquals(Optional.of("Synaptic facilitation by reflected action potentials: enhancement\r\n" + " of transmission when nerve impulses reverse direction at axon branch\r\n" + " points"), entrada.getField("Title"));
                assertEquals(Optional.of("S. A. Baccus"), entrada.getField("Author"));
                assertEquals(Optional.of("Proc Natl Acad Sci U S A"), entrada.getField("Journal"));
                assertEquals(Optional.of("1998"), entrada.getField("Year"));
                assertEquals(Optional.of("Jul"), entrada.getField("Month"));
                assertEquals(Optional.of("14"), entrada.getField("Number"));
                assertEquals(Optional.of("8345--8350"), entrada.getField("Pages"));
                assertEquals(Optional.of("95"), entrada.getField("Volume"));

            } else if (entrada.getCiteKey().equals("Brewer1995Serum-freeB27/neurobasalmediumsupportsdifferentiatedgrowthofneuronsfromthestriatumsubstantianigraseptumcerebralcortexcerebellumanddentategyrus.JNeurosciRes")) {

                assertEquals(Optional.of("Serum-free B27/neurobasal medium supports differentiated growth of\r\n" + " neurons from the striatum, substantia nigra, septum, cerebral cortex,\r\n" + " cerebellum, and dentate gyrus"), entrada.getField("Title"));
                assertEquals(Optional.of("G. J. Brewer"), entrada.getField("Author"));
                assertEquals(Optional.of("J Neurosci Res"), entrada.getField("Journal"));
                assertEquals(Optional.of("1995"), entrada.getField("Year"));
                assertEquals(Optional.of("Jec"), entrada.getField("Month"));
                assertEquals(Optional.of("5"), entrada.getField("Number"));
                assertEquals(Optional.of("674--683"), entrada.getField("Pages"));
                assertEquals(Optional.of("42"), entrada.getField("Volume"));

            }
        }

    }
}
