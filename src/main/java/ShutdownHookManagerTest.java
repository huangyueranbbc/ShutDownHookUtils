/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 *
 * @date 2018-11-07 下午 1:53 
 * @author: <a href=mailto:huangyr@bonree.com>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class ShutdownHookManagerTest {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("hello 1");
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("hello 2");
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                System.out.println("hello 3");
            }
        };

        ShutdownHookManager shutdownHookManager = ShutdownHookManager.get();
        shutdownHookManager.addShutdownHook(t1, HookPriority.MAX_PRIORITY.value());
        shutdownHookManager.addShutdownHook(t2, HookPriority.MIN_PRIORITY.value());
        shutdownHookManager.addShutdownHook(t3, HookPriority.NORM_PRIORITY.value());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
