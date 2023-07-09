package com.github.chronoselectronics.rtgpowergen.Utils;

import java.util.logging.Level;

public class LogMessage {
    public Level level;
    public String msg;

    public LogMessage(Level level, String msg) {
        this.msg = msg;
        this.level = level;
    }
}
