package org.jabref.es2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

import org.jabref.logic.importer.ImportFormatPreferences;
import org.jabref.logic.importer.ParseException;
import org.jabref.logic.importer.fileformat.BibtexParser;
import org.jabref.model.entry.BibEntry;
import org.jabref.preferences.JabRefPreferences;

//Classe de testes para inserção de um novo book
public class TestBook {

    // Importar parser
    private ImportFormatPreferences importFormatPreferences;
    private BibtexParser parser;

    //Inclusão do parser para verificar entradas antes dos testes
    @Before
    public void setUp() {
        // Criar o parser para ser utilizado nas entradas esperadas
        importFormatPreferences = JabRefPreferences.getInstance().getImportFormatPreferences();
        parser = new BibtexParser(importFormatPreferences);
    }

    //Teste para verificar inserção de book com todas as entradas padrão preenchidas
    @Test
    public void bookComTodosOsCampos() throws ParseException {
        // Preenche campos da entrada esperada
        List<BibEntry> teste = parser.parseEntries("@book{aaa, title={titulo do livro},\n" + "publisher = {publicador do livro},\n year = {2017},\n author = {autor do livro},\n editor = {editor do livro} }");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Preenche os campos da nova entrada
        insercao.setType("book");
        insercao.setField("bibtexkey", "aaa");
        insercao.setField("title", "titulo do livro");
        insercao.setField("publisher", "publicador do livro");
        insercao.setField("year", "2017");
        insercao.setField("author", "autor do livro");
        insercao.setField("editor", "editor do livro");

        // Compara se a entrada esperada e a inserida são iguais
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar inserção de book com todos os campos preenchidos, inclusive as entradas opcionais
    @Test
    public void bookComCamposExtras() throws ParseException {
        // Preenche campos da entrada esperada
        List<BibEntry> teste = parser.parseEntries("@book{aaa, title={titulo do livro},\n" + "publisher = {publicador do livro},\n year = {2017},\n author = {autor do livro},\n editor = {editor do livro}, \n volume = {volume do livro}, \n number = {numero do livro}, \n series = {serie do livro}, \n address = {endereco}, \n edition = {edicao}, \n month = {december}, \n isbn = {100}, \n note = {nota}, \n crossref = {crossref do livro}, \n keywords = {keyword do livro}, \n file = {file do livro}, \n doi = {5}, \n url = {www.url.com}, \n comment = {new comment}, \n owner = {information owner}, \n timestamp = {2017-12-12}, \n abstract = {abstract do livro}, \n review = {excelent} }");
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Preenche os campos da nova entrada
        insercao.setType("book");
        insercao.setField("bibtexkey", "aaa");
        insercao.setField("title", "titulo do livro");
        insercao.setField("publisher", "publicador do livro");
        insercao.setField("year", "2017");
        insercao.setField("author", "autor do livro");
        insercao.setField("editor", "editor do livro");
        insercao.setField("volume", "volume do livro");
        insercao.setField("number", "numero do livro");
        insercao.setField("series", "serie do livro");
        insercao.setField("address", "endereco");
        insercao.setField("edition", "edicao");
        insercao.setField("month", "december");
        insercao.setField("isbn", "100");
        insercao.setField("note", "nota");
        insercao.setField("crossref", "crossref do livro");
        insercao.setField("keywords", "keyword do livro");
        insercao.setField("file", "file do livro");
        insercao.setField("doi", "5");
        insercao.setField("url", "www.url.com");
        insercao.setField("comment", "new comment");
        insercao.setField("owner", "information owner");
        insercao.setField("timestamp", "2017-12-12");
        insercao.setField("abstract", "abstract do livro");
        insercao.setField("review", "excelent");

        // Compara se a entrada esperada e a inserida são iguais
        assertEquals(Collections.singletonList(insercao), teste);

    }

    //Teste para verificar book com entradas vazias
    @Test
    public void bookComEntradasVazias() throws ParseException {
        // Entrada esperada de um book com campos vazios
        List<BibEntry> teste = parser.parseEntries("@book{,}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo book e com campos vazios
        insercao.setType("book");

        // Compara se a entrada esperada e a inserida são iguais
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar bibtexkey invalida de um book
    // Para ser valida a bibtexkey deve ter comprimento superior a dois caracteres e começar com uma letra
    @Test
    public void bookComInvalidaBibTexKey() throws ParseException {
        // Entrada esperada de um book com bibtexkey = a
        List<BibEntry> teste = parser.parseEntries("@book{a}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo book e com campo bibtexkey = a
        insercao.setType("book");
        insercao.setField("bibtexkey", "a");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar bibtexkey invalida de um book
    // Para ser valida a bibtexkey deve ter comprimento superior a dois caracteres e começar com uma letra
    @Test
    public void bookComInvalidaBibTexKey2() throws ParseException {
        // Entrada esperada de um book com bibtexkey = a
        List<BibEntry> teste = parser.parseEntries("@book{2aa}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo book e com campo bibtexkey = a
        insercao.setType("book");
        insercao.setField("bibtexkey", "2aa");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar bibtexkey valida de um book
    // Para ser valida a bibtexkey deve ter comprimento superior a dois caracteres e começar com uma letra
    @Test
    public void bookComValidaBibTexKey() throws ParseException {
        // Entrada esperada de um book com bibtexkey = aa2
        List<BibEntry> teste = parser.parseEntries("@book{aa2}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo book e com campo bibtexkey = aa2
        insercao.setType("book");
        insercao.setField("bibtexkey", "aa2");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar ano invalido de um book
    // Para ser valido conforme o calendario gregoriano o ano deve ser maior ou igual a 1592
    @Test
    public void bookComAnoInvalido() throws ParseException {
        // Entrada esperada de um book com ano = 1591
        List<BibEntry> teste = parser.parseEntries("@book{, year = {1591}}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo book e com campo ano = 1591
        insercao.setType("book");
        insercao.setField("year", "1591");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar ano valido de um book
    // Para ser valido conforme o calendario gregoriano o ano deve ser maior ou igual a 1592
    @Test
    public void bookComAnoValido() throws ParseException {
        // Entrada esperada de um book com ano = 1910
        List<BibEntry> teste = parser.parseEntries("@book{, year = {1910}}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo book e com campo ano = 1910
        insercao.setType("book");
        insercao.setField("year", "1910");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Testes para o Null Pointer Exception
    // Os testes devem falhar pois apontam para um endereço inexistente
    // Teste com entrada do campo autor null
    @Test(expected = NullPointerException.class)
    public void bookComAutorNull() {
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry("book");

        // Insere autor com campo null na entrada a ser comparada
        insercao.setField("author", null);
        fail();
    }

    // Teste com entrada do campo titulo null
    @Test(expected = NullPointerException.class)
    public void bookComTituloNull() {
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry("book");

        // Insere titulo com campo null na entrada a ser comparada
        insercao.setField("title", null);
        fail();
    }

    // Teste com entrada do campo journal null
    @Test(expected = NullPointerException.class)
    public void bookComJournalNull() {
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry("book");

        // Insere titulo com campo null na entrada a ser comparada
        insercao.setField("journal", null);
        fail();
    }

    // Teste com entrada do campo ano null
    @Test(expected = NullPointerException.class)
    public void bookComAnoNull() {
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry("book");

        // Insere ano com campo null na entrada a ser comparada
        insercao.setField("year", null);
        fail();
    }

    // Teste com entrada do campo bibtexkey null
    @Test(expected = NullPointerException.class)
    public void bookComBibTexKeyNull() {
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry("book");

        // Insere bibtexkey com campo null na entrada a ser comparada
        insercao.setField("bibtexkey", null);
        fail();
    }

}