import hanhan.p;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        File file = new File("1.txt");
        if(file.exists()){

        }else{
            file.createNewFile();
        }
        if(file.exists()){
            p.writeToTxt("我日你妈,原来如此","1.txt");
        }
    }
}
