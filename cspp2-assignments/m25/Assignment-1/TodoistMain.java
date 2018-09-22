import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Todoist {
	private Task[] tasklist;
	private int size;
	Todoist() {
		tasklist = new Task[10];
		size = 0;
	}
	public void addTask(Task item) {
		if (size == tasklist.length) {
			resize();
		}
		tasklist[size++] = item;
	}
	/**
	 * resize.
	 */
	public void resize() {
		int resizefactor = 2;
		Task[] temp = new Task[resizefactor * size];
		for (int i = 0; i < size; i++) {
			temp[i] = tasklist[i];
		}
		tasklist = temp;
	}
	public void print() {
		int j = 0;
		for (Task i : tasklist) {
			if (j < size) {
				System.out.println(i.toString());
				j++;
			}
		}
	}
	public Task getNextTask(String name) {
		for (Task i : tasklist) {
			if (i.getname().equals(name) && i.getstatus().equals("todo") && i.getimp()) {
				if (!i.geturg()) {
					return i;
				}
			}
		}
		for (Task i : tasklist) {
			if (i.getname().equals(name) && i.getstatus().equals("todo") && i.getimp()) {
				if (i.geturg()) {
					return i;
				}
			}
		}
		return null;
	}
	public Task[] getNextTask(String name, int time) {
		return tasklist;
	}
	public int totalTime4Completion() {
		return 1;
	}
}
class Task {
	private String tasktitle;
	private String name;
	private int time;
	private boolean important;
	private boolean urgent;
	private String status;
	private int temp;
	Task() {

	}
	Task(String title, String assignedTo, int timeToComplete, boolean important1, boolean urgent1, String status1) {
		if (title.equals("")) {
			System.out.println("Title not provided");
		} else if (timeToComplete < 0) {
			System.out.println("Invalid timeToComplete " + Integer.toString(timeToComplete));
		} else if (status1.equals("todo") || status1.equals("done")) {
			tasktitle = title;
			name = assignedTo;
			time = timeToComplete;
			important = important1;
			urgent = urgent1;
			status = status1;
			temp = 1;
		} else {
			System.out.println("Invalid status " + status1);
		}
	}
	public int gettemp() {
		return temp;
	}
	public String getname() {
		return name;
	}
	public boolean getimp() {
		return important;
	}
	public boolean geturg() {
		return urgent;
	}
	public String getstatus() {
		return status;
	}
	public String toString() {
		if (!tasktitle.equals("")) {
			String s = tasktitle + ", " + name + ", " + Integer.toString(time) + ", ";
			if (important) {
				s += "Important, ";
			} else {
				s += "Not Important, ";
			}
			if (urgent) {
				s += "Urgent, ";
			} else {
				s += "Not Urgent, ";
			}
			s += status;
			return s;
		}
		return null;
	}
}
/**
 * Class for todoist main.
 */
public class TodoistMain {

	/**
	 * Starts a test.
	 */
	public static void startTest() {
		Todoist todo = new Todoist();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(",");
			switch (tokens[0]) {
			case "task":
				testTask(tokens);
				break;
			case "add-task":
				testAddTask(todo, tokens);
				break;
			case "print-todoist":
				todo.print();
				break;
			case "get-next":
				System.out.println(todo.getNextTask(tokens[1]));
				break;
			case "get-next-n":
				int n = Integer.parseInt(tokens[2]);
				Task[] tasks = todo.getNextTask(tokens[1], n);
				System.out.println(Arrays.deepToString(tasks));
				break;
			case "total-time":
				System.out.println(todo.totalTime4Completion());
				break;
			default:
				break;
			}
		}
	}

	/**
	 * method to test add task.
	 *
	 * @param      todo    The todo
	 * @param      tokens  The tokens
	 */
	public static void testAddTask(final Todoist todo, final String[] tokens) {
		try {
			todo.addTask(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to test the creation of task object.
	 *
	 * @param      tokens  The tokens
	 */
	public static void testTask(final String[] tokens) {
		try {
			Task s = createTask(tokens);
			if (s.gettemp() == 1) {
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Creates a task object.
	 *
	 * @param      tokens     The tokens
	 *
	 * @return     Task object
	 *
	 * @throws     Exception  if task inputs are invalid
	 */
	public static Task createTask(final String[] tokens) throws Exception {
		String title = tokens[1];
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];
		return new Task(
		           title, assignedTo, timeToComplete, important, urgent, status);
	}

	/**
	 * main method.
	 *
	 * @param      args  The command line arguments
	 */
	public static void main(final String[] args) {
		startTest();
	}
}
