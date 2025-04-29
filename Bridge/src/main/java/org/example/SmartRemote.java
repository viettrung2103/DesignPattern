package org.example;

public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command){
        System.out.println("voiceControl activated");
        doCommand(command);
    }

    private void doCommand(String command){
        switch(command.toLowerCase()){
            case "mute":
                mute();
                break;
            case "power":
                power();
                break;
            case "volumndown":
                volumeDown();
                break;
            case "volumnup":
                volumeUp();
                break;
            case "channelup":
                channelUp();
                break;
            case "channeldown":
                channelDown();
                break;
            default:
        }
    }
}
