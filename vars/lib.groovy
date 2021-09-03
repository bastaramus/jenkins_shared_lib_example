import java.time.*
import java.text.SimpleDateFormat

/**
* @owner - Dmitriy Khomenko
* print info msg in the jenkins console
* @param message - the message to print
* Usage example: lib.Info_Msg("Hello World!")
*/
def Info_Msg(message="no message"){
    _mode="INFO"
    _date=Get_Current_Date();
    echo "[${_date}] [${_mode}] ${message}"
}

def Get_Current_Date(){
    def date = new Date()
    sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
    return sdf.format(date)
}

/**
* @owner - Dmitriy Khomenko
* Run command on any OS type
* @param _command - the command to run
* Usage example: lib.Command_Execution("whoami")
*/
def Command_Execution(_command){
    Info_Msg("Going to run [ ${_command} ]")

    if (isUnix()) {
        Info_Msg("OS type is Unix")
        _command_output = linux.Command_Execution(_command)
    } else {
        Info_Msg("OS type is Windows")
        _command_output = win.Command_Execution(_command)
    }

    return _command_output
}