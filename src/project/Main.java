package project;


import java.util.ArrayList;

import static project.tasksAnastasia.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<String> list = new ArrayList<>();
        System.out.println("--Add--"); // 1
        add(list);
        System.out.println("--Delete--"); // 1
        delete(list);
        System.out.println("--Find Substring--"); // 6
        search(list);
        System.out.println("--Work with files--"); // 7
        initialize(list);
        System.out.println("--XML--"); // 3
        writeXmlFile(list);
        System.out.println("--Compare 2 elements--"); // 8
        compareElements(list);


    }

}
