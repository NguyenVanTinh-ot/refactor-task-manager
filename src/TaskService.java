import java.time.LocalDate;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TaskService {

    public static JSONObject addNewTask(String title, String description, String dueDateStr, String priorityLevel) {
        if (!TaskValidator.isValidTitle(title)) {
            System.out.println("Lỗi: Tiêu đề không hợp lệ.");
            return null;
        }

        LocalDate dueDate = TaskValidator.parseDueDate(dueDateStr);
        if (dueDate == null) {
            System.out.println("Lỗi: Ngày đến hạn không hợp lệ.");
            return null;
        }

        if (!TaskValidator.isValidPriority(priorityLevel)) {
            System.out.println("Lỗi: Mức độ ưu tiên không hợp lệ.");
            return null;
        }

        JSONArray tasks = TaskRepository.loadTasksFromDb();
        for (Object obj : tasks) {
            JSONObject t = (JSONObject) obj;
            if (t.get("title").toString().equalsIgnoreCase(title) &&
                t.get("due_date").toString().equals(dueDateStr)) {
                System.out.println("Lỗi: Nhiệm vụ đã tồn tại.");
                return null;
            }
        }

        String id = UUID.randomUUID().toString();
        Task task = new Task(id, title, description, dueDate, priorityLevel);
        JSONObject taskJson = task.toJsonObject();
        tasks.add(taskJson);
        TaskRepository.saveTasksToDb(tasks);

        System.out.println("Thêm nhiệm vụ thành công với ID: " + id);
        return taskJson;
    }
}
