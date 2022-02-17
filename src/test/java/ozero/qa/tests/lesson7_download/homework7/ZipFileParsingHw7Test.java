package ozero.qa.tests.lesson7_download.homework7;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;



import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static org.apache.commons.io.FileUtils.deleteDirectory;
import static org.assertj.core.api.Assertions.assertThat;

public class ZipFileParsingHw7Test {

    private ClassLoader cl = ZipFileParsingHw7Test.class.getClassLoader();

    private String dirForUnzip = "src/test/resources/files/";
    private String archiveZip = "src/test/resources/files/";
    private String zipArchiveName = "homework7_archive.zip";


    FileUnzipper fileUnzipper = new FileUnzipper(archiveZip,zipArchiveName,dirForUnzip);

//3. Реализовать чтение и проверку каждого файла в одном тесте

    @Test
    void readZipAndCheckFiles() throws Exception {


        ZipFile zipFile = new ZipFile("D:\\QA.GURU\\projects\\qa_guru_lesson_2\\src\\test\\resources\\files\\homework7_archive.zip");


//        SecurityManager securityManager = new SecurityManager();
//
//                securityManager.checkRead(zipFile);

        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while(entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            if(entry.isDirectory()){
                System.out.println("dir  : " + entry.getName());
            } else {
                System.out.println("file : " + entry.getName());

            }
        }



        fileUnzipper.unzip();

        try (InputStream stream = cl.getResourceAsStream("files/homework7_archive/csv_file.csv")) {
            CSVReader reader = new CSVReader(new InputStreamReader(stream));
            List<String[]> list = reader.readAll();
            assertThat(list)
                    .hasSize(5)
                    .contains(
                            new String[] {"Song", "Artist"},
                            new String[] {"Show Must Go On", "Queen"},
                            new String[] {"Still Waiting", "Sum 41"},
                            new String[] {"Modeler", "0ZERO"},
                            new String[] {"Song 1", " Blur"}
                    );
        }

        try (InputStream stream = cl.getResourceAsStream("files/homework7_archive/xls_file.xlsx")) {
            XLS parsed = new XLS(stream);
            System.out.println();
            assertThat(parsed.excel.getSheetAt(7).getRow(7).getCell(5).getStringCellValue())
                    .isEqualTo("1. Стендап\n" +
                            "2. ИФТ новой сборки\n" +
                            "3. АФТ ABK");
        }

        File pdfFromZip = new File("D:\\QA.GURU\\projects\\qa_guru_lesson_2\\src\\test\\resources\\files\\homework7_archive\\cert.pdf");
        PDF parsed = new PDF(pdfFromZip);

        //не парсится. Ка
        assertThat(parsed.text).contains("ЦИФРОВОЙ СЕРТИФИКАТ\n" +
                "Номер: 3P8M520XA4K3\n" +
                "ФИО: З***** М***** С********\n" +
                "Дата рождения: 13.06.1993\n" +
                "Статус: «Вакцинирован»\n" +
                "(полностью)\n" +
                "Начало действия: 08.06.2021\n" +
                "Окончание действия: 08.06.2022\n" +
                " \n");

//        deleteDirectory(new File("src/test/resources/files/homework7_archive"));

    }
}
