/**
* @owner - Dmitriy Khomenko
* Run command on a Linux OS
* @param _command - the command to run
* Usage example: linux.Command_Execution("whoami")
*/
def Command_Execution(_command){
    lib.Info_Msg("Going to run [ ${_command} ]")
    def _command_output = sh (
        script: "${_command}",
        returnStdout: true
    ).trim().replace('"', "");
    lib.Info_Msg(_command_output)
    return _command_output
}