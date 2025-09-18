import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.PriorityQueue;
// import java.util.Set;
import java.util.TreeSet;

class TaskManager {

  class Task implements Comparable<Task> {
    int userId;
    int taskId;
    int priority;

    public Task(int userId, int taskId, int priority) {
      this.userId = userId;
      this.taskId = taskId;
      this.priority = priority;
    }

    @Override
    public int compareTo(Task other) { // reversed conditions for high to low
      if (this.priority == other.priority) return other.taskId - this.taskId;
      return other.priority - this.priority;
    }
    
  }

  private final Map<Integer, Task> taskIdToTask = new HashMap<>();
  // private final PriorityQueue<Task> taskQueue = new PriorityQueue<>();
  private final TreeSet<Task> taskQueue = new TreeSet<>();
  
  public TaskManager(List<List<Integer>> tasks) {
    for (List<Integer> tsk : tasks) {
      Task task = new Task(tsk.get(0), tsk.get(1), tsk.get(2));
      taskQueue.add(task);
      taskIdToTask.put(task.taskId, task);
    }
  }

  public void add(int userId, int taskId, int priority) {
    Task task = new Task(userId, taskId, priority);
    taskQueue.add(task);
    taskIdToTask.put(task.taskId, task);
  }

  public void edit(int taskId, int newPriority) {
    Task task = taskIdToTask.get(taskId);
    taskQueue.remove(task);
    task.priority = newPriority;
    taskQueue.add(task);
    taskIdToTask.put(taskId, task);
  }

  public void rmv(int taskId) {
    Task task = taskIdToTask.remove(taskId);
    taskQueue.remove(task);
  }

  public int execTop() {
    if (taskQueue.isEmpty()) return -1;
    Task task = taskQueue.pollFirst();
    return task.userId;
  }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */