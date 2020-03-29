package com.polaris.common.demo.designModel.AdapterDesign;

public class PlayerAdapter implements Player{

    private VideoPlayer videoPlayer;

    PlayerAdapter(String playName) {
        if ("VLC".equalsIgnoreCase(playName)) {
            this.videoPlayer = new VLCPlayer();
        } else if ("MP4".equalsIgnoreCase(playName)) {
            this.videoPlayer = new Mp4Player();
        }
    }

    public void play(String playName) {
        if ("VLC".equalsIgnoreCase(playName)) {
            videoPlayer.playVLC(playName);
        } else if ("MP4".equalsIgnoreCase(playName)) {
            videoPlayer.playMp4(playName);
        }
    }
}
