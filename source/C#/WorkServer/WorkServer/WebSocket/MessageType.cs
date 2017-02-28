﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WorkServer
{
    public enum MessageType : int
    {
        MESSAGE =1,
        FILELIST = 2
    }
    public enum FileMessageType : byte
    {
        FileOpen = 0x0A,
        FileWrite = 0x0B,
        FileSearch = 0x0C,
        FileListNotice = 0X0D
    }
    public enum OPCODE : int
    {
        MESSAGE = 1,
        BINARY = 2,
        EXIT = 8,
        PING = 9,
        PONG = 10
    }
}
