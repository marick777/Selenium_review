package com.cydeo.tests.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
In this class, we eill be creating the re-usable logic to read from
configuration.properties file
 */
public class ConfigurationReader {

    //STEPS TO READ PROPERTIES TYPE OF FILE

    //1 - create object of Properties(create object)
    //make it "private" so we are limiting access to the object
    //"static" is to make sure it's created and loaded before everything else
    private static Properties properties = new Properties();

    static {

        try {
            //2 - We need to open the files in Java memory using FileInputStream(open file)
            FileInputStream file = new FileInputStream("configuration.properties");

            //3 - Load the properties file in the Properties object(load properties)
            properties.load(file);

            // close the file in the memory
            file.close();

        } catch (IOException e) {
            System.err.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }
    }
    //create a utility method to use the object to read
    //4 - Use the "properties" object to read value from the file(read properties)


    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

}
