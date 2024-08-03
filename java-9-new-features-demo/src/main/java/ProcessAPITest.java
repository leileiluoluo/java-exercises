public class ProcessAPITest {

    public static void main(String[] args) {
        // 获取当前进程的信息
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("当前进程 PID: " + currentProcess.pid());
        System.out.println("当前进程是否存活: " + currentProcess.isAlive());
        System.out.println("当前进程信息: " + currentProcess.info());

        // 遍历所有进程并打印信息
        ProcessHandle.allProcesses().forEach(process -> {
            System.out.println("PID: " + process.pid());
            System.out.println("命令: " + process.info().command().orElse("未知"));
            System.out.println("启动时间: " + process.info().startInstant().orElse(null));
            System.out.println("------------------------");
        });

        // 异步处理进程退出事件
        ProcessHandle handle = ProcessHandle.of(currentProcess.pid()).orElseThrow(() -> new IllegalArgumentException("无效的进程 ID"));
        handle.onExit().thenAccept(process -> {
            System.out.println("进程 " + process.pid() + " 已退出");
        });

        // 销毁指定进程
        ProcessHandle processHandle = ProcessHandle.of(currentProcess.pid()).orElseThrow(() -> new IllegalArgumentException("无效的进程 ID"));
        boolean destroyed = processHandle.destroy(); // processHandle.destroyForcibly();
        if (destroyed) {
            System.out.println("进程 " + currentProcess.pid() + " 已被销毁");
        } else {
            System.out.println("无法销毁进程 " + currentProcess.pid());
        }
    }

}
