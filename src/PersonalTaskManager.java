public class PersonalTaskManager {
    public static void main(String[] args) {
        TaskService.addNewTask(
            "Mua sách",
            "Sách Công nghệ phần mềm",
            "2025-07-20",
            "Cao"
        );

        TaskService.addNewTask(
            "Mua sách",
            "Sách Công nghệ phần mềm",
            "2025-07-20",
            "Cao"
        );

        TaskService.addNewTask(
            "",
            "Không có tiêu đề",
            "2025-07-22",
            "Thấp"
        );
    }
}
