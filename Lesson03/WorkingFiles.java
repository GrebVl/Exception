package Lesson03;


import Lesson03.Human.Human;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WorkingFiles {
    private String path_to_file;
    private boolean append;
    private File file;

    public WorkingFiles(Human people) {
        this.path_to_file = people.getFullName().getSurname() + ".txt";
        this.file = new File(this.path_to_file);

        try {
            if (this.file.createNewFile()) {
                this.append = true;
            } else {
                this.append = false;
            }
        } catch (IOException var3) {
            System.out.println("Ошибка чтения файла.");
        }

    }

    public WorkingFiles(Human people, boolean value) {
        this.path_to_file = people.getFullName().getSurname() + ".txt";
        this.append = value;
    }

    public void fileWrite(Human people) throws MyFileNotFoundException {
        String text = people.toString();

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.path_to_file, true)));

            try {
                if (this.append) {
                    out.append(text);
                } else {
                    out.append("\n" + text);
                }

                System.out.println("Successfully written data to the file");
            } catch (Throwable var7) {
                try {
                    out.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            out.close();
        } catch (FileNotFoundException var8) {
            throw new MyFileNotFoundException("Файл не найден.", this.path_to_file);
        } catch (IOException var9) {
            System.out.println("Ошибка чтения файла.");
        }

    }
}

class MyFileNotFoundException extends Exception {
    private final String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public MyFileNotFoundException(String message, String fileName) {
        super(message);
        this.fileName = fileName;
    }
}
