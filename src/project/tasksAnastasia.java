package project;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class tasksAnastasia {
    public static void add(ArrayList list) {
        list.add("Vadik");
        list.add("Dima");
        list.add("Maria");
        list.add("Maria");
        list.add("Gennady");
        list.add("Anne");
        list.add("Anastasia");
        System.out.println(list);

    }


    public static void delete(ArrayList list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter element to delete:");
        int numberRemove = scanner.nextInt();
        list.remove(numberRemove);
        System.out.println(list);
    }


    public static void search(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            String s1 = (String) list.get(i);
            if (s1.contains("Maria")) {
                System.out.println("Substring: Match found");
            }
        }

    }

    public static void initialize(ArrayList list) throws Exception {

        FileWriter writer = new FileWriter("pism.txt");

        for (Object str : list) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();

        FileReader reader = new FileReader("pism.txt");
        System.out.print("Read from txt file: ");
        int i;

        while ((i = reader.read()) != -1) {


            System.out.print((char) i);
        }
    }

    public static void writeXmlFile(ArrayList<String> list) {

        try {

            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();

            Element root = doc.createElement("Info");
            doc.appendChild(root);

            Element Details = doc.createElement("Parts");
            root.appendChild(Details);


            for (String dtl : list) {

                Element name = doc.createElement("Elements");
                name.appendChild(doc.createTextNode(String.valueOf(list)));
                Details.appendChild(name);

            }

            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();

            aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

            aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            try {

                FileWriter fos = new FileWriter("newlist.xml");
                StreamResult result = new StreamResult(fos);
                aTransformer.transform(source, result);

            } catch (IOException e) {

                e.printStackTrace();
            }

        } catch (TransformerException ex) {
            System.out.println("Error outputting document");

        } catch (ParserConfigurationException ex) {
            System.out.println("Error building document");
        }
    }


    public static void compareElements(ArrayList list) {
        String result = "false";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first index: ");
        int firstIndex = scanner.nextInt();
        System.out.println("Enter second index: ");
        int secondIndex = scanner.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(firstIndex).equals(list.get(secondIndex))) {
                result = "true";
            }
        }
        System.out.print("Result from comparing: " + result);

    }
}

