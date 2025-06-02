import java.util.ArrayList;
class TaskManager {
  ArrayList<Task> tasks = new ArrayList<>();

  void markTaskAsComplete(String description) {
    for (Task task: tasks) {
      if (task.description.toLowerCase().contains(description.toLowerCase())) {
        task.isComplete=true;
      }
    }
  }
  void listTasksByPriority() {
    for (int x=1; x<=5; x++) {
      System.out.println("Priority "+x+" Tasks");
      for (Task task: tasks) {
        if (task.priority==x&&task.isComplete==false) {
          System.out.println(task.description);
        }
      }
    }
  }
  public static void main(String[] args) {
    TaskManager taskManager = new TaskManager();
    Task task0 = new Task("do A", 1);
    taskManager.tasks.add(task0);
    Task task1 = new Task("do B", 2);
    taskManager.tasks.add(task1);
    Task task2 = new Task("do C", 3);
    taskManager.tasks.add(task2);
    Task task3 = new Task("do D", 4);
    taskManager.tasks.add(task3);
    Task task4 = new Task("do E", 5);
    taskManager.tasks.add(task4);
    taskManager.listTasksByPriority();
    System.out.println();
    //mark task as isComplete
    taskManager.markTaskAsComplete("do E");
    taskManager.listTasksByPriority();
  }
}
class Task {
  String description;
  int priority; //1-5
  boolean isComplete;
  Task(String description, int priority) {
    this.description=description;
    this.priority=priority;
    isComplete=false;
  }
}
