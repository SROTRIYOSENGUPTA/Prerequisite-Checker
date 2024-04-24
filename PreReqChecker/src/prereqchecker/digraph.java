package prereqchecker;
import java.util.ArrayList;
// Name: Srotriyo Sengupta RUID: 193008050 Email: ss3414@scarletmail.rutgers.edu
// this is the beginning of the program

class digraph
{
  private int S; // creating private integers

  private int T; // creating private integers

  public String[] catalog;

  public ArrayList<String> AllCoursesTaken;

  private ArrayList<ArrayList<String>> adj;
    
  public digraph(String inputFile)
  {
    StdIn.setFile(inputFile);

    this.S = StdIn.readInt();

    catalog = new String[S]; 

    StdIn.readLine();

    for(int a = 0; a < S; a+=1)

    {
      catalog[a] = StdIn.readLine();

    }

    this.T = StdIn.readInt();

    this.adj = new ArrayList<ArrayList<String>>(S); 

    for (int a = 0; a < S; a++) adj.add(new ArrayList<String>());
    
    int b = 0;

    while (b <= T)

    {
      String s = StdIn.readLine();

      if(!s.equals(""))

      {
        String[] temp = s.split(" ");

        addEdge(adj, temp[0], temp[1]);

      }

      b+=1; 

    }

    this.AllCoursesTaken = new ArrayList<>(); 

  }

  public ArrayList<ArrayList<String>> getAdjList()
  {
    return adj; 
  }

  public int getV()
  { 

    return S; 

  }

  public int getE()

  { 

    return T; 

  }

  public String[] getCourseCatalog()

  {

    return catalog;

  }

  public void addEdge(ArrayList<ArrayList<String>> adj, String c1, String c2)

  {
    int x = 0;

    for (int a = 0; a < catalog.length; a+=1)

    {

      if (catalog[a].equals(c1)) x = a;

    }

    adj.get(x).add(c2);

  }

  public boolean isCyclicUtil(String course, boolean[] visited, boolean[] recStack)
  {

    int index = 0;

    for (int i = 0; i < catalog.length; i++) 

    {

      if(catalog[i].equals(course)) index = i; 

    }

    if (recStack[index]) return true;

    if (visited[index]) return false; 

    visited[index] = true;

    recStack[index] = true;

    ArrayList<String> prereqs = adj.get(index); 

    for (String c : prereqs)

    { 

      if (isCyclicUtil(c, visited, recStack)) return true; 

    }

    recStack[index] = false;

    return false;
  }

  

  public void DFSUtils(int v, boolean[] visited)
  {
    visited[v] = true; 

    if(!AllCoursesTaken.contains(catalog[v])) AllCoursesTaken.add(catalog[v]);

    System.out.println(v + ": " + catalog[v]); 

    ArrayList<String> preReq = adj.get(v);

    if (preReq.size() == 0) return;
    
    for(int i = 0; i < preReq.size(); i+=1)
    {

      String c = preReq.get(i);  

      for (int j = 0; j < catalog.length; j+=1)

      {

        if (catalog[j].equals(c))

        {

          if(!visited[j]) DFSUtils(j, visited);

        }
      }
    }
  }

  public boolean isCyclic()
  {

    boolean[] recStack = new boolean[S];

    boolean[] visited = new boolean[S]; 

    for (int i = 0; i < S; i+=1)

    {
      if(isCyclicUtil(catalog[i], visited, recStack)) return true;

    }

    return false; 

  }


  public void DFS(String z)

  {    

    int v = 0;

    for(int i = 0; i < catalog.length; i+=1)

    {

      System.out.println(i);  

      if (catalog[i].equals(z)) v = i; 

    }

    boolean[] visited = new boolean[S];

    DFSUtils(v, visited);
  }

  public ArrayList<String> prereqDFSutils(ArrayList<String> a, int v, boolean[] visited)
  {
    visited[v] = true; 

    if(!a.contains(catalog[v])) a.add(catalog[v]); 

    ArrayList<String> prereqs = adj.get(v);

    if (prereqs.size() == 0) return a;
    
    for(int i = 0; i < prereqs.size(); i+=1)

    {
      String c = prereqs.get(i);  

      for (int j = 0; j < catalog.length; j+=1)

      {
        if (catalog[j].equals(c))

        {

          if(!visited[j]) prereqDFSutils(a, j, visited); 

        }
      }
    }

    return a; // this will return a 
  }

  public ArrayList<String> prereqDFS(ArrayList<String> a, String c)

  {
    int v = 0;

    for(int i = 0; i < catalog.length; i+=1)

    {

      if (catalog[i].equals(c)) v = i; 

    }
    boolean[] visited = new boolean[S];

    a = prereqDFSutils(a, v, visited);

    return a;

  }

  public ArrayList<String> getAllCoursesTaken()

  {

    return AllCoursesTaken;
    
  }
}

// this is the end of the program