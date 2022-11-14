package org.example.overview.cookies;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CookieMgr {
    private CookieMgr(){

    }
    public void create(HttpServletResponse response, String name, String value){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(24*60*60);
        cookie.setPath("/");

        response.addCookie(cookie);
    }
    public void creates(HttpServletResponse response, String[] names, String[] values){
        if(names.length != values.length)return;

        for (int i = 0; i <names.length; i++) {
            create(response,names[i],values[i]);
        }
    }
    public String get(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie:cookies) {
                if(cookie.getName()!=null){
                    if (cookie.getName().equals(name)){
                        return cookie.getValue();
                    }
                }
            }
        }
        return null;
    }
    public String[] gets(HttpServletRequest request, String[] names){
        String[] values = new String[names.length];
        if(names==null)return null;

        Cookie[] cookies = request.getCookies();
        if (cookies==null)return null;

        for (int i = 0; i < names.length; i++) {
            if (names[i]==null)continue;
            for (Cookie cookie:cookies) {
                if(cookie.getName()==null)continue;
                if (names[i].equals(cookie.getName())){
                    values[i]=cookie.getValue();
                }
            }
        }
        return values;
    }
}
