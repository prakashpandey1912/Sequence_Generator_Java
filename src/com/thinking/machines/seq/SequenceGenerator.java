package com.thinking.machines.seq;
import com.thinking.machines.seq.exceptions.*;
import com.thinking.machines.seq.interfaces.*;
import java.util.*;
import java.io.*;
public class SequenceGenerator implements SequenceGeneratorInterface
{
private SequenceGenerator()
{
}
private static SequenceGenerator SequenceGenerator=null;
public static SequenceGenerator getInstance()
{
if(SequenceGenerator==null) SequenceGenerator=new SequenceGenerator();
return SequenceGenerator;
}
public int getNext(String entity) throws SequenceException
{
int newNumber=1;
try
{

int lastNumber,commaPosition;
String line,pc1,pc2;
boolean found=false;
String fileName="Sequence.seq";
LinkedList<String> list= new LinkedList<String>();
File file= new File(fileName);
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
line=randomAccessFile.readLine();
commaPosition=line.indexOf(",");
pc1=line.substring(0,commaPosition);
pc2=line.substring(commaPosition+1);
if(entity.equals(pc1))
{
lastNumber=Integer.parseInt(pc2);
newNumber=lastNumber+1;
list.add(entity+","+newNumber);
found=true;
}
else
{ 
list.add(line);
}
}
if(found==false) list.add(entity+","+1);
randomAccessFile.seek(0);
for(String s:list) randomAccessFile.writeBytes(s+"\n");

randomAccessFile.close();
return newNumber;
}catch(IOException ioException)
{
throw new SequenceException("Unable to generate Sequence for "+entity+"reason :"+ioException.getMessage());
}
}
}