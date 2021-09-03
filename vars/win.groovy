/**
* @owner - Dmitriy Khomenko
* Run command on a Windows OS
* @param _command - the command to run
* Usage example: win.Command_Execution("whoami")
*/
def Command_Execution(_command){
    lib.Info_Msg("Going to run [ ${_command} ]")
    def _command_output = powershell returnStdout: true, script: "${_command}"
    _command_output = _command_output.trim()
    lib.Info_Msg(_command_output)
    return _command_output
}