import java.io.*;
public class Nuke2 {
public static void main(String[] arg) throws IOException 
{
BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Please input a word.");
StringBuilder inputline=new StringBuilder(kb.readLine());
inputline.delete(1,2);
System.out.println(inputline);








}
}