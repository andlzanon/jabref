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

//Classe de testes para inserção de um novo artigo
public class TestArticle {

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

    //Teste para verificar inserção de artigo com todas as entradas padrão preenchidas
    @Test
    public void artigoComTodosOsCampos() throws ParseException {
        // Preenche campos da entrada esperada
        List<BibEntry> teste = parser.parseEntries("@article{aaa, author={Rodrigo},\n" + "title = {Detecção e análise de gestos simples da mão},\n journal = {UFSCar},\n year = {2017} }");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Preenche os campos da nova entrada
        insercao.setType("article");
        insercao.setField("bibtexkey", "aaa");
        insercao.setField("author", "Rodrigo");
        insercao.setField("title", "Detecção e análise de gestos simples da mão");
        insercao.setField("journal", "UFSCar");
        insercao.setField("year", "2017");

        // Compara se a entrada esperada e a inserida são iguais
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar inserção de artigo com todos os campos preenchidos, inclusive as entradas opcionais
    @Test
    public void artigoComCamposExtras() throws ParseException {
        // Preenche campos da entrada esperada
        List<BibEntry> teste = parser.parseEntries("@article{aaa, author={Rodrigo Ferrari},\n" + "title = {Engenharia de Software 2},\n journal = {UFSCar},\n year = {2017},\n" + "volume = {1},\n number = {1},\n pages = {58},\n month = {december},\n note = {Nenhuma observação}, \n issn = {100}, \n crossref = {new crossref}, \n keywords = {no keywords}, \n doi = {5}, \n url = {www.url.com}, \n comment = {new comment}, \n owner = {information owner}, \n timestamp = {2017-12-12}, \n abstract = {abstract do artigo}, \n review = {excelent} }");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Preenche os campos da nova entrada
        insercao.setType("article");
        insercao.setField("bibtexkey", "aaa");
        insercao.setField("author", "Rodrigo Ferrari");
        insercao.setField("title", "Engenharia de Software 2");
        insercao.setField("journal", "UFSCar");
        insercao.setField("year", "2017");
        insercao.setField("volume", "1");
        insercao.setField("number", "1");
        insercao.setField("pages", "58");
        insercao.setField("month", "december");
        insercao.setField("note", "Nenhuma observação");
        insercao.setField("issn", "100");
        insercao.setField("crossref", "new crossref");
        insercao.setField("keywords", "no keywords");
        insercao.setField("doi", "5");
        insercao.setField("url", "www.url.com");
        insercao.setField("comment", "new comment");
        insercao.setField("owner", "information owner");
        insercao.setField("timestamp", "2017-12-12");
        insercao.setField("abstract", "abstract do artigo");
        insercao.setField("review", "excelent");

        // Compara se a entrada esperada e a inserida são iguais
        assertEquals(Collections.singletonList(insercao), teste);

    }

    //Teste para verificar artigo com entradas vazias
    @Test
    public void artigoComEntradasVazias() throws ParseException {
        // Entrada esperada de um artigo com campos vazios
        List<BibEntry> teste = parser.parseEntries("@article{,}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo artigo e com campos vazios
        insercao.setType("article");

        // Compara se a entrada esperada e a inserida são iguais
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar bibtexkey invalida de um artigo
    // Para ser valida a bibtexkey deve ter comprimento superior a dois caracteres e começar com uma letra
    @Test
    public void artigoComInvalidaBibTexKey() throws ParseException {
        // Entrada esperada de um artigo com bibtexkey = a
        List<BibEntry> teste = parser.parseEntries("@article{a}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo artigo e com campo bibtexkey = a
        insercao.setType("article");
        insercao.setField("bibtexkey", "a");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar bibtexkey invalida de um artigo
    // Para ser valida a bibtexkey deve ter comprimento superior a dois caracteres e começar com uma letra
    @Test
    public void artigoComInvalidaBibTexKey2() throws ParseException {
        // Entrada esperada de um artigo com bibtexkey = a
        List<BibEntry> teste = parser.parseEntries("@article{2aa}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo artigo e com campo bibtexkey = a
        insercao.setType("article");
        insercao.setField("bibtexkey", "2aa");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar bibtexkey valida de um artigo
    // Para ser valida a bibtexkey deve ter comprimento superior a dois caracteres e começar com uma letra
    @Test
    public void artigoComValidaBibTexKey() throws ParseException {
        // Entrada esperada de um artigo com bibtexkey = aa2
        List<BibEntry> teste = parser.parseEntries("@article{aa2}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo artigo e com campo bibtexkey = aa2
        insercao.setType("article");
        insercao.setField("bibtexkey", "aa2");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar bibtexkey valida de um artigo
    // Para ser valida a bibtexkey deve ter comprimento superior a dois caracteres e começar com uma letra
    // Comecando com maiuscula
    @Test
    public void artigoComValidaBibTexKey2() throws ParseException {
        // Entrada esperada de um artigo com bibtexkey = Aa2
        List<BibEntry> teste = parser.parseEntries("@article{Aa2}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo artigo e com campo bibtexkey = Aa2
        insercao.setType("article");
        insercao.setField("bibtexkey", "Aa2");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar ano invalido de um artigo
    // Para ser valido conforme o calendario gregoriano o ano deve ser maior ou igual a 1592
    @Test
    public void artigoComAnoInvalido() throws ParseException {
        // Entrada esperada de um artigo com ano = 1591
        List<BibEntry> teste = parser.parseEntries("@article{, year = {1591}}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo artigo e com campo ano = 1591
        insercao.setType("article");
        insercao.setField("year", "1591");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar ano invalido de um artigo
    // Para ser valido conforme o calendario gregoriano o ano deve ser maior ou igual a 1592
    // Testes com dois numeros invalidos diferentes deve produzir o mesmo resultado
    @Test
    public void artigoComAnoInvalido2() throws ParseException {
        // Entrada esperada de um artigo com ano = 1591
        List<BibEntry> teste = parser.parseEntries("@article{, year = {1591}}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo artigo e com campo ano = 533
        insercao.setType("article");
        insercao.setField("year", "533");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar ano valido de um artigo
    // Para ser valido conforme o calendario gregoriano o ano deve ser maior ou igual a 1592
    @Test
    public void artigoComAnoValido() throws ParseException {
        // Entrada esperada de um artigo com ano = 1592
        List<BibEntry> teste = parser.parseEntries("@article{, year = {1592}}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo artigo e com campo ano = 1592
        insercao.setType("article");
        insercao.setField("year", "1592");
        assertEquals(Collections.singletonList(insercao), teste);
    }

    // Teste para verificar ano valido de um artigo
    // Para ser valido conforme o calendario gregoriano o ano deve ser maior ou igual a 1592
    @Test
    public void artigoComAnoValido2() throws ParseException {
        // Entrada esperada de um artigo com ano = 1910
        List<BibEntry> teste = parser.parseEntries("@article{, year = {1910}}");

        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry();

        // Entrada inserida do tipo artigo e com campo ano = 1910
        insercao.setType("article");
        insercao.setField("year", "1910");
        assertEquals(Collections.singletonList(insercao), teste);
    }


    // Testes para o Null Pointer Exception
    // Os testes devem falhar pois apontam para um endereço inexistente
    // Teste com entrada do campo autor null
    @Test(expected = NullPointerException.class)
    public void artigoComAutorNull() {
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry("article");

        // Insere autor com campo null na entrada a ser comparada
        insercao.setField("author", null);
        fail();
    }

    // Teste com entrada do campo titulo null
    @Test(expected = NullPointerException.class)
    public void artigoComTituloNull() {
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry("article");

        // Insere titulo com campo null na entrada a ser comparada
        insercao.setField("title", null);
        fail();
    }

    // Teste com entrada do campo journal null
    @Test(expected = NullPointerException.class)
    public void artigoComJournalNull() {
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry("article");

        // Insere titulo com campo null na entrada a ser comparada
        insercao.setField("journal", null);
        fail();
    }

    // Teste com entrada do campo ano null
    @Test(expected = NullPointerException.class)
    public void artigoComAnoNull() {
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry("article");

        // Insere ano com campo null na entrada a ser comparada
        insercao.setField("year", null);
        fail();
    }

    // Teste com entrada do campo bibtexkey null
    @Test(expected = NullPointerException.class)
    public void artigoComBibTexKeyNull() {
        // Instancia uma nova entrada a ser inserida e comparada com a esperada
        BibEntry insercao = new BibEntry("article");

        // Insere bibtexkey com campo null na entrada a ser comparada
        insercao.setField("bibtexkey", null);
        fail();
    }
}