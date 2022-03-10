package Action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import Model.User;

public class AuthenticatedInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> session = invocation.getInvocationContext().getSession();

        User nd = (User) session.get("nguoidung");

        if (nd == null) {
            //Neu null session thi khong cho vao home.jsp
            return Action.LOGIN;
        } else {
            //Neu co session thi cho vao home.jsp
        	
        	if(nd.getLoaiquyen().equals("ADMIN"))
			{
    			return "admin";
			}
    		else
    			return "khach"; 
        	
            //return invocation.invoke();
        	//return "";
        }
    }

}