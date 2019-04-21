package cache;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
/*
 * 用户信息缓存
 * */
public class LoginCache {

	private static LoginCache instance = new LoginCache();
	private Map<String, String> loginUserSession = new HashMap<>();
	private Map<String, HttpSession> loginSession = new HashMap<>();
	
	private LoginCache() {
	}
	public static LoginCache getInstance() {
		return instance;
	}
	
	public String getSessionIdByUsername(String username) {
		return loginUserSession.get(username);
	}
	
	public HttpSession getSessionBySessionId(String sessionId) {
		return loginSession.get(sessionId);
	}
	
	public void setSessionIdByUsername(String username, String SessionId) {
		loginUserSession.put(username, SessionId);
	}
	
	public void setSessionBySessionId(String sessionId, HttpSession session) {
		loginSession.put(sessionId, session);
	}
}
