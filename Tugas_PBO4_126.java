import java.util.ArrayList;
import java.util.List;


interface Folder {
    void add(File file);
    void remove(File file);
    void display();
}


abstract class File {
    protected String name;
    protected int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public abstract void display();
}


class FolderImpl implements Folder {
    private String name;
    private List<File> files;

    public FolderImpl(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }

    @Override
    public void add(File file) {
        files.add(file);
    }

    @Override
    public void remove(File file) {
        files.remove(file);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name);
        System.out.println("Files:");
        for (File file : files) {
            file.display();
        }
    }
}


class TextFile extends File {
    public TextFile(String name, int size) {
        super(name, size);
    }

    @Override
    public void display() {
        System.out.println("Text File - Name: " + name + ", Size: " + size + " bytes");
    }
}

class ImageFile extends File {
    public ImageFile(String name, int size) {
        super(name, size);
    }

    @Override
    public void display() {
        System.out.println("Image File - Name: " + name + ", Size: " + size + " bytes");
    }
}

public class FolderManagement {
    public static void main(String[] args) {
        
        Folder folder = new FolderImpl("My Folder");

        
        File textFile1 = new TextFile("file1.txt", 1024);
        File textFile2 = new TextFile("file2.txt", 2048);
        File imageFile = new ImageFile("image.jpg", 4096);

        
        folder.add(textFile1);
        folder.add(textFile2);
        folder.add(imageFile);

        
        folder.display();

        
        folder.remove(textFile2);

        
        folder.display();
    }
}
