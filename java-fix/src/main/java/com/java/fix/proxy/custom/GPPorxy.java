package com.java.fix.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class GPPorxy {

    private static String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader classLoader, Class<?>[] interfaces, GPInvocationHandler h) {
        try {
            String proxySrc = generateSrc(interfaces[0]);
            String filePath = GPPorxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
            f.delete();

            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBuilder src = new StringBuilder();
        src.append("package com.java.fix.proxy.custom;").append(ln);
        src.append("import java.lang.reflect.Method;").append(ln);
        src.append("public class $Proxy0 implements ").append(interfaces.getName()).append("{").append(ln);
        src.append("GPInvocationHandler h;").append(ln);
        src.append("public $Proxy0(GPInvocationHandler h) {").append(ln);
        src.append("this.h = h;").append(ln);
        src.append("}").append(ln);

        for (Method m : interfaces.getMethods()) {
            src.append("public ").append(m.getReturnType().getName()).append(" ").append(m.getName()).append("(){").append(ln);
            src.append("try{").append(ln);
            src.append("Method m = ").append(interfaces.getName()).append(".class.getMethod(\"").append(m.getName()).append("\",new Class[]{});").append(ln);
            src.append("this.h.invoke(this,m,null);").append(ln);
            src.append("}catch(Throwable e){e.printStackTrace();}").append(ln);
            src.append("}").append(ln);
        }

        src.append("}");
        return src.toString();
    }
}
