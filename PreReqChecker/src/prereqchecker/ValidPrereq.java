package prereqchecker;
import java.util.ArrayList;

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
 * 4. b lines, each with a course ID
 * 
 * Step 2:
 * ValidPreReqInputFile name is passed through the command line as args[1]
 * Read from ValidPreReqInputFile with the format:
 * 1. 1 line containing the proposed advanced course
 * 2. 1 line containing the proposed prereq to the advanced course
 * 
 * Step 3:
 * ValidPreReqOutputFile name is passed through the command line as args[2]
 * Output to ValidPreReqOutputFile with the format:
 * 1. 1 line, containing either the word "YES" or "NO"
 */
public class ValidPrereq
{
    public static void main(String[] args)
    {

        if (args.length<3)
        {
            StdOut.println("Execute: java -cp bin prereqchecker.ValidPrereq <adjacency list INput file> <valid prereq INput file> <valid prereq OUTput file>");
            return; // this will return
        }

        digraph graph = new digraph(args[0]);

        ArrayList<ArrayList<String>> adjList = graph.getAdjList();

        StdIn.setFile(args[1]);

        String A1 = StdIn.readLine();

        String A2= StdIn.readLine();

        graph.addEdge(adjList, A1, A2);

        StdOut.setFile(args[2]);
        
        if (graph.isCyclic()) StdOut.println("No"); // this will print No

        else StdOut.println("Yes"); // this will print Yes
    }
}

// java -cp bin prereqchecker.ValidPrereq adjlist.in validprereq.in validprereq.out
// this is the end of the program