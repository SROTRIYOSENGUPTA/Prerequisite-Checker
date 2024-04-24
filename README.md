Overview
Imagine (just for the sake of this assignment) that you are a student interested in the Rutgers Computer Science program. There are tons of courses available, many with prerequisites that need to be satisfied before they can be taken. It can get confusing to navigate what courses you need to take before other courses, and what courses are available to you given the courses you have already taken.

Luckily, you recognize that mapping out all the courses along with their prerequisites forms a DAG (Directed Acyclic Graph), or a graph with directed edges and no cycles.

![image](https://github.com/SROTRIYOSENGUPTA/Prerequisite-Checker/assets/69280834/f91c8817-c452-4a32-aead-85762c1a2d66)

NOTE: This is not a perfect example model. The presented graph doesn’t contain every CS course, just many popular ones. Additionally, it doesn’t convey certain options like taking math 135 instead of 151 or taking cs211 as a corequisite to cs214.

        Prerequisites are represented by a directed edge from the more advanced course to its prerequisite. For example, cs112 has an edge to cs111 since cs111 is a prerequisite to cs112. The way our model is set up, a course must have ALL of its prerequisites satisfied in order to be taken, which means all of a course’s immediate neighbors (adjacent vertices) in the digraph must be completed. Note that while some advanced courses may not require a prerequisite directly, they may require a prerequisite indirectly. For example, cs211 only has cs112 as a direct prerequisite, but if you’ve taken cs211 you must have also taken cs111 and mat151. Thus, cs111 and mat151 are indirect prerequisites to cs211 and cs112 is a direct prerequisite. Connections to indirect prerequisites are implied and redundant, so they need not be stored in the graph.


Using StdIn and StdOut
Use StdIn.setFile(fileName) to set the current input file you want to read from.
You can now use methods like StdIn.readInt(), StdIn.readString() and StdIn.readLine() to operate on the input file as if it was standard input.
The methods StdIn.readInt() and StdIn.readString() actually leave the newline character unread, so if you use StdIn.readLine() after one of these methods, it will read this character rather than the next line. If you want to read the next line with StdIn.readLine(), you will need to call StdIn.readLine() once to read the newline character and then again to read the next line. StdIn.readInt() and StdIn.readString() ignore spaces and newlines by default.
Use StdOut.setFile(fileName) to set the current output file you want to write to. It creates the file if it doesn’t already exist.
You can now use methods like StdOut.print() and StdOut.println() to operate on the output file as if it was standard output.
Autolab ignores empty lines and extra spaces the your output files may have.

Tasks
1. AdjList

This Java class will take two command line arguments in the following order: an adjacency list input file name and an output file name.
The input file will be formatted as follows:
An integer a (the number of courses)
a lines, each with a course ID (a string)
An integer b (the number of prereq connections)
b lines, each with a course ID, then one of its direct prerequisites (space separated)
Every course ID is guaranteed to NOT contain spaces or newlines
You will use this list of prereq connections to construct an adjacency list, then output it to the output file.
a lines, where each line starts with a course ID and a space, then lists all the course’s immediate prerequisites (space separated)
The order in which you output the lines, as well as the order in which you output the courses in each line after the first DOES NOT MATTER for grading.The output file will be formatted as follows:
Here is one example of a correct “adjlist.out” file obtained from running the AdjList.java file with the command line arguments “adjlist.in” and “adjlist.out” in that order.

![image](https://github.com/SROTRIYOSENGUPTA/Prerequisite-Checker/assets/69280834/efde2985-05bd-41b3-8413-436a421c7a7b)

2. ValidPrereq

This Java class will take three command line arguments in the following order: an adjacency list input file, a prereq input file and an output file.
The adjacency list input file will be formatted exactly as the one from AdjList.
The prereq input file will be formatted as follows:
1 line containing the ID for course 1
1 line containing the ID for course 2
You will use the graph described by the adjacency list input file to answer the following question about the courses: If course 2 was an immediate prerequisite for course 1, would all courses still be possible to take? (Remember, a course can only be taken once all its immediate prerequisites have been met). For example, adding cs111 as a prerequisite to cs211 is redundant, but doesn’t cause any problems and all courses are still possible to take. Adding cs211 as a prerequisite to cs111 creates a situation where you cannot take cs111 OR cs211 OR anything in between, so all courses are no longer possible to take.
The output file will be formatted as follows:
One line, containing either “YES” or “NO”. “YES” if all courses are still possible to take for a new student, and “NO” otherwise.
Here is the correct “validprereq.out” file obtained from running the ValidPrereq.java file with the command line arguments “adjlist.in”, “validprereq.in”, and “validprereq.out” in that order.

![image](https://github.com/SROTRIYOSENGUPTA/Prerequisite-Checker/assets/69280834/f3b82a2a-e3ef-460c-ad61-cf8df817469a)

3. Eligible

This Java class will take three command line arguments: an adjacency list input file, an eligible input file, and an output file.
The adjacency list input file will be formatted exactly as the one from AdjList.
The eligible input file will be formatted as follows:
An integer c (the number of courses)
c lines, each with one course ID
Assume you have completed these c courses, all their prerequisites (both direct and indirect) and nothing else. What are all the courses that you are eligible to take now (and haven’t taken yet)?
The output file will be formatted as follows:
For each course you are now eligible to take, output its course ID on its own line.
The order in which you output the course IDs DOES NOT MATTER for grading.
Here is one example of a correct “eligible.out” file obtained from running the Eligible.java file with the command line arguments “adjlist.in”, “eligible.in”, and “eligible.out” in that order.

![image](https://github.com/SROTRIYOSENGUPTA/Prerequisite-Checker/assets/69280834/b043a064-f6b1-4134-97ba-eb82b7290364)

4. NeedToTake

This Java class will take three command line arguments in the following order: an adjacency list input file, a need to take input file, and an output file.
The adjacency list input file will be formatted exactly as the one from AdjList.
The need to take input file will be formatted as follows:
One line containing a course ID (target course)
An integer d (the number of taken courses)
d lines, each with one course ID (taken course)
Assume you have taken these d courses, all their prerequisites (both direct and indirect), and nothing else. What are all the courses that you have NOT taken yet, which are required in order to take the target course? In other words, what direct and indirect prerequisites of the target course have you not taken yet?
The output file will be formatted as follows:
For each course you need to take, output its course ID on its own line.
The order in which you output the course IDs DOES NOT MATTER for grading.
Here is one example of a correct “needtotake.out” file obtained from running the NeedToTake.java file with the command line arguments “adjlist.in”, “needtotake.in” and “needtotake.out” in that order.

![image](https://github.com/SROTRIYOSENGUPTA/Prerequisite-Checker/assets/69280834/9b3a86a8-d3c7-47d1-ad6c-f398aef510cb)

5. CHALLENGE: SchedulePlan (0 points)

This problem does not count towards the assignment grade.
This Java class will take three command line arguments in the following order: an adjacency list input file, a schedule plan input file, and an output file.
The adjacency list input file will be formatted exactly as the one from AdjList.
The schedule plan input file will be formatted as follows:
One line containing a course ID (target course)
An integer e (the number of taken courses)
e lines, each with one course ID (taken course)
Assume you have taken these e courses, all their prerequisites (both direct and indirect), and nothing else. Plan out a schedule such that you are eligible to take the target course in the FEWEST POSSIBLE number of semesters. Remember that you can’t actually include a course in a semester until all its direct prerequisites were satisfied in previous semesters.
The output file will be formatted as follows:
An integer f (the number of semesters)
f lines, each with some number of space separated course ID’s
ANY VALID SCHEDULE which ends with you being able to take the target course will be accepted by the grader, as long as you utilize the minimum possible number of semesters.
Here is one example of a correct “scheduleplan.out” file obtained from running the SchedulePlan.java file with the command line arguments “adjlist.in”, “scheduleplan.in” and “scheduleplan.out” in that order. For an additional challenge, try to solve the problem with the restriction that you cannot take more than 3 courses per semester. This variation is SIGNIFICANTLY harder and will not be graded.

![image](https://github.com/SROTRIYOSENGUPTA/Prerequisite-Checker/assets/69280834/9df9ecac-a91f-4dc6-a3b8-4d8ca0822c5d)

Helpful Java Classes
The following are some data structures which are automatically imported with “java.util.*” that can help make your code cleaner and more efficient. You are free to not use any of these, and you are also free to use any other class under “java.util.*” as you see fit. I will not be covering every single method for these data structures, just some useful ones for this assignment. You can find more information about how to use these classes online.

ArrayList is an ordered array-like structure with no size limit, as it automatically resizes
You can initialize an empty ArrayList named “name” which holds objects of type “Type” with ArrayList name = new ArrayList();
For example, an ArrayList of integers named “arrList” is initialized with ArrayList arrList = new ArrayList<>();
You can add a new element of type “Type” to the end of your ArrayList in average case O(1) time with name.add(newElement);
You can get the element at some index of your ArrayList in O(1) time with name.get(index);
You can set some index to some new element in O(1) time with name.set(index, newElement);
You can check if the ArrayList contains some element (returns a boolean) in O(n) time with name.contains(element)
Queue implements a FIFO structure
You can initialize an empty Queue named “name” which holds objects of type “Type” with Queue name = new LinkedList<>();
For example, a Queue of integers named “q” is initialized with Queue q = new LinkedList<>();
You can add a new element of type “Type” to the back of your Queue in O(1) time with name.add(newElement);
You can get the element at the front of the Queue with name.peek()
You can get and delete the element at the front of the queue with name.remove()
HashMap is an unordered data structure which stores and retrieves key value pairs
You can initialize an empty HashMap named “name” that maps objects of type “Key” to objects of type “Value” with HashMap<Key, Value> name = new HashMap<>();
For example, a HashMap named “map” which maps strings to integers is initialized with HashMap<String, Integer> map = new HashMap<>();
You can add a new key value pair, or update an existing key with a new value in average case O(1) time with name.put(key, value);
You can check if the HashMap contains some key in average case O(1) time (returns a boolean) with name.containsKey(key)
You can check the value of some key in the HashMap in average case O(1) time with name.get(key)
You can iterate over all the keys in the HashMap with for (Key key : name.keySet()) where Key is the type of keys in the HashMap.
HashSet is an unordered data structure which only stores keys
You can initialize an empty HashSet named “name” that stores objects of type “Key” with HashSet name = new HashSet<>();
For example, a HashSet named “set” which stores strings is initialized with HashSet set = new HashSet<>();
You can add a new key to the hash set in average case O(1) time with name.add(key)
You can check if a key exists in the hash set in average case O(1) time (returns a boolean) with name.contains(key)
You can remove a key in average case O(1) time with name.remove(key)
You can iterate over all the keys in the HashSet with for (Key key : name) where Key is the type of keys in the HashSet.



