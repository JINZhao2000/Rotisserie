package com.ayy.interceptor;

import com.ayy.bean.Manager;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 26/02/2021
 * @ Version 1.0
 */
public class LoginInterceptor implements Interceptor {
    @Override
    public void destroy() {}

    @Override
    public void init() {}

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String actionName = invocation.getProxy().getActionName();
        if(actionName.equals("login")) {
            return invocation.invoke();
        }
        Manager manager = (Manager) invocation.getInvocationContext().getSession().get("manager");
        if (null != manager) {
            return invocation.invoke();
        }
        return Action.LOGIN;
    }
}
