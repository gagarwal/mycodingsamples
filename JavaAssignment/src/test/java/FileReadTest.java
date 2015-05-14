package test.java;

import java.io.FileNotFoundException;
import java.io.IOException;

import main.java.FileRead;

import org.junit.Test;

/**
 * <p>
 * Test class for {@link FileRead}
 * </p>
 * 
 * @author BK
 */
public class FileReadTest
{

    /**
     * Test the ideal case where each entry has a count associated.
     * @throws IOException This exception is thrown if anything goes wrong with I/O operations.
     * @throws FileNotFoundException This exception is thrown if test file does not exist in the given path.
     */
    @Test
    public void happyPath() throws FileNotFoundException, IOException
    {
        FileRead.printcount("C:/Users/happyPath.txt");
    }

    /**
     * Test the case where file does not exist in the path given.
     * @throws IOException This exception is thrown if anything goes wrong with I/O operations.
     * @throws FileNotFoundException This exception is thrown if test file does not exist in the given path.
     */
    @Test(expected = FileNotFoundException.class)
    public void fileDoesNotExist() throws FileNotFoundException, IOException
    {
        FileRead.printcount("C:/Users/fileDoesNotExist.txt");
    }
    
    /**
     * Test the case where file has a row with no comma
     * @throws IOException This exception is thrown if anything goes wrong with I/O operations.
     * @throws FileNotFoundException This exception is thrown if test file does not exist in the given path.
     */
    @Test
    public void rowWithNoComma() throws FileNotFoundException, IOException
    {
        FileRead.printcount("C:/Users/noComma.txt");
    }
    
    /**
     * Test the case where file has a row with comma but no value associated.
    * @throws IOException This exception is thrown if anything goes wrong with I/O operations.
     * @throws FileNotFoundException This exception is thrown if test file does not exist in the given path.
     * @throws NumberFormatException This exception is thrown if number after is not a valid number.
     */
    @Test
    public void rowWithCommaButNoNumber() throws FileNotFoundException, IOException
    {
        FileRead.printcount("C:/Users/commaNoData.txt");
    }
    
    /**
     * Test the case where file has a non numeric value after comma.
     * @throws IOException This exception is thrown if anything goes wrong with I/O operations.
     * @throws FileNotFoundException This exception is thrown if test file does not exist in the given path.
     * @throws NumberFormatException This exception is thrown if number after is not a valid number.
     */
    @Test(expected=NumberFormatException.class)
    public void rowWithCommaInvlaidNumber() throws FileNotFoundException, IOException
    {
        FileRead.printcount("C:/Users/InvalidData.txt");
    }
}
