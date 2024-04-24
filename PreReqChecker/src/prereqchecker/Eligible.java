package prereqchecker;
import java.util.*;

// Name: Srotriyo Sengupta RUID: 193008050 Email: ss3414@scarletmail.rutgers.edu
// this is the beginning of the program

/**
 * 
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
 * EligibleInputFile name is passed through the command line as args[1]
 * Read from EligibleInputFile with the format:
 * 1. c (int): Number of courses
 * 2. c lines, each with 1 course ID
 * 
 * Step 3:
 * EligibleOutputFile name is passed through the command line as args[2]
 * Output to EligibleOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class Eligible
{
    public static void main(String[] args)
    {

        if (args.length < 3)
        {
            StdOut.println("Execute: java -cp bin prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
            return;
        }

        ArrayList<String> areYouEligible = new ArrayList<String>();

        digraph graph = new digraph(args[0]);

        ArrayList<ArrayList<String>> adjList = graph.getAdjList();

        String[] catalog = graph.getCourseCatalog();

        StdIn.setFile(args[1]);

        int q = StdIn.readInt();

        ArrayList<String> givenCourses = new ArrayList<>(); 

        StdIn.readLine(); 

        for(int w = 0; w < q; w+=1 )

        {
            String lineS = StdIn.readLine();

            if(!lineS.equals("")) givenCourses.add(lineS); 

        }

        for (int w = 0; w < q; w+=1)

        {
            graph.DFS(givenCourses.get(w));

        }

        ArrayList<String> TakenCourses = new ArrayList<>(); 

        TakenCourses = graph.getAllCoursesTaken(); 
    
        for(int w = 0; w < catalog.length; w+=1)

        {
            String lineC = catalog[w];

            ArrayList<String> preReq = adjList.get(w);

            boolean eligible = true; 

            for (String p: preReq)

            {
                
                if (!TakenCourses.contains(p)) eligible = false;

            }

            if (eligible)

            {
                if (!TakenCourses.contains(lineC)) areYouEligible .add(lineC);

            }
        }
        StdOut.setFile(args[2]);

        for(String c: areYouEligible ) StdOut.println(c);
    }
}

// java -cp bin prereqchecker.Eligible adjlist.in eligible.in eligible.out
// this is the end of the program