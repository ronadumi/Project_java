package discordbotqa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class Utilitati {
    public static String citesteToateLiniile(BufferedReader br) {
        return br.lines().collect(Collectors.joining(System.lineSeparator()));
    }

    public static String iaToken() {
        try (BufferedReader citeste = new BufferedReader(new FileReader("Token.yml"))) {
            return citesteToateLiniile(citeste);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String iaTokenSpecial() {
        try (BufferedReader citeste = new BufferedReader(new FileReader("SToken.yml"))) {
            return citesteToateLiniile(citeste);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
