import com.thinking.machines.seq.*;
import com.thinking.machines.seq.exceptions.*;
import com.thinking.machines.seq.interfaces.*;

public class testcase
{
public static void main(String gg[])
{
SequenceGenerator sequenceGenerator=SequenceGenerator.getInstance();
try
{
int id =sequenceGenerator.getNext(gg[0]);
System.out.println(gg[0]+" "+id);
}
catch(SequenceException se) {System.out.println(se);}
}

}