/* (C) 2023 */
package problemsolving;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Java Source MicrosoftTest.java created on Jun 8, 2021
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */
public class MicrosoftTest {

    @Test
    public void testFileNames() {

        final List<String> files = new ArrayList<>();

        files.add("715K 2009-09-23 system.zip~");
        files.add("179K 2013-08-14 to-do-list.xml~");

        files.add("645K 2013-06-19 blockbuster.mpeg~");
        files.add("536 2010-12-12 notes.html");
        files.add("688M 1990-02-11 delete-this.zip~");
        files.add("23K 1987-05-24 setup.png~");
        files.add("616M 1965-06-06 important.html");
        files.add("14M 1992-05-31 crucial-module.java~");
        files.add("192K 1990-01-31 very-long-filename.dll~");

        final LocalDate lastModified = LocalDate.parse("1990-01-31");

        final int min =
                files.stream()
                        .filter(
                                s -> {
                                    final String token[] = s.trim().split(" ");
                                    final String size = token[0];
                                    final String date = token[1];
                                    final String fileName = token[2];

                                    final Integer iSize =
                                            Integer.parseInt(
                                                    size.trim()
                                                            .replaceAll("[^-?0-9]+", " ")
                                                            .trim());
                                    final boolean isSizeValid =
                                            size.contains("M") && iSize < 14 || size.contains("K")
                                                    ? true
                                                    : false;

                                    final boolean isAfter =
                                            LocalDate.parse(date.trim()).isAfter(lastModified);
                                    final boolean isBackup = fileName.trim().endsWith("~");

                                    return isSizeValid && isAfter && isBackup;
                                })
                        .map(
                                f -> {
                                    final String token[] = f.trim().split(" ");
                                    final String fileName = token[2];
                                    return fileName.substring(0, fileName.lastIndexOf("."));
                                })
                        .peek(
                                f -> {
                                    System.out.println(f);
                                })
                        .mapToInt(
                                f -> {
                                    return f.length();
                                })
                        .min()
                        .getAsInt();

        System.out.println(String.valueOf(min));
    }

    @Test
    public void testIntegers() {
        final int a = 6, b = 20;
        int count = 0;
        int temp = 0;
        int next = 1;
        for (int i = 1; i <= b; i++) {

            next = i + 1;
            temp = i * next;

            if (temp >= a && temp <= b) {
                System.out.println(String.format("Pair found : %s*%s=%s", i, next, temp));
                count++;
            }
        }
        System.out.println(count);
    }
}
