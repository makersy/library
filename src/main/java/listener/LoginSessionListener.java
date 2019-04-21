package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cache.LoginCache;

/**
 * Application Lifecycle Listener implementation class LoginSessionListener
 *
 */
@WebListener
public class LoginSessionListener implements HttpSessionAttributeListener {

	private static final String LOGIN_USER = "loginUser";
    /**
     * Default constructor. 
     */
    public LoginSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         String attrName = se.getName();
         
         if( LOGIN_USER.equals(attrName) ) {
        	 String attrVal = (String)se.getValue();//当前登录用户名
        	 HttpSession session = se.getSession();//当前登录session
        	 String sessionId = session.getId();  //sessionId --> 当前登录的用户名对应的sessionid
        	 
        	 /*
        	  * sessionId2 --> 当前登录用户名在已有session池里对应的sessionId,若此值不为null则说明此用户之前登陆过，
        	  *   之前登录的sessionId就是sessionId2。
        	  * 因此要把之前的session清除掉，来保证新的登录可以挤掉旧的，即同一时间只有一个用户在线。
        	  */
        	 String sessionId2 = LoginCache.getInstance().getSessionIdByUsername(attrVal);
        	 
        	 if( null==sessionId2 || sessionId.equals(sessionId2) ) {
        		 
        	 }else {
        		 HttpSession session2 = LoginCache.getInstance().getSessionBySessionId(sessionId2);
        		 session2.invalidate();
        	 }
        	 LoginCache.getInstance().setSessionIdByUsername(attrVal, sessionId);
        	 LoginCache.getInstance().setSessionBySessionId(sessionId, session);
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
