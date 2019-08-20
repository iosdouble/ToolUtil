package com.nh.code.util.clazz;

import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

public class JavassistUtil {
    public JavassistUtil() {
    }

    public static String[] getFieldsName(Class<?> cls, String clazzName, String methodName) throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);
        CtClass cc = null;
        CtMethod cm = null;
        String[] paramNames = null;
        cc = pool.get(clazzName);
        cm = cc.getDeclaredMethod(methodName);
        paramNames = new String[cm.getParameterTypes().length];
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute)codeAttribute.getAttribute("LocalVariableTable");
        if (attr == null) {
            return null;
        } else {
            int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;

            for(int i = 0; i < paramNames.length; ++i) {
                paramNames[i] = attr.variableName(i + pos);
            }

            return paramNames;
        }
    }
}