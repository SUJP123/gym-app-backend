package com.collegeproject.gymappbackend.logged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoggedService {

    private LoggedDao loggedDao;

    public LoggedService(@Qualifier("postgres_logged") LoggedDao loggedDao) {
        this.loggedDao = loggedDao;
    }

    public int addLogged(Logged logged) {
        return loggedDao.insertLogged(logged);
    }
}
