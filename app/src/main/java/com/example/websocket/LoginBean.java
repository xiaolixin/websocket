package com.example.websocket;

public class LoginBean {

    /**
     * onlineUsers : null
     * onlineCount : 0
     * user : {"userid":"1554799476751182.0","username":"按你说的"}
     */

    private Object onlineUsers;
    private int onlineCount;
    private UserBean user;

    public Object getOnlineUsers() {
        return onlineUsers;
    }

    public void setOnlineUsers(Object onlineUsers) {
        this.onlineUsers = onlineUsers;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * userid : 1554799476751182.0
         * username : 按你说的
         */

        private String userid;
        private String username;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
