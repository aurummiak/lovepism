package project;


import java.util.ArrayList;

import static project.tasksAnastasia.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<String> list = new ArrayList<>();
        System.out.println("--Add--"); // add new
        add(list);
        System.out.println("--Delete--"); // delete
        delete(list);
        System.out.println("--Find Substring--"); // search
        search(list);
        System.out.println("--Work with files--"); // init
        initialize(list);
        System.out.println("--XML--"); // XML writing
        writeXmlFile(list);
        System.out.println("--Compare 2 elements--"); // compare
        compareElements(list);


    }

}
