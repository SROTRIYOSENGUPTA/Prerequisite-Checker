package prereqchecker;
import java.util.*;

// Name: Srotriyo Sengupta RUID: 193008050 Email: ss3414@scarletmail.rutgers.edu
// this is the beginning of the program


/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * NeedToTakeInputFile name is passed through the command line as args[1]
 * Read from NeedToTakeInputFile with the format:
 * 1. One line, containing a course ID
 * 2. c (int): Number of courses
 * 3. c lines, each with one course ID
 * 
 * Step 3:
 * NeedToTakeOutputFile name is passed through the command line as args[2]
 * Output to NeedToTakeOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class NeedToTake
{
    public static void main(String[] args)

    {
        if (args.length<3)

        {
            StdOut.println("Execute: java -cp bin prereqchecker.NeedToTake <adjacency list INput file> <need to take INput file> <need to take OUTput file>");

            return; // this will return
        }

        digraph graph = new digraph(args[0]);

        StdIn.setFile(args[1]);

        String entity = StdIn.readLine();

        int b = StdIn.readInt();

        String[] took = new String[b];

        StdIn.readLine();

        for (int f = 0; f < b; f+=1) took[f] = StdIn.readLine(); 

        ArrayList<String> coursesTook = new ArrayList<String>(); // creating a new array list of type string

        for (int f = 0; f < b; f+=1) graph.DFS(took[f]);

        coursesTook = graph.getAllCoursesTaken(); 

        ArrayList<String> entityPreReqs = new ArrayList<>(); // creating a new array list

        entityPreReqs = graph.prereqDFS(entityPreReqs, entity); 

        ArrayList<String> needToMakeTook = new ArrayList<>(); // creating a new array list

        for (int f = 1; f < entityPreReqs.size(); f+=1)
        {
            if (!coursesTook.contains(entityPreReqs.get(f))) needToMakeTook.add(entityPreReqs.get(f)); 

        }

        StdOut.setFile(args[2]);

        for (String p: needToMakeTook) StdOut.println(p); // this will print the string
    }
}
// java -cp bin prereqchecker.NeedToTake adjlist.in needtotake.in needtotake.out
// this is the end of the program